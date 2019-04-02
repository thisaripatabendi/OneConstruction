package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.patabendi.MyBatisUtil;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.ProjectManager;

public class ProjectManagerDAO {

	public static List<ProjectManager> getAllManagers() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<ProjectManager> managerlist = session.selectList("com.patabendi.ProjectManagerMapper.selectAllManagers"); 
		session.close();
		return managerlist;
	}

	public static ProjectManager getManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		ProjectManager manager = session.selectOne("com.patabendi.ProjectManagerMapper.selectManager", manager_id);
		session.close();
		if(manager==null) {
			System.out.println("No manager found on id : " + manager_id);
			return null;
		}else {
			return manager;
		}
	}
	
	public void save(ProjectManager manager) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		    session.insert("com.patabendi.ProjectManagerMapper.insertManager", manager);
		    session.commit();
			System.out.println("---Data saved---");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
		}
	    session.close();		
	}

	public void update(ProjectManager manager) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		try {
		    session.update("com.patabendi.ProjectManagerMapper.updateManager", manager);
		    session.commit();
		    System.out.println("data updated successfully");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}

	    session.close();	
	}

	public void deleteManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			session.delete("com.patabendi.ProjectManagerMapper.deleteManagerById", manager_id);
			session.commit();
			System.out.println("data deleted");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.CANNOT_DELETE_RECORD.getErrorMessage());
		}		   
		session.close();		
	}

}
