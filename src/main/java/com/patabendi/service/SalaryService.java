package com.patabendi.service;

import java.util.List;
import com.patabendi.dao.EmployeeDAO;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.ProjectSalarySum;

public class SalaryService {

	public static List<ProjectSalarySum> getSalaries() {
		List<ProjectSalarySum> listOfProjects = EmployeeDAO.getSalaries();
		
		if (listOfProjects.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());
		} else {
			for (ProjectSalarySum employee : listOfProjects) {
				System.out.println(employee.getProject_name() + " : $" + employee.getSalary_sum());
			}
			return listOfProjects;
		}	
		
	}

}
