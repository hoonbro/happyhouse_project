package com.ssafy.happyhouse.model;

public class HouseInfo {
	private int total;
	private int maxAmount;
	private int minAmount;
	private int typeCnt;
	private int cnt;
	private String name;
	private String month;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeCnt() {
		return typeCnt;
	}

	public void setTypeCnt(int typeCnt) {
		this.typeCnt = typeCnt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

}
