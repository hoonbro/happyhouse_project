package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.House;

public interface HouseService {
	public List<House> findDong(String dong)  throws SQLException;

	public List<House> findApt(String aptinput) throws SQLException;
	
	//restful
	public List<House> houseList();
}
