package edu.jproyo.dojos.greetings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.jproyo.dojos.greetings.adapter.email.EmailSenderAdapter;
import edu.jproyo.dojos.greetings.services.notification.NotificationServiceImpl;
import edu.jproyo.dojos.greetings.services.notification.strategy.EmailStrategy;

@RunWith(MockitoJUnitRunner.class)
public class GreetingsTest {
	
	private Greetings target; 
	
	@Mock
	private EmailSenderAdapter emailAdapter;

	@Test
	public void testGreetingsWithDefaults() {
		EmailStrategy strategies = new EmailStrategy();
		strategies.setAdapter(emailAdapter);
		NotificationServiceImpl notificationService = NotificationServiceImpl.create().withStrategy(strategies).build();
		target = Greetings.create().notificationService(notificationService).buildWithDefaults();
		GreetingResult result = target.sayGreetings();
		assertNotNull(result);
		assertEquals(GreetingResult.OK, result);
	}
}
