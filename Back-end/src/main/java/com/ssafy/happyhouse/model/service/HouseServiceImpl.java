package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.mapper.HouseDao;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<House> findDong(String dong) throws SQLException{
		return sqlSession.getMapper(HouseDao.class).findDong(dong);
	}

	@Override
	public List<House> findApt(String aptinput) throws SQLException {
		return sqlSession.getMapper(HouseDao.class).findApt(aptinput);
	}

	@Override
	public List<House> houseList(){
		return sqlSession.getMapper(HouseDao.class).houseList();
	}

}
