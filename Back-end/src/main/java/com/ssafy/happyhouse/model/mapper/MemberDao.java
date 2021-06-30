package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Book;
import com.ssafy.happyhouse.model.Member;

public interface MemberDao {
	
//	회원가입
	void registerMember(Member memberDto);
	
//	로그인
	Member login(Member memberDto);
	
//	회원정보 수정
	void modifyMember(Member memberDto);
	
//	회원탈퇴전 관심지역 삭제
	void deleteBookList(String userid);
	
//	회원탈퇴
	void deleteMember(String userId);

//	관심지역 설정
	void newBooking(Book book);
	
//	관심지역 리스트
	List<Address> bookList(String userId);

//	관심지역 삭제
	void deleteBook(Book book);
}
