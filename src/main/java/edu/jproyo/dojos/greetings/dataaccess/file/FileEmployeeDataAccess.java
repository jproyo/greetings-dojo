package edu.jproyo.dojos.greetings.dataaccess.file;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess;
import edu.jproyo.dojos.greetings.model.Employee;
import edu.jproyo.dojos.greetings.model.EmployeeResult;

/**
 * The Class FileEmployeeDataAccess.
 */
public class FileEmployeeDataAccess implements EmployeeDataAccess {
	
	/** The Constant DEFAULT_FILE_CLASSPATH. */
	private static final String DEFAULT_FILE_CLASSPATH = "data-employees.csv";
	
	/** The mapper. */
	private EmployeeMapper mapper = new EmployeeMapper();
	
	/** The file path. */
	private String filePath;

	/* (non-Javadoc)
	 * @see edu.jproyo.dojos.greetings.dataaccess.EmployeeDataAccess#loadEmployees()
	 */
	@Override
	public Optional<EmployeeResult> loadEmployees() {
		try {
			File file = Paths.get(Optional.ofNullable(filePath)
					.map(URI::create)
					.orElse(Thread.currentThread().getContextClassLoader().getResource(DEFAULT_FILE_CLASSPATH).toURI()))
					.toFile();
			try(FileReader reader = new FileReader(file); CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()){
			    List<Employee> employees = csvReader.readAll().stream().map(mapper::buildFrom).collect(Collectors.toList());
				return Optional.of(EmployeeResult.createFrom(employees));
			}catch(Exception e){
			}
		} catch (Exception e) {
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
	
	/**
	 * Sets the mapper.
	 *
	 * @param mapper the new mapper
	 */
	public void setMapper(EmployeeMapper mapper) {
		this.mapper = mapper;
	}

}
