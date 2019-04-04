package com.patabendi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.patabendi.entrypoints.Employees;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.model.Employee;

public class EmployeeServiceTest extends JerseyTest {
	
	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	@Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(Employees.class);
    }

    @Test
    public void testGetAllEmployees() {
        Response output = target("/employee/getAllEmployees").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
    
    @Test
    public void testGetEmployee(){
        Response output = target("/employee/getEmployee/1").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return Employee", output.getEntity());
    }
    
    @Test (expected = DataNotFoundException.class)
    public void testGetEmployeeFail_InvalidId() throws DataNotFoundException{
    	Response output = target("/employee/getEmployee/504").request().get();
    	//exception.expect(DataNotFoundException.class);
    	//exception.expectMessage("No record found for provided id");
        //assertEquals("Should return status 404", 404, output.getStatus());
    }
    
    @Test
    public void testGetEmployeeFail_DoesNotHaveId() {
    	Response output = target("/employee/getEmployee/").request().get();
        assertEquals("Should return status 404", 404, output.getStatus());
    }
    
    @Test
    public void testAddEmployee(){
    	Employee emp = new Employee(1, "Sam", 4500, 2, "sam@gmail.com");
    	Response output = target("/employee/").request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
        assertNotNull("Should return employee", output.getEntity());
    }
    
    @Test
    public void testUpdateEmployee(){
    	Employee emp = new Employee(1, "Arun", 4500, 2, "arun@gmail.com");
    	Response output = target("/employee/updateEmployee").request().put(Entity.entity(emp, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
    }
    
    @Test
    public void testDeleteEMployee() {
    	Response output = target("/employee/deleteEmployee/2").request().delete();
    	assertEquals("Should return status 204", 204, output.getStatus());
    }
    
    @Test
    public void testGetAllEmployeesByProjectId() {
    	Response output = target("/employee/2/allEmployee").request().get();
    	assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
    
    @Test
    public void testGetAllEmployeesByProjectId_InvalidProjectID() {
    	Response output = target("/employee/254/allEmployee").request().get();
        assertEquals("Should return status 204", 204, output.getStatus());
    }
    
    @Test
    public void testGetAllEmployeesByProjectId_NoProjectID() {
    	Response output = target("/employee//allEmployee").request().get();
    	assertEquals("Should return status 404", 404, output.getStatus());
    }

}


