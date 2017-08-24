package edu.jproyo.dojos.greetings.dataaccess;

import java.util.Optional;

import edu.jproyo.dojos.greetings.model.Employees;

/**
 * The Interface EmployeeDataAccess.
 */
public interface EmployeeDataAccess {

	/**
	 * Load employees.
	 *
	 * @return the optional
	 */
	Optional<Employees> loadEmployees();

}
