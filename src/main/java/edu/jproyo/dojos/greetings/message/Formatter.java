package edu.jproyo.dojos.greetings.message;

import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Interface FormatterMessage.
 */
public interface Formatter {
	
	/**
	 * Format.
	 *
	 * @param employee the employee
	 * @return the formatted message
	 */
	Message format(Employee employee);

}
