package edu.jproyo.dojos.greetings;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.jproyo.dojos.greetings.Greetings;

public class GreetingsTest {
	
	private Greetings target; 

	@Test
	public void testGreetingsWithDefaults() {
		target = Greetings.create().buildWithDefaults();
		GreetingResult result = target.sayGreetings();
		assertNotNull(result);
		assertEquals(GreetingResult.OK, result);
	}

}
