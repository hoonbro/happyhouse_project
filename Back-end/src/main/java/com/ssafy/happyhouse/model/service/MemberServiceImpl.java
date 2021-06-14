package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Book;
import com.ssafy.happyhouse.model.Member;
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
	public Member login(Member member) {
		if(member.getUserid()== null || member.getUserpwd() == null)
			return null;
		return sqlSession.getMapper(MemberDao.class).login(member);

	}

	@Override
	public void modifyMember(Member member) {
		sqlSession.getMapper(MemberDao.class).modifyMember(member);
	}
	
	@Override
	public void deleteBookList(String userid) {
		// TODO Auto-generated method stub
		sqlSession.getMapper(MemberDao.class).deleteBookList(userid);
	}

	@Override
	public void deleteMember(String userId) {
		sqlSession.getMapper(MemberDao.class).deleteMember(userId);

	}

	@Override
	public void newBooking(Book book) {
		// TODO Auto-generated method stub
		sqlSession.getMapper(MemberDao.class).newBooking(book);
	}

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

}
