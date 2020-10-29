package com.yirbnb.vo;

public class account {

	private String id;
	private String password;
	private String birth;
	private String email;
	private String tel;
	private String userType;
	
	public account() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
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

	@Override
	public String toString() {
		return "account [id=" + id + ", password=" + password + ", birth=" + birth + ", email=" + email + ", tel=" + tel
				+ ", userType=" + userType + "]";
	}
	
	
}
