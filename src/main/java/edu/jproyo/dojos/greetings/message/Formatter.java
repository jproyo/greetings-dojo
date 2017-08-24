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
	default FormattedMessage format(Employee employee){
		FormattedMessage formattedMessage = new FormattedMessage();
		formattedMessage.setName(employee.getFirstName());
		return formattedMessage;
	}

}
