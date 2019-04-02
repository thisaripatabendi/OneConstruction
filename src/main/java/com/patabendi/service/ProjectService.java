package com.patabendi.service;

import java.util.List;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.patabendi.dao.ProjectDAO;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Project;

public class ProjectService {
	
	final static Logger logger = Logger.getLogger(ProjectService.class);

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
		
		if(projectDAO.update(project)==0) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		logger.info("Project updated");
		
	}

	public static void deleteProject(@PathParam("projectId") int project_id) {
		ProjectDAO projectDAO = new ProjectDAO();
		
		if(projectDAO.deleteProject(project_id)==0) {
			throw new DataNotFoundException(ErrorMessages.CANNOT_DELETE_RECORD.getErrorMessage());
		}
		
		logger.info("Project Deleted");
		
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
