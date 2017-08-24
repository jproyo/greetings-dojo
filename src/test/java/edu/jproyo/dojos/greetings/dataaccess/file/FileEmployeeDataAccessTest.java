package edu.jproyo.dojos.greetings.dataaccess.file;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import edu.jproyo.dojos.greetings.model.EmployeeResult;

public class FileEmployeeDataAccessTest {

	@Test
	public void testLoadEmployees() {
		FileEmployeeDataAccess dataAccess = new FileEmployeeDataAccess();
		Optional<EmployeeResult> loadEmployees = dataAccess.loadEmployees();
		assertNotNull(loadEmployees);
		assertTrue(loadEmployees.isPresent());
		assertNotNull(loadEmployees);
	}
	
	@Test(expected = RuntimeException.class)
	public void testLoadEmployeesWithFailingFile() {
		FileEmployeeDataAccess dataAccess = new FileEmployeeDataAccess();
		dataAccess.setFilePath("file:///some/file/wrong.csv");
		dataAccess.loadEmployees();
	}
	
	@Test(expected = RuntimeException.class)
	public void testLoadEmployeesWithWrongData() {
		FileEmployeeDataAccess dataAccess = new FileEmployeeDataAccess();
		dataAccess.setFilePath(Thread.currentThread().getContextClassLoader().getResource("wrong.csv").getPath());
		dataAccess.loadEmployees();
	}

}
