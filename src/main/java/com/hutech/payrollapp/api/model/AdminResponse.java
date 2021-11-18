package com.hutech.payrollapp.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AdminResponse {

	private final String token;

	@NotEmpty
	@Email
	private String username;

	private Boolean isAdmin;
	private Boolean isManager;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		this.isManager = true;
	}

	public String getToken() {
		return token;
	}

	public AdminResponse(String token, @NotEmpty @Email String username, Boolean isAdmin, Boolean isManager) {
		super();
		this.token = token;
		this.username = username;
		// this.password = password;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
	}

}
