package edu.jproyo.dojos.greetings.model;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class Employees.
 */
public class EmployeeResult {
	
	/** The employees. */
	private Set<Employee> employees;
	
	/**
	 * Birthdays employees.
	 *
	 * @return the optional
	 */
	public Optional<Set<Employee>> birthdaysEmployees() {
		return Optional.ofNullable(employees.stream().filter(Employee::isTodayBirthday).collect(Collectors.toSet()));
	}

	/**
	 * Creates the from.
	 *
	 * @param employees the employees
	 * @return the employees
	 */
	public static EmployeeResult createFrom(List<Employee> employees) {
		EmployeeResult target = new EmployeeResult();
		target.employees = new HashSet<>(employees);
		return target;
	}


}
