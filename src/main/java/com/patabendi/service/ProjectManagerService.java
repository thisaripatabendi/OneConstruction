package com.patabendi.service;

import java.util.List;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.patabendi.dao.ProjectManagerDAO;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.ProjectManager;

public class ProjectManagerService {
	
	final static Logger logger = Logger.getLogger(ProjectManagerService.class);
	
	public static List<ProjectManager> getAllManagers() {
		List<ProjectManager> listOfManagers = ProjectManagerDAO.getAllManagers();
		
		if (listOfManagers.isEmpty()) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORDS_FOUND.getErrorMessage());
		}
		
        return listOfManagers;
	}

	public static ProjectManager getManager(@PathParam("managerId") int manager_id) {
		ProjectManager manager = ProjectManagerDAO.getManager(manager_id);
		
		if(manager==null) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}else {
			return manager;
		}
		
	}
	
    public static void addManager(ProjectManager manager) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		managerDAO.save(manager);
	}
	
	public static void updateManager(ProjectManager manager) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		
		if(managerDAO.update(manager)==0) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		logger.info("Manager updated");

	}

	public static void deleteManager(@PathParam("managerId") int manager_id) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		if(managerDAO.deleteManager(manager_id)==0) {
			throw new DataNotFoundException(ErrorMessages.CANNOT_DELETE_RECORD.getErrorMessage());
		}
		
		logger.info("Manager deleted");
		
	}
	
}
