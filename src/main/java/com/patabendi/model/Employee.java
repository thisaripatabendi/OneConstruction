package com.patabendi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	
	private String emp_id;
	private String emp_name;
	private double emp_salary;
	private String project_id;
	private String emp_email;
	
	public Employee() {

	}

	public Employee(String emp_id, String emp_name, double emp_salary, String project_id, String emp_email) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.project_id = project_id;
		this.emp_email = emp_email;
	}
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

}
