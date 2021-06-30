package com.ssafy.happyhouse.model;

public class Board {
//	userId varchar(30) 
//	password varchar(45) 
//	num varchar(45) PK 
//	title varchar(45) 
//	content varchar(45) 
//	date varchar(45)
	
	private int num;
	private String userId;
	private String password;
	private String title;
	private String content;
	private String date;
	
	public Board() {}

	public Board(int num, String userId, String password, String title, String content, String date) {
		this.num = num;
		this.userId = userId;
		this.password = password;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
