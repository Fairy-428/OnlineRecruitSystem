package com.jk.recruit.po;

import java.util.Date;

public class Recruitment {
	private int id; 
	private String postTitle;
	private String description;
	private String postPlace;
	private String salary;
	private String postType;
	private String eduBg;
	private String city;
	private String employeeType;
	private int corporationId;
	private Date releaseTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPostPlace() {
		return postPlace;
	}
	public void setPostPlace(String postPlace) {
		this.postPlace = postPlace;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getEduBg() {
		return eduBg;
	}
	public void setEduBg(String eduBg) {
		this.eduBg = eduBg;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public int getCorporationId() {
		return corporationId;
	}
	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	
}
