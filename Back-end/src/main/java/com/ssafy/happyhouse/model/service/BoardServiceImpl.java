package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.Board;
import com.ssafy.happyhouse.model.mapper.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		sqlSession.getMapper(BoardDao.class).writeBoard(board);
	}

	@Override
	public List<Board> boardList() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BoardDao.class).boardList();
	}

	@Override
	public Board selectList(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(BoardDao.class).selectList(userId);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		sqlSession.getMapper(BoardDao.class).deleteBoard(num);
	}

	@Override
	public void modifyBoard(Board board) {
		sqlSession.getMapper(BoardDao.class).modifyBoard(board);
	}

	@Override
	public List<Board> searchPost(String searchInput) {
		return sqlSession.getMapper(BoardDao.class).searchPost(searchInput);
	}

}
