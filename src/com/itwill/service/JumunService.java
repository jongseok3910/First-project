package com.itwill.service;

import com.itwill.dao.JumunDao;
import com.itwill.vo.Card;
import com.itwill.vo.Food;
import com.itwill.vo.MemberInfo;
import com.itwill.vo.Store;

public class JumunService {
	private JumunDao jumunDao;
	private Food food;
	private MemberInfo memberInfo;
	private Card card;
	private Store store;
	
	public JumunService() {
		jumunDao = new JumunDao();
		food = new Food();
		memberInfo = new MemberInfo();
		card = new Card();
		store = new Store();
	}
	
	
/*
 * 장바구니:메뉴선택내용,수량수정,합계금액,메뉴삭제
 * 
 * 주문내역:주문날짜,매장이름,주문메뉴,배달예상시간,합계금액
 *          결제방식,주문자정보(요청사항,연락처,주소),리뷰작성(board이동)
 * 
 * 결제:주문번호,주문시간,요청사항,주소확인&수정,결제수단선택
 */
}
