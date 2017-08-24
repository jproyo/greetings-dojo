package edu.jproyo.dojos.greetings.services.notification;

import java.util.Set;

import edu.jproyo.dojos.greetings.GreetingResult;
import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Interface NotificationService.
 */
public interface NotificationService {

	/**
	 * Greeting.
	 *
	 * @param toBeGreeting the to be greeting
	 * @return the greeting result
	 */
	GreetingResult greeting(Set<Employee> toBeGreeting);

}
