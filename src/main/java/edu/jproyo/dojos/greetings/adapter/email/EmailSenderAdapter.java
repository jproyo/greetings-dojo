package edu.jproyo.dojos.greetings.adapter.email;

import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Interface EmailSenderAdapter.
 */
public interface EmailSenderAdapter {
	
	/**
	 * Send email.
	 *
	 * @param employee the employee
	 */
	public void sendEmail(Employee employee);

}
