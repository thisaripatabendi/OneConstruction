package com.patabendi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
	
	private int project_id;
	private String project_name;
	private String project_location;
	private int manager_id;
		
	public Project() {

	}
	public Project(int project_id, String project_name, String project_location, int manager_id) {
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_location = project_location;
		this.manager_id = manager_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_location() {
		return project_location;
	}
	public void setProject_location(String project_location) {
		this.project_location = project_location;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	
	
}
