package edu.jproyo.dojos.greetings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import edu.jproyo.dojos.greetings.adapter.email.EmailSenderAdapter;
import edu.jproyo.dojos.greetings.adapter.email.SendResult;
import edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess;
import edu.jproyo.dojos.greetings.model.Employee;
import edu.jproyo.dojos.greetings.model.EmployeeResult;
import edu.jproyo.dojos.greetings.services.notification.NotificationServiceImpl;
import edu.jproyo.dojos.greetings.services.notification.strategy.EmailStrategy;

@RunWith(MockitoJUnitRunner.class)
public class GreetingsIntegrationTest {
	
	private Greetings target; 

	@Test
	public void testGreetingsWithDefaults() {
		EmailStrategy strategies = new EmailStrategy();
		EmailSenderAdapter emailAdapter = Mockito.mock(EmailSenderAdapter.class);
		strategies.setAdapter(emailAdapter);
		NotificationServiceImpl notificationService = NotificationServiceImpl.create().withStrategy(strategies).build();
		target = Greetings.create().notificationService(notificationService).buildWithDefaults();
		GreetingResult result = target.sayGreetings();
		assertNotNull(result);
		assertEquals(GreetingResult.OK, result);
	}
	
	@Test
	public void testGreetingsWithNotFoundEmployees() {
		EmailStrategy strategies = new EmailStrategy();
		EmailSenderAdapter emailAdapter = Mockito.mock(EmailSenderAdapter.class);
		strategies.setAdapter(emailAdapter);
		NotificationServiceImpl notificationService = NotificationServiceImpl.create().withStrategy(strategies).build();
		EmployeeDataAccess employeeDataAccess = Mockito.mock(EmployeeDataAccess.class);
		target = Greetings.create().notificationService(notificationService).employeeDataAccess(employeeDataAccess).buildWithDefaults();
		Mockito.when(employeeDataAccess.loadEmployees()).thenReturn(Optional.empty());
		GreetingResult result = target.sayGreetings();
		assertNotNull(result);
		assertEquals(GreetingResult.NOT_FOUND, result);
	}
	
	@Test
	public void testGreetingsWithFailingStrategies() {
		EmailStrategy strategies = new EmailStrategy();
		EmailSenderAdapter emailAdapter = Mockito.mock(EmailSenderAdapter.class);
		strategies.setAdapter(emailAdapter);
		Mockito.when(emailAdapter.sendEmail(Mockito.any(Employee.class))).thenReturn(SendResult.NOT_SENT);
		NotificationServiceImpl notificationService = NotificationServiceImpl.create().withStrategy(strategies).build();
		EmployeeDataAccess employeeDataAccess = Mockito.mock(EmployeeDataAccess.class);
		Employee employee = new Employee();
		employee.setDateOfBirth(new Date());
		EmployeeResult employeeResult = EmployeeResult.createFrom(Arrays.asList(employee));
		Mockito.when(employeeDataAccess.loadEmployees()).thenReturn(Optional.ofNullable(employeeResult));
		target = Greetings.create().notificationService(notificationService).employeeDataAccess(employeeDataAccess).buildWithDefaults();
		GreetingResult result = target.sayGreetings();
		assertNotNull(result);
		assertEquals(GreetingResult.FAILED, result);
	}
	
	
}
