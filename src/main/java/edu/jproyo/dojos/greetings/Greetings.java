package edu.jproyo.dojos.greetings;

import edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess;
import edu.jproyo.dojos.greetings.model.Employees;
import edu.jproyo.dojos.greetings.services.NotificationService;

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
			.flatMap(Employees::birthdaysEmployees)
			.map(notificationService::greeting)
			.orElse(GreetingResult.NOT_FOUND);
	}

	/**
	 * Validate.
	 */
	public void validate() {
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
		 * Builds the.
		 *
		 * @return the greetings
		 */
		public Greetings build() {
			target.validate();
			return target;
		}
		
		
	}


}
