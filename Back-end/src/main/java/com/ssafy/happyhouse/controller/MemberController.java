package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.Book;
import com.ssafy.happyhouse.model.Member;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

//	@GetMapping("/delete")
//	public String delete(Model model, HttpSession session) {
//		Member member = (Member) session.getAttribute("userinfo");
//		try {
//			memberService.deleteMember(member.getUserId());
//			session.invalidate();
//		}catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "회원 삭제 실패.");
//		}
//		
//		return "index";
//	}
	@GetMapping("/deleteBook")
	public String bookdelete(@RequestParam int no, Model model, HttpSession session) {
		System.out.println("관심지역 삭제 확인");
		Member member = (Member) session.getAttribute("userinfo");
		try {
			String userid = member.getUserId();
			System.out.println(userid +" "+ no);
			memberService.deleteBook(new Book(userid, no));
			System.out.println("삭제완료");
			List<Address> list = memberService.bookList(member.getUserId());
			session.setAttribute("booklist", list);

		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "관심지역 삭제 중 문제가 발생했습니다.");
		}
		
		return "index";
	}
	@PostMapping("/booking")
	public String booking(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		System.out.println("관심지역 확인");
		Member member = (Member) session.getAttribute("userinfo");
		try {
			map.put("userid", member.getUserId());
			memberService.newBooking(map);
			List<Address> list = memberService.bookList(member.getUserId());
			session.setAttribute("booklist", list);
			
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "관심지역 등록 중 문제가 발생했습니다.");
		}
		
		return "index";
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		try {
			Member member = memberService.login(map);
			List<Address> list = memberService.bookList(member.getUserId());
			if(member != null) {
				session.setAttribute("userinfo", member);
				session.setAttribute("booklist", list);
			}
			else {
				model.addAttribute("msg", "아이디와 비밀번호를 확인하세요.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@PostMapping("/modify")
	public String modify(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		try {
			memberService.modifyMember(map);
			Member member = memberService.getMember(map.get("info_id"));
			session.setAttribute("userinfo", member);
			model.addAttribute("msg", "회원정보 수정 성공.");
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원정보 수정중 문제가 발생했습니다.");
		}
		return "index";
	}
	
	@GetMapping("/delete")
	public String delete(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("userinfo");
		try {
			memberService.deleteMember(member.getUserId());
			session.invalidate();
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 삭제 실패.");
		}
		
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "signUp";
	}
	
	@PostMapping("/register")
	public String register(Member member, Model model) {
		try {
			memberService.registerMember(member);
			model.addAttribute("msg", "회원가입 성공");
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 실패");
			return "signUp";
		}
		return "index";
	}
	
}
