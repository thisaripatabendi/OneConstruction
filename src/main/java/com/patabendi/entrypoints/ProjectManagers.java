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

import com.patabendi.model.ProjectManager;
import com.patabendi.model.ProjectSalarySum;
import com.patabendi.service.ProjectManagerService;
import com.patabendi.service.SalaryService;

@Path("/manager")
public class ProjectManagers {
	
	@GET
	@Path("/getAllManagers")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ProjectManager> getAllManagers() {
		List<ProjectManager> listOfManagers = ProjectManagerService.getAllManagers();
        return listOfManagers;
	}

	@GET
	@Path("/getManager/{managerId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ProjectManager getManager(@PathParam("managerId") int manager_id) {
		ProjectManager manager = ProjectManagerService.getManager(manager_id);
		return manager;
	}
	
	@POST
	@Path("/addManager")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addManager(ProjectManager manager) {
		ProjectManagerService.addManager(manager);
	}
	
	@PUT
	@Path("/updateManager")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateManager(ProjectManager manager) {
		ProjectManagerService.updateManager(manager);
	}
	
	@DELETE
	@Path("/deleteManager/{managerId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteManager(@PathParam("managerId") int manager_id) {
		ProjectManagerService.deleteManager(manager_id);
	}
	
	@GET
	@Path("/salaries")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ProjectSalarySum> getSalaries() {
		List<ProjectSalarySum> listOfProjects = SalaryService.getSalaries();
		return listOfProjects;
	}

}
