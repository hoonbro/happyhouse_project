package com.ssafy.happyhouse.model;

public class Book {
	private String userid;
	private int no;
	
	
	public Book(String userid, int no) {
		super();
		this.userid = userid;
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	
}
