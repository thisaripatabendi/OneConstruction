package com.patabendi.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.patabendi.dao.EmployeeDAO;
import com.patabendi.model.Employee;

@Path("/salaries")
public class SalaryService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getSalaries() {
		List<Employee> listOfProjects = EmployeeDAO.getSalaries();
		for (Employee employee : listOfProjects) {
			System.out.println(employee.getProject_id().replaceAll(" ","") + " : $" + employee.getEmp_salary());
		}
		return listOfProjects;
	}

}
