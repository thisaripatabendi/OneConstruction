package com.patabendi.entrypoints;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.patabendi.model.Employee;
import com.patabendi.service.EmployeeService;

@Path("/employee")
public class Employees {
	
	@GET
	@Path("/getAllEmployees")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getAllEmployees() {
		List<Employee> listOfEMployees = EmployeeService.getAllEmployees();
        return listOfEMployees;
	}
	
	@GET
	@Path("/getEmployee/{emp_id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployee(@PathParam("emp_id") int emp_id) {
		Employee employee = EmployeeService.getEmployee(emp_id);
		return employee;
	}
	
	@POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addEmployee(Employee emp) {
		EmployeeService.addEmployee(emp);
	}
	
	@PUT
	@Path("/updateEmployee")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateEmployee(Employee emp) {
		EmployeeService.updateEmployee(emp);
	}
	
	@DELETE
	@Path("/deleteEmployee/{emp_id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteEmployee(@PathParam("emp_id") int emp_id) {
		EmployeeService.deleteEmployee(emp_id);
	}
	
	@GET
	@Path("{project_id}/allEmployee")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getAllEmployeesByProjectId(@PathParam("project_id") int project_id){
		List<Employee> listOfEMployees = EmployeeService.getAllEmployeesByProjectId(project_id);
        return listOfEMployees;
	}

}
