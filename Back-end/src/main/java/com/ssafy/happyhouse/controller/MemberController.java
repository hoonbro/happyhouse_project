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
import org.springframework.web.bind.annotation.DeleteMapping;
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

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/member")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@ApiOperation(value = "로그인의 성공 여부에 따라 사용자 데이터를 반환한다.", response = Member.class)
	@PostMapping(value = "/login")
	public ResponseEntity<Member> login(@RequestBody Member member, Model model, HttpSession session) {
		Member m = memberService.login(member);
		
		if(m != null) {
			return new ResponseEntity<Member>(m, HttpStatus.OK);
		}else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원가입 가능 여부에 따라 DB에 사용자 데이터를 추가한다.")
	@PostMapping(value = "/register")
	public void registerMember(@RequestBody Member member, Model model, HttpSession session) {
		memberService.registerMember(member);
	}
	
	@ApiOperation(value = "사용자의 회원정보를 수정한다.")
	@PutMapping(value = "/modify")
	public void modifyMember(@RequestBody Member member, Model model, HttpSession session) {
		memberService.modifyMember(member);
//		return new ResponseEntity<Member>(member, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "사용자의 회원정보를 삭제한다.")
	@DeleteMapping(value = "/delete")
	public void deleteMember(@RequestBody Member member) {
		memberService.deleteBookList(member.getUserid());
		memberService.deleteMember(member.getUserid());
	}
	
//	관심목록 축가하기
	@ApiOperation(value = "사용자가 선택한 지역을 관심지역으로 등록한다.")
	@PostMapping("/newBooking")
	public void booking(@RequestBody Book book) {
		memberService.newBooking(book);
	}
	
	
//	관심지역 목록 받아오기
	@ApiOperation(value = "사용자의 아이디에 맞는 관심지역 리스트를 반환한다.", response = List.class)
	@GetMapping(value = "/booklist/{userid}")
	public ResponseEntity<List<Address>> bookList(@PathVariable String userid) {
		List<Address> bookList = memberService.bookList(userid);
		
		if(bookList != null) {
			System.out.println("관심목록불러오기");
			return new ResponseEntity<List<Address>>(bookList, HttpStatus.OK);
		}else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	

//	관심지역 삭제
	@ApiOperation(value = "사용자가 선택한 지역을 관심지역 리스트에서 삭제한다.")
	@DeleteMapping("/deleteBook")
	public void bookdelete(@RequestBody Book book) {
			memberService.deleteBook(book);
	}
}
