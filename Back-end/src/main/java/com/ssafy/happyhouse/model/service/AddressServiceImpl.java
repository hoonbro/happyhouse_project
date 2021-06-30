package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.mapper.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	SqlSession sqlSession;
	@Override
	public List<String> getCity() {
		return sqlSession.getMapper(AddressDao.class).getCity();
	}

	@Override
	public List<String> getGugun(String city){
		return sqlSession.getMapper(AddressDao.class).getGugun(city);
	}

	@Override
	public List<String> getDong(Address address) {
		return sqlSession.getMapper(AddressDao.class).getDong(address);
	}

	@Override
	public Address centerMark(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getLatLng(String dong) {
		return sqlSession.getMapper(AddressDao.class).getLatLng(dong);
	}

	@Override
	public Address getMaxArea(String searchInput) {
		return sqlSession.getMapper(AddressDao.class).getMaxArea(searchInput);
	}
}
