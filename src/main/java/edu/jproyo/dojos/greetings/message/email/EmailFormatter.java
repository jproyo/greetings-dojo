package edu.jproyo.dojos.greetings.message.email;

import edu.jproyo.dojos.greetings.message.Formatter;
import edu.jproyo.dojos.greetings.message.Message;
import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Class EmailFormatter.
 */
public class EmailFormatter implements Formatter {

	/* (non-Javadoc)
	 * @see edu.jproyo.dojos.greetings.message.Formatter#format(edu.jproyo.dojos.greetings.model.Employee)
	 */
	@Override
	public Message format(Employee employee) {
		return new EmailMessage(employee);
	}

}
