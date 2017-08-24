package edu.jproyo.dojos.greetings.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Employees {
	
	private Set<Employee> employees = new HashSet<>();

	public Optional<Set<Employee>> birthdaysEmployees() {
		return Optional.ofNullable(employees.stream().filter(Employee::isTodayBirthday).collect(Collectors.toSet()));
	}

}
