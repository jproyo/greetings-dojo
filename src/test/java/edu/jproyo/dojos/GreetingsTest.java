package edu.jproyo.dojos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingsTest {
	
	private Greetings target; 

	@Test
	public void testGreetings() {
		target = Greetings.create().build();
		GreetingResult result = target.sayGreetings();
		assertNotNull(result);
	}

}
