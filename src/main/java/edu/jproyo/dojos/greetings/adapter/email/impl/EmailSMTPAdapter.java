package edu.jproyo.dojos.greetings.adapter.email.impl;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;

import edu.jproyo.dojos.greetings.adapter.email.EmailSenderAdapter;
import edu.jproyo.dojos.greetings.adapter.email.SendResult;
import edu.jproyo.dojos.greetings.message.email.EmailFormatter;
import edu.jproyo.dojos.greetings.message.email.EmailMessage;
import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Class EmailSMTPAdapter.
 */
public class EmailSMTPAdapter implements EmailSenderAdapter {

	/* (non-Javadoc)
	 * @see edu.jproyo.dojos.greetings.adapter.email.EmailSenderAdapter#sendEmail(edu.jproyo.dojos.greetings.model.Employee)
	 */
	@Override
	public SendResult sendEmail(Employee employee) {
		try {
			EmailFormatter formatter = new EmailFormatter();
			EmailMessage message = (EmailMessage) formatter.format(employee);
			Email email = new EmailBuilder()
					.from("Greetings Hello", "no-reply@greetings-hello.com")
					.to(employee.fullName(), employee.getEmail())
					.subject(message.subject())
					.textHTML(message.bodyHtml())
					.text(message.bodyText())
					.build();
			new Mailer().sendMail(email);
			return SendResult.SENT;
		} catch (Exception e) {
			return SendResult.NOT_SENT;
		}
	}

}
