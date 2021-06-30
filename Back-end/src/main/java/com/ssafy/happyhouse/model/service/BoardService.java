package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.Board;

public interface BoardService {
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
