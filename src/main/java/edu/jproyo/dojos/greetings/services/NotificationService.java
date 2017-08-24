package edu.jproyo.dojos.greetings.services;

import java.util.Set;

import edu.jproyo.dojos.greetings.GreetingResult;
import edu.jproyo.dojos.greetings.model.Employee;

public interface NotificationService {

	GreetingResult greeting(Set<Employee> toBeGreeting);

}
