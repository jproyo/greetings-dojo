package edu.jproyo.dojos.greetings;

import edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess;
import edu.jproyo.dojos.greetings.dataaccess.file.FileEmployeeDataAccess;
import edu.jproyo.dojos.greetings.model.EmployeeResult;
import edu.jproyo.dojos.greetings.services.notification.NotificationService;
import edu.jproyo.dojos.greetings.services.notification.NotificationServiceImpl;

/**
 * The Class Greetings.
 */
public class Greetings {

	/** The data access. */
	private EmployeeDataAccess dataAccess;
	
	/** The notification service. */
	private NotificationService notificationService;

	/**
	 * Say greetings.
	 *
	 * @return the greeting result
	 */
	public GreetingResult sayGreetings() {
		return this.dataAccess.loadEmployees()
			.flatMap(EmployeeResult::birthdaysEmployees)
			.map(notificationService::greeting)
			.orElse(GreetingResult.NOT_FOUND);
	}
	
	/**
	 * Sets the data access.
	 *
	 * @param dataAccess the new data access
	 */
	public void setDataAccess(EmployeeDataAccess dataAccess) {
		this.dataAccess = dataAccess;
	}
	
	/**
	 * Sets the notification service.
	 *
	 * @param notificationService the new notification service
	 */
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	/**
	 * Validate.
	 */
	public void validate() {
		if(this.dataAccess == null) throw new IllegalStateException("DataAccess Employee instance must be provided");
		if(this.notificationService == null) throw new IllegalStateException("Notification Employee instance must be provided");
	}

	/**
	 * Creates the.
	 *
	 * @return the builder
	 */
	public static Builder create() {
		return new Builder();
	}
	
	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The target. */
		private Greetings target = new Greetings();
		
		/**
		 * Employee data access.
		 *
		 * @param employeeDataAccess the employee data access
		 * @return the builder
		 */
		public Builder employeeDataAccess(EmployeeDataAccess employeeDataAccess){
			this.target.dataAccess = employeeDataAccess;
			return this;
		}

		/**
		 * Notification service.
		 *
		 * @param notificationService the notification service
		 * @return the builder
		 */
		public Builder notificationService(NotificationService notificationService){
			this.target.notificationService = notificationService;
			return this;
		}

		
		/**
		 * Builds the.
		 *
		 * @return the greetings
		 */
		public Greetings build() {
			target.validate();
			return target;
		}
		
		/**
		 * Builds the with defaults.
		 *
		 * @return the greetings
		 */
		public Greetings buildWithDefaults() {
			if(this.target.dataAccess == null){
				this.target.dataAccess = new FileEmployeeDataAccess();
			}
			if(this.target.notificationService == null){
				this.target.notificationService = new NotificationServiceImpl();
			}
			return build();
		}
		
		
	}


}
