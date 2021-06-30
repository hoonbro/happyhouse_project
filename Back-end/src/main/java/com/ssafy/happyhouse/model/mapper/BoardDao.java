package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.Board;


public interface BoardDao {

	//쓰기
	void writeBoard(Board boardDto);
	//목록
	List<Board> boardList();
	//하나
	Board selectList(String userId);
	//삭제
	void deleteBoard(int num);
	//수정
	void modifyBoard(Board boardDto);
	//검색
	List<Board> searchPost(String searchInput);
}
