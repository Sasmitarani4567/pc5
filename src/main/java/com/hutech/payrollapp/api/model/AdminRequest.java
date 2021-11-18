package com.hutech.payrollapp.api.model;

public class AdminRequest {

	private String userName;
	private String password;
	private Boolean isAdmin;
	private Boolean isManager;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return false;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = false;
	}

	public Boolean getIsManager() {
		return false;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = false;
	}

	public AdminRequest(String userName, String password, Boolean isAdmin, Boolean isManager) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
	}

	public AdminRequest() {

	}

}
