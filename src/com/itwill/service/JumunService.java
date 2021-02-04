package com.itwill.service;

import java.util.List;

import com.itwill.dao.FoodDao;
import com.itwill.dao.JumunDao;
import com.itwill.dao.StoreDao;
import com.itwill.vo.Card;
import com.itwill.vo.Food;
import com.itwill.vo.MemberInfo;
import com.itwill.vo.Store;

public class JumunService {
	private JumunDao jumunDao;
	private FoodDao foodDao;
	private StoreDao storeDao;
	
	public JumunService() {
		jumunDao = new JumunDao();
		foodDao = new FoodDao();
		storeDao = new StoreDao();
	}
	
	
	/*
	 * 장바구니:메뉴선택내용,수량수정,합계금액,메뉴삭제
	 * 
	 * 주문내역:주문날짜,매장이름,주문메뉴,배달예상시간,합계금액
	 *          결제방식,주문자정보(요청사항,연락처,주소),리뷰작성(board이동)
	 * 
	 * 결제:주문번호,주문시간,요청사항,주소확인&수정,결제수단선택
	 */
	//장바구니 목록
	public List<Food> selectByCategoryNo(int CategoryNo) throws Exception {
		return foodDao.selectByCategoryNo(CategoryNo);
	}
	//가게명
	public List<Store> selectStoreAll() throws Exception {
		return storeDao.selectAll();
	}
}
