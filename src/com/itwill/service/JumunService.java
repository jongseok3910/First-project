package com.itwill.service;

import java.util.List;

import com.itwill.dao.FoodDao;
import com.itwill.dao.JumunDao;
import com.itwill.dao.StoreDao;
import com.itwill.vo.Card;
import com.itwill.vo.Food;
import com.itwill.vo.Jumun;
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
	//푸드명으로 정보찾기
	public Food selectByFoodName(String food_name) throws Exception {
		return foodDao.selectByName(food_name);
	}
	//푸드넘버로 정보찾기
	public Food selectByFoodNo(int food_no) throws Exception {
		return foodDao.selectByNo(food_no);
	}
	//주문정보 입력
	public int JumunInsert(Jumun jumun) throws Exception {
		int rowCount = jumunDao.create(jumun);
		return rowCount;
	}
	//주문정보 찾기
	public Jumun SelectByJumunNo(int jumun_no) throws Exception {
		return jumunDao.selectByJumunNo(jumun_no);
	}
}
