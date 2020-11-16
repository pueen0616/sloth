package com.sloth.board.vo;

import java.sql.Date;

public class AccountVO {
	private String id;
	private String name;
	private String password;
	private Date birth;
	private String email;
	private String tel;
	private String userType;
	
	
	
	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", name=" + name + ", password=" + password + ", birth=" + birth + ", email="
				+ email + ", tel=" + tel + ", userType=" + userType + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}