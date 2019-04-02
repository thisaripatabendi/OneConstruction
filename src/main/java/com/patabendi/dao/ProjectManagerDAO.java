package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.patabendi.MyBatisUtil;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.ProjectManager;

public class ProjectManagerDAO {
	
	final static Logger logger = Logger.getLogger(ProjectManagerDAO.class);

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
		return manager;
	}
	
	public void save(ProjectManager manager) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		    session.insert("com.patabendi.ProjectManagerMapper.insertManager", manager);
		    session.commit();
		    logger.info("manager added");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
		}
	    session.close();		
	}

	public int update(ProjectManager manager) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
	    int records_affected = session.update("com.patabendi.ProjectManagerMapper.updateManager", manager);
	    session.commit();
	    session.close();	
	    return records_affected;
	}

	public int deleteManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			int records_Affected = session.delete("com.patabendi.ProjectManagerMapper.deleteManagerById", manager_id);
			session.commit();   
			session.close();
			return records_Affected;
		} catch (Exception e) {
			return 0;
		}
	}

}
