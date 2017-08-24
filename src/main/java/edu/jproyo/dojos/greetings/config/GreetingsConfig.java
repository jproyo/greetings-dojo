/**
 * Copyright (C) 2015 mxHero Inc (mxhero@mxhero.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.jproyo.dojos.greetings.config;

import java.util.Optional;

/**
 * The Enum GreetingsConfig.
 */
public enum GreetingsConfig {
	
	/**By default is going to search at ClassPath root, otherwise you should provide URL location based such as file:///opt/some/other/data.csv */
	FILE_EMPLOYEE_CSV_LOCATION("FILE_EMPLOYEES_CSV_LOCATION", "file.employees.csv.location", "data-employees.csv");
	
	/** The enviroment. */
	private String enviroment;
	
	/** The property. */
	private String property;
	
	/** The default value. */
	private String defaultValue;
	
	/**
	 * Instantiates a new enviroment.
	 *
	 * @param enviroment the enviroment
	 * @param property the property
	 * @param defaultValue the default value
	 */
	GreetingsConfig(String enviroment, String property, String defaultValue){
		this.enviroment = enviroment;
		this.property = property;
		this.defaultValue = defaultValue;
	}

	/**
	 * Value.
	 *
	 * @return the string
	 */
	public String value(){
		return Optional.ofNullable(System.getProperty(property)).orElse(Optional.ofNullable(System.getenv(enviroment)).orElse(defaultValue));
	}

	/**
	 * Int value.
	 *
	 * @return the int
	 */
	public int intValue() {
		return Integer.valueOf(value());
	}

}
