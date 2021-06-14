package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Address;

public interface AddressDao {
	public List<String> getCity();
	public List<String> getGugun(String city);
	public List<String> getDong(Address address);
	public Address centerMark(Map<String, String> map);
	public Address getLatLng(String dong);
	public Address getMaxArea(String searchInput);
	public List<Address> getBooklist(String userId) throws SQLException;
}
