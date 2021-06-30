package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.Address;
import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.House;
import com.ssafy.happyhouse.model.service.AddressService;
import com.ssafy.happyhouse.model.service.BoardService;
import com.ssafy.happyhouse.model.service.HouseService;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class RestfulController {

	private static final Logger logger = LoggerFactory.getLogger(RestfulController.class);
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private HouseService houseService;
	
	
	@Autowired
	private BoardService boardService;
	/*
	 * @PostMapping(value = "/centerMark") public ResponseEntity<List<Double>>
	 * centerMark() { List<Double> list = new ArrayList<>(); list.add(300.0);
	 * list.add(300.0); if(list != null) return new
	 * ResponseEntity<List<Double>>(list, HttpStatus.OK); else return new
	 * ResponseEntity(HttpStatus.NO_CONTENT); }
	 */
	
	@PostMapping(value = "/houseMark")
	public ResponseEntity<List<House>> houseMark() {
		List<House> list =  houseService.houseList();
		if(list != null)
			return new ResponseEntity<List<House>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/getSido")
	public ResponseEntity<List<String>> getSido() {
		List<String> list = addressService.getSido();
		if(list != null)
			return new ResponseEntity<List<String>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/searchGugun/{city}")
	public ResponseEntity<List<Address>> searchGugun(@PathVariable String city) {
		List<Address> list = addressService.searchGugun(city); 
		if(list != null)
			return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/searchDong/{gugun}")
	public ResponseEntity<List<Address>> searchDong(@PathVariable String gugun) {
		List<Address> list = addressService.searchDong(gugun); 
		if(list != null)
			return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/boardList")
	public ResponseEntity<List<Board>> boardList(){
		List<Board> boardList = boardService.boardList();
		if(boardList != null)
			return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping(value = "/boardSearch/{data}")
	public ResponseEntity<List<Board>> searchPost(@PathVariable String data){
		System.out.println(data);
		List<Board> boardList = boardService.searchPost(data);
		if(boardList != null)
			return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping(value = "/board")
	public ResponseEntity<Board> selectList(@PathVariable String userId){
		Board board = boardService.selectList(userId);
		if(board != null)
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	@PostMapping(value = "/board")
	public void writeBoard(@RequestBody Board board) {
		boardService.writeBoard(board);
	}
	
	@PutMapping(value = "/board")
	public void modifyBoard(@RequestBody Board board) {
		boardService.modifyBoard(board);
	}
	
	@DeleteMapping(value = "/board/{num}")
	public void deleteBoard(@PathVariable("num") int num) {
		boardService.deleteBoard(num);
	}
	
}
