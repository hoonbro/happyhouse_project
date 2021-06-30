package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.mapper.AddressDao;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<String> getSido() {
		return sqlSession.getMapper(AddressDao.class).getSido();
	}
	
	@Override
	public List<Address> searchGugun(String sido) {
		return sqlSession.getMapper(AddressDao.class).searchGugun(sido);
	}

	@Override
	public List<Address> searchDong(String gugun){
		return sqlSession.getMapper(AddressDao.class).searchDong(gugun);
	}

	@Override
	public Address centerMark(Map<String, String> map) {
		return sqlSession.getMapper(AddressDao.class).centerMark(map);
	}

//	@Override
//	public List<Address> getbooklist(String userId) throws SQLException {
//		List<Address> list = null;
//		AddressDao dao = AddressDaoImpl.getAddressService();
//		list = dao.getBooklist(userId);
//		return list;
//	}

}
