package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Book;
import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.model.service.MemberService;


@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	@PostMapping(value = "/login")
	public ResponseEntity<Member> login(@RequestBody Member member, Model model, HttpSession session) {
		System.out.println(member.getUserid());
		System.out.println(member.getUserpwd());
		
		
		Member m = memberService.login(member);
		System.out.println(m.getUserid());
		
		if(m != null) {
			System.out.println("로그인!!!!!");
			return new ResponseEntity<Member>(m, HttpStatus.OK);
		}else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@PostMapping(value = "/register")
	public void registerMember(@RequestBody Member member, Model model, HttpSession session) {
		System.out.println(member.getUserid());
		System.out.println(member.getUserpwd());
		System.out.println(member.getUsername());
		System.out.println(member.getEmail());
		System.out.println(member.getAddress());
		
		
		memberService.registerMember(member);
		System.out.println("등록?");
		
	}
	@PutMapping(value = "/modify")
	public void modifyMember(@RequestBody Member member, Model model, HttpSession session) {
		System.out.println("회원정보수정");
		memberService.modifyMember(member);
		System.out.println(member.toString());
//		return new ResponseEntity<Member>(member, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/delete")
	public void deleteMember(@RequestBody Member member) {
		System.out.println("회원탈퇴 전 관심목록 삭제");
		memberService.deleteBookList(member.getUserid());
		System.out.println("관심목록 삭제 후 탈퇴 시작!!");
		memberService.deleteMember(member.getUserid());
	}
	
//	관심목록 축가하기
	@PostMapping("/newBooking")
	public void booking(@RequestBody Book book) {
		System.out.println("관심지역등록 하자~~");
		System.out.println(book.toString());
		memberService.newBooking(book);
	}
	
	
//	관심지역 목록 받아오기
	@GetMapping(value = "/booklist/{userid}")
	public ResponseEntity<List<Address>> bookList(@PathVariable String userid) {
		System.out.println(userid);
		
		List<Address> bookList = memberService.bookList(userid);
		System.out.println(bookList.size());
		
		if(bookList != null) {
			System.out.println("관심목록불러오기");
			return new ResponseEntity<List<Address>>(bookList, HttpStatus.OK);
		}else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	

//	관심지역 삭제
	@PostMapping("/deleteBook")
	public void bookdelete(@RequestBody Book book) {
			memberService.deleteBook(book);
			System.out.println("삭제완료");
	}
}
