package edu.jproyo.dojos.greetings.services.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.jproyo.dojos.greetings.GreetingResult;
import edu.jproyo.dojos.greetings.model.Employee;
import edu.jproyo.dojos.greetings.services.notification.strategy.EmailStrategy;

/**
 * The Class NotificationServiceImpl.
 */
public class NotificationServiceImpl implements NotificationService {
	
	/** The strategies. */
	private List<NotificationStrategy> strategies = new ArrayList<>();	

	/* (non-Javadoc)
	 * @see edu.jproyo.dojos.greetings.services.notification.NotificationService#greeting(java.util.Set)
	 */
	@Override
	public GreetingResult greeting(Set<Employee> toBeGreeting) {
		boolean result = strategies.stream().map(strategy -> strategy.notification(toBeGreeting)).anyMatch(notifResult -> notifResult.equals(NotificationResult.FAILED));
		if(result) return GreetingResult.FAILED;
		return GreetingResult.OK;
	}
	
	
	/**
	 * Sets the strategies.
	 *
	 * @param strategies the new strategies
	 */
	public void setStrategies(List<NotificationStrategy> strategies) {
		this.strategies = strategies;
	}
	
	
	/**
	 * Creates the default.
	 *
	 * @return the notification service impl
	 */
	public static Builder create(){
		return new Builder();
	}
	
	/**
	 * Creates the default.
	 *
	 * @return the notification service impl
	 */
	public static NotificationServiceImpl createDefault(){
		return new Builder().withStrategy(new EmailStrategy()).build();
	}
	
	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The target. */
		private NotificationServiceImpl target = new NotificationServiceImpl();
		
		/**
		 * With strategy.
		 *
		 * @param strategies the strategies
		 * @return the builder
		 */
		public Builder withStrategy(NotificationStrategy strategies){
			target.strategies.add(strategies);
			return this;
		}
		
		/**
		 * Builds the.
		 *
		 * @return the notification service impl
		 */
		public NotificationServiceImpl build(){
			return this.target;
		}
		
		
	}

}
