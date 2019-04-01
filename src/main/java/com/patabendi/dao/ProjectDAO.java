package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.patabendi.MyBatisUtil;
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
		if(project==null) {
			return null;
		}else {
			return project;
		}
	}

	public void save(Project project) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		    session.insert("com.patabendi.ProjectMapper.insertProject", project);
		    session.commit();
			System.out.println("---Data saved---");
		} catch (Exception e) {
			System.out.println(e.getCause().getMessage());
		}
	    session.close();	
	}

	public void update(Project project) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
	    session.update("com.patabendi.ProjectMapper.updateProject", project);
	    session.commit();
	    session.close();
	}

	public void deleteProject(int project_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("com.patabendi.ProjectMapper.deleteProjectById", project_id);
		session.commit();   
		session.close();
	}

	public static List<Project> getAllProjectsByManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Project> projectlist = session.selectList("com.patabendi.ProjectMapper.selectAllProjectsByManager", manager_id);
		session.close();
		if(projectlist.isEmpty()) {
			System.out.println("No Projects under manager id : " + manager_id);
			return null;
		}else {
			return projectlist;
		}
	}


}
