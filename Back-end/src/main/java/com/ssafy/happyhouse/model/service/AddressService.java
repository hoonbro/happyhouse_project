package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Address;

public interface AddressService {
	public List<String> getSido();
	public List<Address> searchGugun(String sido);
	public List<Address> searchDong(String gugun);
	public Address centerMark(Map<String, String> map);
//	public List<Address> getbooklist(String userId)throws SQLException;
}
