package com.ssafy.happyhouse.model;

public class Address {
	
	private int no;
	private String city;
	private String gugun;
	private String dong;
	private String lat;
	private String lng;
	public Address() {}
	
	public Address(int no, String city, String gugun, String dong, String lat, String lng) {
		super();
		this.no = no;
		this.city = city;
		this.gugun = gugun;
		this.dong = dong;
		this.lat = lat;
		this.lng = lng;
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

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	
	
}
