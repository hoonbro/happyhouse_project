package com.ssafy.happyhouse.model;

public class Member {

	private String userId;
	private String userName;
	private String userPwd;
	private String email;
	private String address;
	private String joindate;

	public Member() {};
	
	public Member(String userId, String userName, String userPwd, String email, String address, String joindate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.email = email;
		this.address = address;
		this.joindate = joindate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}
