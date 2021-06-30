package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Address;

public interface AddressDao {
	public List<String> getSido();
	public List<Address> searchGugun(String sido);
	public List<Address> searchDong(String gugun);
	public Address centerMark(Map<String, String> map);
	public List<Address> getBooklist(String userId) throws SQLException;
}
