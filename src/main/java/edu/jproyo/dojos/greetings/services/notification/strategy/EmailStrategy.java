package edu.jproyo.dojos.greetings.services.notification.strategy;

import java.util.Set;

import edu.jproyo.dojos.greetings.adapter.email.EmailSenderAdapter;
import edu.jproyo.dojos.greetings.adapter.email.SendResult;
import edu.jproyo.dojos.greetings.model.Employee;
import edu.jproyo.dojos.greetings.services.notification.NotificationResult;
import edu.jproyo.dojos.greetings.services.notification.NotificationStrategy;

/**
 * The Class EmailStrategy.
 */
public class EmailStrategy implements NotificationStrategy {
	
	/** The adapter. */
	private EmailSenderAdapter adapter;

	/* (non-Javadoc)
	 * @see edu.jproyo.dojos.greetings.services.notification.NotificationStrategy#notification(java.util.Set)
	 */
	@Override
	public NotificationResult notification(Set<Employee> employees) {
		if(employees.stream().map(e -> adapter.sendEmail(e)).allMatch(r -> r.equals(SendResult.SENT))){
			return NotificationResult.OK;
		}
		return NotificationResult.FAILED;
	}
	
	/**
	 * Sets the adapter.
	 *
	 * @param adapter the new adapter
	 */
	public void setAdapter(EmailSenderAdapter adapter) {
		this.adapter = adapter;
	}

}
