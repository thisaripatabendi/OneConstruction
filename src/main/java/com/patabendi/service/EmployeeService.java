package com.patabendi.service;

import java.util.List;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.patabendi.dao.EmployeeDAO;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Employee;

public class EmployeeService {
	
	final static Logger logger = Logger.getLogger(EmployeeService.class);

	public static List<Employee> getAllEmployees() {
		
		List<Employee> listOfEMployees = EmployeeDAO.getAllEmployees();
		
		if (listOfEMployees.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
        return listOfEMployees;
	}
	
	public static Employee getEmployee(@PathParam("emp_id") int emp_id) {
		
		Employee employee = EmployeeDAO.getEmployee(emp_id);
		
		if(employee==null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}else {
			return employee;
		}
		
	}
	
    public static void addEmployee(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.save(emp);
	}
	
	public static void updateEmployee(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		
		if(empDAO.update(emp)==0) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		logger.info("Employee updated.");
	}
	
	public static void deleteEmployee(@PathParam("emp_id") int emp_id) {
		EmployeeDAO empDAO = new EmployeeDAO();
		
		if(empDAO.deleteEmployee(emp_id)==0) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		logger.info("Employee Deleted.");
	
	}
	
	public static List<Employee> getAllEmployeesByProjectId(@PathParam("project_id") int project_id){
		List<Employee> listOfEMployees = EmployeeDAO.getAllEmployeesByProject(project_id);
		if(listOfEMployees.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());
		}else {
			return listOfEMployees;
		}
	}

	public static List<Employee> getAllEmployeesUnderManager(int manager_id) {
		List<Employee> listOfEMployees = EmployeeDAO.getAllEmployeesByManager(manager_id);
		if(listOfEMployees.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());
		}else {
			return listOfEMployees;
		}
	}
		
	
}
