package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.Book;
import com.ssafy.happyhouse.model.Member;

public interface MemberService {

//	회원가입
	void registerMember(Member memberDto);
	
//	로그인
	Member login(Map<String, String> map);
	
//	회원정보 수정을 위한 회원의 모든 정보 얻기
	Member getMember(String userId);
	
//	회원정보 수정
	void modifyMember(Map<String, String> map);
	
//	회원탈퇴
	void deleteMember(String userId);
	
//  관심지역 등록
	void newBooking(Map<String, String> map);
	
	List<Address> bookList(String userId);
//
//	void deleteBook(Map<String, String> map);

//	void deleteBook(String userid, int no);

	void deleteBook(Book book);
}
