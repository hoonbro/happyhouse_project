package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Commerce;
import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.HouseInfo;
import com.ssafy.happyhouse.model.service.HouseService;

@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class HouseController {

	@Autowired
	HouseService houseService;
	
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	
	
	@PostMapping(value = "/dongSearch")
	public ResponseEntity<List<House>> dongSearch(@RequestBody Address address) {
		List<House> list = houseService.dongSearch(address);
		if(list != null)
			return new ResponseEntity<List<House>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/aptSearch/{aptName}")
	public ResponseEntity<List<House>> aptSearch(@PathVariable String aptName) {
		List<House> list = houseService.aptSearch(aptName);
		if(list != null)
			return new ResponseEntity<List<House>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/dongAptTotal/{dong}")
	public ResponseEntity<String> dongAptTotal(@PathVariable String dong) {
		String total = houseService.dongAptTotal(dong);
		if(total != null)
			return new ResponseEntity<String>(total, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/aptTotal/{type}/{data}")
	public ResponseEntity<HouseInfo> AptTotal(@PathVariable String type, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("data", data);
		HouseInfo info = houseService.aptTotal(map);
//		String total = houseService.aptTotal(map);
		if(info != null)
			return new ResponseEntity<HouseInfo>(info, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/avgAmount/{type}/{data}")
	public ResponseEntity<String> avgAmount(@PathVariable String type, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("data", data);
		String total = houseService.avgAmount(map);
		if(total != null)
			return new ResponseEntity<String>(total, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/typeTotal/{type}/{data}")
	public ResponseEntity<List<Integer>> totalType(@PathVariable String type, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("data", data);
		List<Integer> list = houseService.totalType(map);
		if(list != null)
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/commerceTotal")
	public ResponseEntity<List<Integer>> commerceTotal() {
		List<Integer> list = houseService.commerceTotal();
		if(list != null)
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/commerceDong/{type}/{data}")
	public ResponseEntity<List<Commerce>> commerceDong(@PathVariable String type, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type); 
		map.put("data", data);
		List<Commerce> list = houseService.commerceDong(map);
		if(list != null)
			return new ResponseEntity<List<Commerce>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/priceTotal")
	public ResponseEntity<List<Integer>> priceTotal() {
		List<Integer> list = houseService.priceTotal();
		if(list != null)
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/priceGugun/{type}/{area}/{data}")
	public ResponseEntity<List<HouseInfo>> priceGugun(@PathVariable String type, @PathVariable String area, @PathVariable String data) {
		System.out.println(type + " " + data);
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("area", area);
		map.put("data", data);
		List<HouseInfo> list = houseService.priceGugun(map);
		if(list != null)
			return new ResponseEntity<List<HouseInfo>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/priceDong/{type}/{area}/{data}")
	public ResponseEntity<List<HouseInfo>> priceDong(@PathVariable String type, @PathVariable String area, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("area", area);
		map.put("data", data);
		List<HouseInfo> list = houseService.priceDong(map);
		if(list != null)
			return new ResponseEntity<List<HouseInfo>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/monthlyTotal")
	public ResponseEntity<List<Integer>> monthlyTotal() {
		List<Integer> list = houseService.monthlyTotal();
		if(list != null)
			return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/monthly/{type}/{data}")
	public ResponseEntity<List<HouseInfo>> monthly(@PathVariable String type, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("data", data);
		List<HouseInfo> list = houseService.monthly(map);
		if(list != null)
			return new ResponseEntity<List<HouseInfo>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/makeMark/{type}/{data}")
	public ResponseEntity<List<House>> makeMark(@PathVariable String type, @PathVariable String data) {
		Map<String, String> map = new HashMap<>();
		map.put("type", type);
		map.put("data", data);
		List<House> list = houseService.makeMark(map);
		if(list != null)
			return new ResponseEntity<List<House>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
//	@GetMapping(value = "/getChicken/{dong}")
//	public ResponseEntity<List<String>> getChicken(@PathVariable String dong) {
//		List<String> list = addressService.getChicken(dong);
//		if(list != null)
//			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
//		else
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//	}
}
