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

import com.patabendi.dao.ProjectDAO;
import com.patabendi.model.Project;

@Path("/project")
public class ProjectService {
	
	@GET
	@Path("/getAllProjects")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> getAllProjects() {
		List<Project> listOfProjects = ProjectDAO.getAllProjects();
        return listOfProjects;
	}
	
	@GET
	@Path("/getProject/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Project getProject(@PathParam("projectId") String project_id) {
		Project project = ProjectDAO.getProject(project_id);
		return project;
	}
	
	@POST
	@Path("/addProject")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addProject(Project project) {
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.save(project);
	}
	
	@PUT
	@Path("/updateProject")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateProject (Project project) {
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.update(project);
		System.out.println("---Data updated---");
	}
	
	@DELETE
	@Path("/deleteProject/{projectId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteProject(@PathParam("projectId") String project_id) {
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.deleteProject(project_id);
		System.out.println("---Data deleted---");
	}
	
	@GET
	@Path("{managerId}/allProjects")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> getAllEmployeesByProjectId(@PathParam("managerId") String manager_id){
		List<Project> listOfProjects = ProjectDAO.getAllProjectsByManager(manager_id);
        return listOfProjects;
	}

}
