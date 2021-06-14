package com.ssafy.happyhouse.model;

public class Member {

//	userid varchar(16) PK 
//	username varchar(20) 
//	userpwd varchar(16) 
//	email varchar(50) 
//	address varchar(100) 
//	joindate timestamp
	
	String userid;
	String username;
	String userpwd;
	String email;
	String address;
	String joindate;
	public Member(String userid, String username, String userpwd, String email, String address, String joindate) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.address = address;
		this.joindate = joindate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
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
	@Override
	public String toString() {
		return "Member [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", email=" + email
				+ ", address=" + address + ", joindate=" + joindate + "]";
	}
	
}
