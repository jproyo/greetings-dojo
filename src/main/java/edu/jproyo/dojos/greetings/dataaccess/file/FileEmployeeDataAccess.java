package edu.jproyo.dojos.greetings.dataaccess.file;

import java.io.FileReader;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.opencsv.bean.CsvToBeanBuilder;

import edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess;
import edu.jproyo.dojos.greetings.model.Employee;
import edu.jproyo.dojos.greetings.model.EmployeeResult;

/**
 * The Class FileEmployeeDataAccess.
 */
public class FileEmployeeDataAccess implements EmployeeDataAccess {
	
	/** The Constant DEFAULT_FILE_CLASSPATH. */
	private static final String DEFAULT_FILE_CLASSPATH = "data-employees.csv";
	
	/** The file path. */
	private String filePath;

	/* (non-Javadoc)
	 * @see edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess#loadEmployees()
	 */
	@Override
	public Optional<EmployeeResult> loadEmployees() {
		Path path = Optional.ofNullable(filePath)
			.map(p -> Paths.get(URI.create(p)))
			.orElse(Paths.get(DEFAULT_FILE_CLASSPATH));
		try(FileReader reader = new FileReader(path.toFile())){
			List<Employee> beans = new CsvToBeanBuilder<Employee>(reader).withType(Employee.class).build().parse();
			return Optional.of(EmployeeResult.createFrom(beans));
		}catch(Exception e){
		}
		return Optional.empty();
	}
	
	/**
	 * Sets the file path.
	 *
	 * @param filePath the new file path
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
