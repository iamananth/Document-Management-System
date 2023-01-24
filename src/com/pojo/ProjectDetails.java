package com.pojo;

import javax.persistence.ManyToOne;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class ProjectDetails {
	private String pcode;
	private String startDate;
	private String endDate;
	private String ptype;
	private String fileName;
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	private User user;
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
