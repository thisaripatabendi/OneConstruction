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

import com.patabendi.entrypoints.ProjectManagers;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.model.ProjectManager;

public class ProjectManagerServiceTest extends JerseyTest{
	
	@Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(ProjectManagers.class);
    }
	
	@Test
	public void TestGetAllManagers() {
		Response output = target("/manager/getAllManagers").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
	}
	
	@Test
	public void TestGetManager() {
		Response output = target("/manager/getManager/2").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertNotNull("Should return ProjectManager", output.getEntity());
	}
	
	@Test
	public void TestGetManager_NoManagerId() {
		Response output = target("/manager/getManager/").request().get();
		assertEquals("Should return status 404", 404, output.getStatus());
	}
	
	@Test
	public void TestGetManager_InvalidId() {
		Response output = target("/manager/getManager/1154").request().get();
		assertEquals("Should return status 500", 500, output.getStatus());
		assertNotNull("Should return ErrorMessage", output.getEntity());
	}
	
	@Test
    public void testAddManager(){
    	ProjectManager emp = new ProjectManager(100, "Alan", "alan55@gmail.com", "0715486254");
    	Response output = target("/manager/addManager").request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
        /*assertNotNull("Should return projectManager", output.getEntity());*/
    }

	@Test
    public void testUpdateManager(){
		ProjectManager emp = new ProjectManager(1, "Alan", "alan@gmail.com", "0715486254");
    	Response output = target("/manager/updateManager").request().put(Entity.entity(emp, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
    }
}
