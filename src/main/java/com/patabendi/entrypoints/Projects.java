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

import com.patabendi.model.Project;
import com.patabendi.service.ProjectService;

@Path("/project")
public class Projects {
	
	@GET
	@Path("/getAllProjects")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> getAllProjects() {
		List<Project> listOfProjects = ProjectService.getAllProjects();
        return listOfProjects;
	}
	
	@GET
	@Path("/getProject/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Project getProject(@PathParam("projectId") int project_id) {
		Project project = ProjectService.getProject(project_id);
		return project;
	}
	
	@POST
	@Path("/addProject")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addProject(Project project) {
		ProjectService.addProject(project);
	}
	
	@PUT
	@Path("/updateProject")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateProject (Project project) {
		ProjectService.updateProject(project);
	}
	
	@DELETE
	@Path("/deleteProject/{projectId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteProject(@PathParam("projectId") int project_id) {
		ProjectService.deleteProject(project_id);
	}
	
	@GET
	@Path("{managerId}/allProjects")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Project> getAllProjectsByManagerId(@PathParam("managerId") int manager_id){
		List<Project> listOfProjects = ProjectService.getAllEmployeesByProjectId(manager_id);
        return listOfProjects;
	}

}
