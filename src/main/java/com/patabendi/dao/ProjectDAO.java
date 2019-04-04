package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.patabendi.MyBatisUtil;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Project;

public class ProjectDAO {
	
	final static Logger logger = Logger.getLogger(ProjectDAO.class);

	public static List<Project> getAllProjects() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Project> projectlist = session.selectList("com.patabendi.ProjectMapper.selectAllProjects"); 
		session.close();
		return projectlist;
	}

	public static Project getProject(int project_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Project project = (Project) session.selectOne("com.patabendi.ProjectMapper.selectProjectById", project_id); 
		session.close();
		return project;
	}

	public void save(Project project) {
		if(project.getProject_name().equals("")) {
			logger.info("Project is empty");
			throw new DataNotFoundException(ErrorMessages.EMPTY_FIELDS.getErrorMessage());
		}else {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			try {
			    session.insert("com.patabendi.ProjectMapper.insertProject", project);
			    session.commit();
			    logger.info("Project added");
			} catch (Exception e) {
				throw new DataNotFoundException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
			}
		    session.close();
		}			
	}

	public int update(Project project) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		int records_affected = session.update("com.patabendi.ProjectMapper.updateProject", project);
		session.commit();
		session.close();
	    return records_affected;
	}

	public int deleteProject(int project_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		try {
			int number = session.delete("com.patabendi.ProjectMapper.deleteProjectById", project_id);
			session.commit(); 
			session.close();
			return number;
		} catch (Exception e) {
			return 0;
		}	
		
	}

	public static List<Project> getAllProjectsByManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Project> projectlist = session.selectList("com.patabendi.ProjectMapper.selectAllProjectsByManager", manager_id);
		session.close();
		return projectlist;
	}


}
