package edu.jproyo.dojos.greetings.message.email;

import edu.jproyo.dojos.greetings.message.Message;
import edu.jproyo.dojos.greetings.model.Employee;

public class EmailMessage extends Message {
	
	/** The Constant SUBJECT. */
	private static final String SUBJECT = "Happy birthday!";
	
	/** The Constant BODY_HTML. */
	private static final String BODY_HTML = "<html><body><p>Happy birthday, dear %s!</p></body></html>";
	
	/** The Constant BODY_TEXT. */
	private static final String BODY_TEXT = "Happy birthday, dear %s!";

	public EmailMessage(Employee employee) {
		super(employee);
	}

	/**
	 * Subject.
	 *
	 * @return the string
	 */
	public String subject(){
		return SUBJECT;
	}

	/**
	 * Body html.
	 *
	 * @return the string
	 */
	public String bodyHtml(){
		return String.format(BODY_HTML, getEmployee().getFirstName());
	}

	/**
	 * Body text.
	 *
	 * @return the string
	 */
	public String bodyText(){
		return String.format(BODY_TEXT, getEmployee().getFirstName());
	}
	
}
