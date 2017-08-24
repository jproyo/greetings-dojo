package edu.jproyo.dojos.greetings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

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
