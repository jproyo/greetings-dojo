package edu.jproyo.dojos.greetings.dataaccess.file;

import java.util.Optional;

import edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess;
import edu.jproyo.dojos.greetings.model.Employees;

public class FileEmployeeDataAccess implements EmployeeDataAccess {

	@Override
	public Optional<Employees> loadEmployees() {
		return Optional.of(new Employees());
	}

}
