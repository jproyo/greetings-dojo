package edu.jproyo.dojos.greetings.dataaccess;

import java.util.Optional;

import edu.jproyo.dojos.greetings.model.Employees;

public interface EmployeeDataAccess {

	Optional<Employees> loadEmployees();

}
