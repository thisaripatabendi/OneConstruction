package com.patabendi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projectManager")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectManager {
	
	private int manager_id;
	private String name;
	private String email;
	private String contact_number;	
	
	public ProjectManager() {

	}
	
	public ProjectManager(int manager_id, String name, String email, String contact_number) {
		this.manager_id = manager_id;
		this.name = name;
		this.email = email;
		this.contact_number = contact_number;
	}
	
	public int getManager_id() {
		return manager_id;
	}
	
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	
	

}
