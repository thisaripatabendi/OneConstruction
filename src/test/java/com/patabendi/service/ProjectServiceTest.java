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

import com.patabendi.entrypoints.Projects;
import com.patabendi.model.Project;

public class ProjectServiceTest extends JerseyTest {
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(Projects.class);
    }
	
	@Test
	public void TestGetAllProjects() {
		Response output = target("/project/getAllProjects").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
	}

	@Test
    public void testGetProject(){
        Response output = target("/project/getProject/2").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return Employee", output.getEntity());
    }
	
	@Test
    public void testGetProject_InvalidId() {
		/*exceptionRule.expect(NumberFormatException.class);
	    exceptionRule.expectMessage("For input string");*/
    	Response output = target("/project/getProject/603").request().get();
        assertEquals("Should return status 204", 204, output.getStatus());
    }
	
	@Test
    public void testGetProject_DoesNotHaveId() {
    	Response output = target("/project/getProject/").request().get();
        assertEquals("Should return status 404", 404, output.getStatus());
    }
	
	@Test
    public void testAddProject(){
    	Project project = new Project(1, "Dell", "Earth", 2);
    	Response output = target("/project/addProject").request().post(Entity.entity(project, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
        assertNotNull("Should return project", output.getEntity());
    }
	
	@Test
    public void testUpdateProject(){
    	Project project = new Project(1, "NYL", "Earth", 2);
    	Response output = target("/project/updateProject").request().put(Entity.entity(project, MediaType.APPLICATION_XML));
    	assertEquals("Should return 204", 204, output.getStatus());
    }
	
	@Test
    public void testDeleteProject() {
    	Response output = target("/project/deleteProject/11").request().delete();
    	assertEquals("Should return status 204", 204, output.getStatus());
    }
	
	@Test
    public void testGetAllProjectsByManagerId() {
    	Response output = target("/project/2/allProjects").request().get();
    	assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
	
	@Test
    public void testGetAllProjectsByManagerId_NoProjectId() {
    	Response output = target("/project//allProjects").request().get();
    	assertEquals("should return status 404", 404, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }
	
	@Test
    public void testGetAllProjectsByManagerId_InvalidProjectId() {
    	Response output = target("/project/101/allProjects").request().get();
    	assertEquals("should return status 400", 400, output.getStatus());
    }
	
}
