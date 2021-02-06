package com.itwill.service;

import java.util.List;

import com.itwill.dao.CardDao;
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
	private CardDao cardDao;
	
	public JumunService() {
		jumunDao = new JumunDao();
		foodDao = new FoodDao();
		storeDao = new StoreDao();
		cardDao = new CardDao();
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
	/*
	//주문정보 입력
	public int jumunInsert(Jumun jumun) throws Exception {
		jumunDao.create(jumun);
		return jumunDao.selectJumunSeqNo();
		
	}
	//주문정보 찾기
	public Jumun selectByJumunNo(int jumun_no) throws Exception {
		return jumunDao.selectByJumunNo(jumun_no);
	}
	*/
	//주문정보 입력 및 찾기
	public int jumunInsert(Jumun jumun) throws Exception {
		return jumunDao.create(jumun);
	}
	//주문정보 찾기
	public Jumun selectByJumunNo(int jumun_no) throws Exception {
		return jumunDao.selectByJumunNo(jumun_no);
	}
	//주문정보 업데이트
	public int updateByJumunNo(Jumun jumun) throws Exception {
		return jumunDao.updateByNo(jumun);
	}
	//Card 등록
	public int CardInsert(Card card) throws Exception {
		return cardDao.create(card);
	}
	// memberNo로 Card찾기 
	public Card selectByCardMemberNo(String member_no) throws Exception{
		return cardDao.selectByMemberNo(member_no);
		
	}
	//주문목록 리스트
	public List<Jumun> selectByJumunMemberNo(String member_no) throws Exception {
		return jumunDao.selectByMemberNo(member_no);
	}
	public List<Jumun> selectByJumunMemberNoTypeIsNotNull(String member_no) throws Exception {
		return jumunDao.selectByMemberNoTypeIsNotNull(member_no);
	}
	//결제안된 목록리스트
	public List<Jumun> selectByJumunTypeIsNull(String member_no) throws Exception {
		return jumunDao.selectByTypeIsNull(member_no);
	}
	//결제하기
	public List<Jumun> updateByJumunTypeIsNull(String request, String paymentType, String member_no) throws Exception {
		return jumunDao.updateByTypeIsNull(request, paymentType, member_no);
	}
}
