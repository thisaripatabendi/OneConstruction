package com.patabendi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectSalarySum {
	
	private String project_name;
	private double salary_sum;
	
	
	public ProjectSalarySum() {

	}

	public ProjectSalarySum(String project_name, double salary_sum) {
		this.project_name = project_name;
		this.salary_sum = salary_sum;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public double getSalary_sum() {
		return salary_sum;
	}

	public void setSalary_sum(double salary_sum) {
		this.salary_sum = salary_sum;
	}
	
	

}
