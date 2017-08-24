package edu.jproyo.dojos.greetings.services.notification;

import java.util.Set;

import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Interface NotificationStrategy.
 */
public interface NotificationStrategy {
	
	/**
	 * Notify.
	 *
	 * @param employee the employee
	 */
	NotificationResult notification(Set<Employee> employees);

}
