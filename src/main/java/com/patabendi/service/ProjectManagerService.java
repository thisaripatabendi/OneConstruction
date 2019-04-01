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

import com.patabendi.dao.ProjectManagerDAO;
import com.patabendi.model.ProjectManager;

@Path("/manager")
public class ProjectManagerService {
	
	@GET
	@Path("/getAllManagers")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ProjectManager> getAllManagers() {
		List<ProjectManager> listOfManagers = ProjectManagerDAO.getAllManagers();
        return listOfManagers;
	}

	@GET
	@Path("/getManager/{managerId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ProjectManager getManager(@PathParam("managerId") String manager_id) {
		ProjectManager manager = ProjectManagerDAO.getManager(manager_id);
		return manager;
	}
	
	@POST
	@Path("/addManager")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void addManager(ProjectManager manager) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		managerDAO.save(manager);
	}
	
	@PUT
	@Path("/updateManager")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateManager(ProjectManager manager) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		managerDAO.update(manager);
		System.out.println("---Data updated---");
	}
	
	@DELETE
	@Path("/deleteManager/{managerId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteManager(@PathParam("managerId") String manager_id) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		managerDAO.deleteManager(manager_id);
		System.out.println("---Data deleted---");
	}
	
}
