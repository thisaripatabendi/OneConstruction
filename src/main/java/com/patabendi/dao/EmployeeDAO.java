package com.patabendi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.patabendi.MyBatisUtil;
import com.patabendi.exceptions.DataNotFoundException;
import com.patabendi.exceptions.ErrorMessages;
import com.patabendi.model.Employee;
import com.patabendi.model.ProjectSalarySum;

public class EmployeeDAO {

	public static List<Employee> getAllEmployees() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employee> emplist = session.selectList("com.patabendi.EmployeeMapper.selectAllEmployees"); 
		session.close();
		return emplist;
	}

	public static Employee getEmployee(int emp_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Employee emp = (Employee) session.selectOne("com.patabendi.EmployeeMapper.selectEmployeeById", emp_id);
		session.close();
		return emp;		
	}
	 
	public void save(Employee emp) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
		try {
			session.insert("com.patabendi.EmployeeMapper.insertEmployee", emp);
		    session.commit();
		    System.out.println("---Data saved---");
		} catch (Exception e) {
			throw new DataNotFoundException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
		}
	    
	    session.close();		
	}
	
	public void update(Employee emp){
	    SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();	
	    session.update("com.patabendi.EmployeeMapper.updateEmployee", emp);
	    session.commit();
	    session.close();
	}

	public void deleteEmployee(int emp_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("com.patabendi.EmployeeMapper.deleteEmployeeById", emp_id);
		session.commit();
		session.close();		
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
	
	

}
