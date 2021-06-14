package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Commerce;
import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.HouseInfo;
import com.ssafy.happyhouse.model.mapper.HouseDao;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<House> dongSearch(Address address) {
		return sqlSession.getMapper(HouseDao.class).dongSearch(address);
	}

	@Override
	public List<House> aptSearch(String aptName) {
		return sqlSession.getMapper(HouseDao.class).aptSearch(aptName);
	}

	@Override
	public String dongAptTotal(String dong) {
		return sqlSession.getMapper(HouseDao.class).dongAptTotal(dong);
	}

	@Override
	public HouseInfo aptTotal(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).aptTotal(map);
	}

	@Override
	public String avgAmount(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).avgAmount(map);
	}

	@Override
	public List<Integer> totalType(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).totalType(map);
	}

	@Override
	public List<Integer> commerceTotal() {
		return sqlSession.getMapper(HouseDao.class).commerceTotal();
	}

	@Override
	public List<Commerce> commerceDong(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).commerceDong(map);
	}

	@Override
	public List<Integer> priceTotal() {
		return sqlSession.getMapper(HouseDao.class).priceTotal();
	}
	
	@Override
	public List<HouseInfo> priceGugun(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).priceGugun(map);
	}

	@Override
	public List<HouseInfo> priceDong(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).priceDong(map);
	}

	public List<Integer> monthlyTotal() {
		return sqlSession.getMapper(HouseDao.class).monthlyTotal();
	}

	@Override
	public List<HouseInfo> monthly(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).monthly(map);
	}

	@Override
	public List<House> makeMark(Map<String, String> map) {
		return sqlSession.getMapper(HouseDao.class).makeMark(map);
	}

	
}
