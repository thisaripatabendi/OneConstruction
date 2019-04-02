package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.patabendi.MyBatisUtil;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Project;

public class ProjectDAO {

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
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		    session.insert("com.patabendi.ProjectMapper.insertProject", project);
		    session.commit();
			System.out.println("---Data saved---");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
		}
	    session.close();	
	}

	public void update(Project project) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		    session.update("com.patabendi.ProjectMapper.updateProject", project);
		    session.commit();
		    System.out.println("updated");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
	    session.close();
	}

	public void deleteProject(int project_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			session.delete("com.patabendi.ProjectMapper.deleteProjectById", project_id);
			session.commit(); 
			System.out.println("deleted");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.CANNOT_DELETE_RECORD.getErrorMessage());
		}  
		session.close();
	}

	public static List<Project> getAllProjectsByManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Project> projectlist = session.selectList("com.patabendi.ProjectMapper.selectAllProjectsByManager", manager_id);
		session.close();
		return projectlist;
	}


}
