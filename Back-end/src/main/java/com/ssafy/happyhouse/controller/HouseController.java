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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.service.AddressService;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {
	
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	
	@Autowired
	private HouseService houseservice;
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/dongSearch")
	public String bookdongSearch(@RequestParam Map<String, String> map, Model model) {
		try {
			List<House> list = houseservice.findDong(map.get("dong"));
			Address addr = addressService.centerMark(map);
			addr.setCity(map.get("sido"));
			addr.setGugun(map.get("gugun"));
			addr.setDong(map.get("dong"));
			model.addAttribute("list", list);
			model.addAttribute("addr", addr);
//			model.addAttribute("sido", map.get("sido"));
//			model.addAttribute("gugun", map.get("gugun"));
//			model.addAttribute("dong", map.get("dong"));
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "동별 아파트 리스트를 가져오지 못했습니다.");
			return "index";
			
		}
		return "searchDong";
	}
	
	@PostMapping("/dongSearch")
	public String dongSearch(@RequestParam Map<String, String> map, Model model) {
		try {
			List<House> list = houseservice.findDong(map.get("dong"));
			Address addr = addressService.centerMark(map);
			addr.setCity(map.get("sido"));
			addr.setGugun(map.get("gugun"));
			addr.setDong(map.get("dong"));
			model.addAttribute("list", list);
			model.addAttribute("addr", addr);
//			model.addAttribute("sido", map.get("sido"));
//			model.addAttribute("gugun", map.get("gugun"));
//			model.addAttribute("dong", map.get("dong"));
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "동별 아파트 리스트를 가져오지 못했습니다.");
			return "index";
			
		}
		return "searchDong";
	}
	
	@PostMapping("/aptSearch")
	public String dongSearch(@RequestParam String aptinput, Model model) {
		try {
			List<House> list = houseservice.findApt(aptinput);
			System.out.println(list.size());
			model.addAttribute("list", list);
			model.addAttribute("aptinput", aptinput);
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "아파트 리스트를 가져오지 못했습니다.");
			return "index";
			
		}
		return "searchApt";
	}
	
}
