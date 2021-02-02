package com.itwill.test;

import com.itwill.dao.BoardDao;
import com.itwill.vo.Board;

public class BoardDaoTestMain {
	
	public static void main(String[] args) throws Exception {
		Board board = new Board(1, "안녕하세요", 1, 1);
		BoardDao boardDao = new BoardDao();
//		create test
//		System.out.println("insert : " + boardDao.create(board));
		
//		selectByNo test --> 오류
//		System.out.println("selectByNo : " + boardDao.selectByNo(1));
		
//		selectAll.test --> 오류
//		System.out.println("selectAll : " + boardDao.selectAll());
		
//		updateByNo.test --> 오류
//		System.out.println("updateByNo : " + boardDao.updateByNo(new Board(1,"변경합니다",2,1)));
		
//		deleteByNo.test 
		System.out.println("deleteByNo : " + boardDao.deleteByNo(1));
	}

	
	
}
