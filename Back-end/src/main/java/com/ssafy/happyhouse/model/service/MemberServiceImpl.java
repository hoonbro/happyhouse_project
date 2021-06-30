package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.Book;
import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.model.mapper.HouseDao;
import com.ssafy.happyhouse.model.mapper.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerMember(Member member) {
		sqlSession.getMapper(MemberDao.class).registerMember(member);
	}

	@Override
	public Member login(Map<String, String> map) {
		if(map.get("userid") == null || map.get("userpwd") == null)
			return null;
		return sqlSession.getMapper(MemberDao.class).login(map);
	}

	@Override
	public Member getMember(String userId) {
		return sqlSession.getMapper(MemberDao.class).getMember(userId);
	}

	@Override
	public void modifyMember(Map<String, String> map) {
		sqlSession.getMapper(MemberDao.class).modifyMember(map);
	}

	@Override
	public void deleteMember(String userId) {
		sqlSession.getMapper(MemberDao.class).deleteMember(userId);
	}

	@Override
	public void newBooking(Map<String, String> map) {
//		MemberDaoImpl.getMemberDao().newBooking(userid, sido, gugun, dong);
		sqlSession.getMapper(MemberDao.class).newBooking(map);
//		return;
	}
//
	@Override
	public List<Address> bookList(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberDao.class).bookList(userId);
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		sqlSession.getMapper(MemberDao.class).deleteBook(book);
	}

	//	@Override
//	public void deletebook(String userId, String no) {
//		MemberDaoImpl.getMemberDao().deletebook(userId, no);
//		
//	}


}
