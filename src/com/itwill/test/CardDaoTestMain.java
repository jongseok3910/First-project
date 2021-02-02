package com.itwill.test;

import com.itwill.dao.CardDao;
import com.itwill.vo.Card;

public class CardDaoTestMain {

	public static void main(String[] args) throws Exception {
		CardDao cardDao = new CardDao();
		Card card = new Card("0000-0000-0000-0000", "21/11", 123, 999999);
//		create test		
		//System.out.println("insert : " + cardDao.create(new Card("0000-0000-0000-0000", "21/11", 123, 999999)));
//		cardDao.create(card);
		System.out.println("insert : " + cardDao.create(card));
		
	}

}
