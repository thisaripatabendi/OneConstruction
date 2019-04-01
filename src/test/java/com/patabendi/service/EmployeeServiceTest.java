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
import org.junit.Test;

import com.patabendi.model.Employee;

public class EmployeeServiceTest extends JerseyTest {
	
	@Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(EmployeeService.class);
    }

    @Test
    public void testGetAllEmployees() {
        Response output = target("/employee/getAllEmployees").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
    
    @Test
    public void testGetEmployee(){
        Response output = target("/employee/getEmployee/E01").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return Employee", output.getEntity());
    }
    
    @Test
    public void testGetEmployeeFail_InvalidId() {
    	Response output = target("/employee/getEmployee/invalid-id").request().get();
        assertEquals("Should return status 204", 204, output.getStatus());
    }
    
    @Test
    public void testGetEmployeeFail_DoesNotHaveId() {
    	Response output = target("/employee/getEmployee/").request().get();
        assertEquals("Should return status 404", 404, output.getStatus());
    }
    
    @Test
    public void testAddEmployee(){
    	Employee emp = new Employee("E01", "Sam", 4500, "P05", "sam@gmail.com");
    	Response output = target("/employee/").request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
        assertNotNull("Should return employee", output.getEntity());
    }
    
    @Test
    public void testUpdateEmployee(){
    	Employee emp = new Employee("E01", "Arun", 4500, "P05", "arun@gmail.com");
    	Response output = target("/employee/updateEmployee").request().put(Entity.entity(emp, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
    }
    
    @Test
    public void testDeleteEMployee() {
    	Response output = target("/employee/deleteEmployee/E02").request().delete();
    	assertEquals("Should return status 204", 204, output.getStatus());
    }
    
    @Test
    public void testGetAllEmployeesByProjectId() {
    	Response output = target("/employee/P05/allEmployee").request().get();
    	assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
    
    @Test
    public void testGetAllEmployeesByProjectId_InvalidProjectID() {
    	Response output = target("/employee/invalid-id/allEmployee").request().get();
        assertEquals("Should return status 204", 204, output.getStatus());
    }
    
    @Test
    public void testGetAllEmployeesByProjectId_NoProjectID() {
    	Response output = target("/employee//allEmployee").request().get();
    	assertEquals("Should return status 404", 404, output.getStatus());
    }

}


