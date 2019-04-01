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

import com.patabendi.model.Project;

public class ProjectServiceTest extends JerseyTest {
	
	@Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(ProjectService.class);
    }
	
	@Test
	public void TestGetAllProjects() {
		Response output = target("/project/getAllProjects").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
	}

	@Test
    public void testGetProject(){
        Response output = target("/project/getProject/P05").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return Employee", output.getEntity());
    }
	
	@Test
    public void testGetProject_InvalidId() {
    	Response output = target("/project/getProject/invalid-id").request().get();
        assertEquals("Should return status 204", 204, output.getStatus());
    }
	
	@Test
    public void testGetProject_DoesNotHaveId() {
    	Response output = target("/project/getProject/").request().get();
        assertEquals("Should return status 404", 404, output.getStatus());
    }
	
	@Test
    public void testAddProject(){
    	Project project = new Project("P01", "Dell", "Earth", "M02");
    	Response output = target("/project/addProject").request().post(Entity.entity(project, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
        assertNotNull("Should return project", output.getEntity());
    }
	
	@Test
    public void testUpdateProject(){
    	Project project = new Project("P01", "NYL", "Earth", "M02");
    	Response output = target("/project/updateProject").request().put(Entity.entity(project, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
    }
	
	@Test
    public void testDeleteProject() {
    	Response output = target("/project/deleteProject/P011").request().delete();
    	assertEquals("Should return status 204", 204, output.getStatus());
    }
	
	@Test
    public void testGetAllEmployeesByProjectId() {
    	Response output = target("/project/M02/allProjects").request().get();
    	assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
	
	@Test
    public void testGetAllEmployeesByProjectId_NoProjectId() {
    	Response output = target("/project//allProjects").request().get();
    	assertEquals("should return status 404", 404, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
	
	@Test
    public void testGetAllEmployeesByProjectId_InvalidProjectId() {
    	Response output = target("/project/invalid-id/allProjects").request().get();
    	assertEquals("should return status 204", 204, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
	
}
