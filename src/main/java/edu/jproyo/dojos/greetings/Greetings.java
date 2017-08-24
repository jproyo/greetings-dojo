package edu.jproyo.dojos.greetings;

/**
 * The Class Greetings.
 */
public class Greetings {

	/**
	 * Validate.
	 */
	public void validate() {
	}

	/**
	 * Creates the.
	 *
	 * @return the builder
	 */
	public static Builder create() {
		return new Builder();
	}
	
	/**
	 * The Class Builder.
	 */
	public static class Builder {
		
		/** The target. */
		private Greetings target = new Greetings();

		/**
		 * Builds the.
		 *
		 * @return the greetings
		 */
		public Greetings build() {
			target.validate();
			return target;
		}
		
		
	}

	public GreetingResult sayGreetings() {
		return GreetingResult.OK;
	}


}
