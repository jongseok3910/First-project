package com.itwill.test;
/*
 * 테스트완료
 */
import com.itwill.dao.BoardDao;
import com.itwill.vo.Board;

public class BoardDaoTestMain {

	public static void main(String[] args) throws Exception {
		Board board = new Board("안녕하세요", 3, 1);
		BoardDao boardDao = new BoardDao();
//		create test
//		System.out.println("insert : " + boardDao.create(board));

//		selectByNo test 
//		System.out.println("selectByStoreNo : " + boardDao.selectByStoreNo(1));

//		selectAll.test 
//		System.out.println("selectAll : " + boardDao.selectAll());

//		updateByNo.test 
//		System.out.println("updateByNo : " + boardDao.updateByNo(new Board(6,"가나",2,1)));

//		deleteByNo.test 
//		System.out.println("deleteByNo : " + boardDao.deleteByNo(6));
	}

}
	
	

