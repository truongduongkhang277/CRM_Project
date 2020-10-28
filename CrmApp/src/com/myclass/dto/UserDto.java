package com.myclass.dto;

import com.myclass.entity.User;

public class UserDto extends User {
	
	private String roleDesc;

	public UserDto() {}
	
	public UserDto(int id, String email, String password, String fullname, String avatar, int roleId, String roleDesc) {
		super(id, email, password, fullname, avatar, roleId);
		this.roleDesc = roleDesc;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
