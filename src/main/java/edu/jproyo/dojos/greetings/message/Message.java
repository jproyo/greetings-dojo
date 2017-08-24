package edu.jproyo.dojos.greetings.message;

import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Class FormattedMessage.
 */
public class Message {

	
	/** The name. */
	private Employee employee;
	
	/**
	 * Instantiates a new message.
	 *
	 * @param employee the employee
	 */
	public Message(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

}
