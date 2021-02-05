package com.itwill.test;

import com.itwill.dao.CardDao;
import com.itwill.vo.Card;


public class CardDaoTestMain {

	public static void main(String[] args) throws Exception {
		Card card = new Card("2323-3454-6666-3345","54/34", 777,878787,"202102038");
		CardDao cardDao = new CardDao();
		
//		create method test
//		System.out.println("insert : " + cardDao.create(card));
		
//		updateByMemberNo method test
//		System.out.println("updateByMemberNo : " + cardDao.updateByNo(new Card("4444-4444-4444-4444","54/23",898,567567,"202102031")));
		
//		deleteByCardNo method test
//		System.out.println("deleteByCardNo : " + cardDao.deleteByNo("1465-1111-2222-6337"));
		
//		selectByMemberNo method test
//		System.out.println("selectByMemberNo : " + cardDao.selectByMemberNo("202102034"));
	}

}
