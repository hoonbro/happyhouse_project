package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Commerce;
import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.HouseInfo;

public interface HouseDao {
	public List<House> dongSearch(Address address);
	
	public List<House> aptSearch(String aptName);
	
	public String dongAptTotal(String dong);

	public HouseInfo aptTotal(Map<String, String> map);
	
	public String avgAmount(Map<String, String> map);
	
	public List<Integer> totalType(Map<String, String> map);
	
	public List<Integer> commerceTotal();
	
	public List<Commerce> commerceDong(Map<String, String> map);
	
	public List<Integer> priceTotal();
	
	public List<HouseInfo> priceGugun(Map<String, String> map);
	
	public List<HouseInfo> priceDong(Map<String, String> map);
	
	public List<Integer> monthlyTotal();
	
	public List<HouseInfo> monthly(Map<String, String> map);
	
	public List<House> makeMark(Map<String, String> map);
}
