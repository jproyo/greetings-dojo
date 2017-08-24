package edu.jproyo.dojos.greetings.message;

/**
 * The Class FormattedMessage.
 */
public class FormattedMessage {
	
	/** The Constant SUBJECT. */
	private static final String SUBJECT = "Happy birthday!";
	
	/** The Constant BODY_HTML. */
	private static final String BODY_HTML = "<html><body><p>Happy birthday, dear %s!</p></body></html>";
	
	/** The Constant BODY_TEXT. */
	private static final String BODY_TEXT = "Happy birthday, dear %s!";
	
	/** The name. */
	private String name;
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
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
		return String.format(BODY_HTML, getName());
	}

	/**
	 * Body text.
	 *
	 * @return the string
	 */
	public String bodyText(){
		return String.format(BODY_TEXT, getName());
	}

}
