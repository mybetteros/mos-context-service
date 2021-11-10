package com.mybetteros.moscontextservice.models;

import java.util.List;

public class UserContextModel {
	
	private String email;
	private String role;
	private List<SecurityBitModel> securityBits;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<SecurityBitModel> getSecurityBits() {
		return securityBits;
	}
	public void setSecurityBits(List<SecurityBitModel> securityBits) {
		this.securityBits = securityBits;
	}
	
}
