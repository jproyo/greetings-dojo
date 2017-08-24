package edu.jproyo.dojos.greetings.model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testIsTodayBirthdayReturnTrue() {
		Employee employee = new Employee();
		employee.setDateOfBirth(new Date());
		assertTrue(employee.isTodayBirthday());
	}

	@Test
	public void testIsTodayBirthdayReturnFalse() {
		Employee employee = new Employee();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DATE, -1);
		employee.setDateOfBirth(instance.getTime());
		assertFalse(employee.isTodayBirthday());
	}

}
