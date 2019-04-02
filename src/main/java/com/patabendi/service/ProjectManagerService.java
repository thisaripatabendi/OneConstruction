package com.patabendi.service;

import java.util.List;
import javax.ws.rs.PathParam;
import com.patabendi.dao.ProjectManagerDAO;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.ProjectManager;

public class ProjectManagerService {
	
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
		managerDAO.update(manager);
	}

	public static void deleteManager(@PathParam("managerId") int manager_id) {
		ProjectManagerDAO managerDAO = new ProjectManagerDAO();
		managerDAO.deleteManager(manager_id);
	}
	
}
