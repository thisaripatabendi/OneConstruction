package com.patabendi.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.patabendi.dao.EmployeeDAO;
import com.patabendi.model.Employee;


@Path("/employee")
public class EmployeeService {
	
	@GET
	@Path("/getAllEmployees")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getAllEmployees() {
		List<Employee> listOfEMployees = EmployeeDAO.getAllEmployees();
        return listOfEMployees;
	}
	
	@GET
	@Path("/getEmployee/{emp_id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployee(@PathParam("emp_id") int emp_id) {
		Employee employee = EmployeeDAO.getEmployee(emp_id);
		return employee;
	}
	
	@POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addEmployee(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.save(emp);
	}
	
	@PUT
	@Path("/updateEmployee")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateEmployee(Employee emp) {
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.update(emp);
	    System.out.println("---Data updated---");
	}
	
	@DELETE
	@Path("/deleteEmployee/{emp_id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteEmployee(@PathParam("emp_id") int emp_id) {
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.deleteEmployee(emp_id);
		System.out.println("---Data deleted---");
	}
	
	@GET
	@Path("{project_id}/allEmployee")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getAllEmployeesByProjectId(@PathParam("project_id") int project_id){
		List<Employee> listOfEMployees = EmployeeDAO.getAllEmployeesByProject(project_id);
        return listOfEMployees;
	}
		
	
}
