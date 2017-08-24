package edu.jproyo.dojos.greetings.dataaccess.file;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.jproyo.dojos.greetings.model.Employee;

/**
 * The Class EmployeeMapper.
 */
public class EmployeeMapper {
	
	/** The Constant DATE_FORMAT. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
	
	/**
	 * Builds the from.
	 *
	 * @param row the row
	 * @return the employee
	 */
	public Employee buildFrom(String[] row){
		String lastName = row[0];
		String firstName = row[1];
		String dateOfBirth = row[2];
		String email = row[3];
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		try {
			employee.setDateOfBirth(DATE_FORMAT.parse(dateOfBirth));
		} catch (ParseException e) {
		}
		employee.setEmail(email);
		return employee;
	}

}
