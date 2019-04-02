package com.patabendi.service;

import java.util.List;
import javax.ws.rs.PathParam;
import com.patabendi.dao.ProjectDAO;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Project;

public class ProjectService {

	public static List<Project> getAllProjects() {
		List<Project> listOfProjects = ProjectDAO.getAllProjects();
		
		if (listOfProjects.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
        return listOfProjects;
	}
	
	public static Project getProject(@PathParam("projectId") int project_id) {
		Project project = ProjectDAO.getProject(project_id);
		
		if(project==null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}else {
			return project;
		} 
	}

    public static void addProject(Project project) {
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.save(project);
	}	

	public static void updateProject (Project project) {
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.update(project);
	}

	public static void deleteProject(@PathParam("projectId") int project_id) {
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.deleteProject(project_id);
	}

	public static List<Project> getAllEmployeesByProjectId(@PathParam("managerId") int manager_id){
		List<Project> listOfProjects = ProjectDAO.getAllProjectsByManager(manager_id);
		if(listOfProjects.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());
		}else {
			return listOfProjects;
		}
	}

}
