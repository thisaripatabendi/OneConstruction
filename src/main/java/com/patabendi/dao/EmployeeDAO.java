package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.patabendi.MyBatisUtil;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Employee;
import com.patabendi.model.ProjectSalarySum;

public class EmployeeDAO {
	
	final static Logger logger = Logger.getLogger(EmployeeDAO.class);

	public static List<Employee> getAllEmployees() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employee> emplist = session.selectList("com.patabendi.EmployeeMapper.selectAllEmployees"); 
		session.close();
		logger.info("Get all employees executed");
		return emplist;
	}

	public static Employee getEmployee(int emp_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Employee emp = (Employee) session.selectOne("com.patabendi.EmployeeMapper.selectEmployeeById", emp_id);
		session.close();
		return emp;		
	}
	 
	public void save(Employee emp) {
		if(emp.getEmp_name().equals("")) {
			logger.info("Employee is empty");
			throw new DataNotFoundException(ErrorMessages.EMPTY_FIELDS.getErrorMessage());
		}else {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
			try {
				session.insert("com.patabendi.EmployeeMapper.insertEmployee", emp);
			    session.commit();
			    logger.info("Employee Added.");
			} catch (Exception e) {
				logger.info(e.getCause().getMessage());
				throw new DataNotFoundException(ErrorMessages.DUPLICAKE_KEY.getErrorMessage());
			}		    
		    session.close();	
		}			
	}
	
	public int update(Employee emp){
	    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
	    int records_addected = session.update("com.patabendi.EmployeeMapper.updateEmployee", emp);
	    session.commit();
	    session.close();
	    return records_addected;
	}

	public int deleteEmployee(int emp_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		int records_affected = session.delete("com.patabendi.EmployeeMapper.deleteEmployeeById", emp_id);
		session.commit();
		session.close();
		return records_affected;
	}

	public static List<Employee> getAllEmployeesByProject(int project_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employee> emplist = session.selectList("com.patabendi.EmployeeMapper.selectAllEmployeesByProject", project_id);
		session.close();
		return emplist;
	}
	
	public static List<ProjectSalarySum> getSalaries() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<ProjectSalarySum> projectlist = session.selectList("com.patabendi.ProjectSalaryMapper.getSalary");
		session.close();
		return projectlist;
	}

	public static List<Employee> getAllEmployeesByManager(int manager_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employee> emplist = session.selectList("com.patabendi.EmployeeMapper.selectAllEmployeesByManager", manager_id);
		session.close();
		return emplist;
	}
	
	

}
