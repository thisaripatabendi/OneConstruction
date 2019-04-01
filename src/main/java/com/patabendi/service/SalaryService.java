package com.patabendi.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.patabendi.dao.EmployeeDAO;
import com.patabendi.model.ProjectSalarySum;

@Path("/salaries")
public class SalaryService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ProjectSalarySum> getSalaries() {
		List<ProjectSalarySum> listOfProjects = EmployeeDAO.getSalaries();
		
		for (ProjectSalarySum employee : listOfProjects) {
			System.out.println(employee.getProject_name() + " : $" + employee.getSalary_sum());
		}
		return listOfProjects;
	}

}
