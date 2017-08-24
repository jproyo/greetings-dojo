package edu.jproyo.dojos.greetings.dataaccess;

import java.util.Optional;

import edu.jproyo.dojos.greetings.model.EmployeeResult;

/**
 * The Interface EmployeeDataAccess.
 */
public interface EmployeeDataAccess {

	/**
	 * Load employees.
	 *
	 * @return the optional
	 */
	Optional<EmployeeResult> loadEmployees();

}
