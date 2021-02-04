package com.itwill.test;
/*
 * test 완료
 */
import com.itwill.dao.CardDao;
import com.itwill.vo.Card;

public class CardDaoTestMain {

	public static void main(String[] args) throws Exception {
		CardDao cardDao = new CardDao();
		Card card = new Card("1111-1111-1111-1111", "21/21", 1323, 942999,"202102043");

//		create test
//		System.out.println("insert : " + cardDao.create(card));
		
//		delete test
//		System.out.println("delete : " + cardDao.deleteByNo("0000-0000-0000-0000"));
		
//		update test
//		System.out.println("update : " + cardDao.updateByNo(new Card("4444-2222-3333-4444","21/01",111,6666,"202102042")));
	}

}
