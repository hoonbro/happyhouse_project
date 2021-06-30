package com.ssafy.happyhouse.controller;

import java.util.List;

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
import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.service.AddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/addr")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class AddressController {

	@Autowired
	AddressService addressService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@ApiOperation(value = "도/광역시 데이터를 반환한다.", response = List.class)
	@GetMapping(value = "/getCity")
	public ResponseEntity<List<String>> getCity() {
		List<String> list = addressService.getCity();
		if(list != null)
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "시/구/군 데이터를 반환한다.", response = List.class)
	@GetMapping(value = "/getGugun/{city}")
	public ResponseEntity<List<String>> getGugun(@PathVariable String city) {
		List<String> list = addressService.getGugun(city);
		if(list != null)
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "동 데이터를 반환한다.", response = List.class)
	@PostMapping(value = "/getDong")
	public ResponseEntity<List<String>> getDong(@RequestBody Address address) {
		List<String> list = addressService.getDong(address);
		if(list != null)
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	} 
	
	@ApiOperation(value = "검색 지역의 좌표를 반환한다.", response = Address.class)
	@GetMapping(value = "/getLatLng/{dong}")
	public ResponseEntity<Address> getLatLng(@PathVariable String dong) {
		Address addr = addressService.getLatLng(dong);
		if(addr != null)
			return new ResponseEntity<Address>(addr, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "검색 아파트가 가장 많은 지역의 좌표를 반환한다.", response = Address.class)
	@GetMapping(value = "/getMaxArea/{searchInput}")
	public ResponseEntity<Address> getMaxArea(@PathVariable String searchInput) {
		Address addr = addressService.getMaxArea(searchInput);
		if(addr != null)
			return new ResponseEntity<Address>(addr, HttpStatus.OK);
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
