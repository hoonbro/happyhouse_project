package com.ssafy.happyhouse.model;

public class Book {
	private String userid;
	private int no;
	private String city;
	private String gugun;
	private String dong;
	
	
	
	public Book(String userid, int no, String city, String gugun, String dong) {
		super();
		this.userid = userid;
		this.no = no;
		this.city = city;
		this.gugun = gugun;
		this.dong = dong;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	@Override
	public String toString() {
		return "Book [userid=" + userid + ", no=" + no + ", city=" + city + ", gugun=" + gugun + ", dong=" + dong + "]";
	}
}
