package com.itwill.test;
/*
 * test 완료
 */
import com.itwill.dao.FoodDao;
import com.itwill.vo.Food;

public class FoodDaoTestMain {

	public static void main(String[] args) throws Exception {
		FoodDao foodDao = new FoodDao();
		
//		create method test
//		System.out.println("insert : " + foodDao.create(new Food(121, "테스트샌드위치", 5000, 10)));
//		System.out.println("insert : " + foodDao.create(new Food(122, "테스트샌드위치", 5000, 10)));
		
//		selectByNo test
//		System.out.println("select_byNo : " + foodDao.selectByNo(120));
//		foodDao.selectByNo(120);
		
//		selectByName test
//		System.out.println("select_name : " + foodDao.selectByName("코카콜라"));
		
//		selectByPrice test
//		System.out.println("select_price : " + foodDao.selectByPrice(3000, 5000));
		
//		selectByCategoryNo test
		System.out.println("select_categoryNo : " + foodDao.selectByCategoryNo(10));
		
//		selectAll test
//		System.out.println("select_all : " + foodDao.selectAll());
		
//		updateByNo test
//		System.out.println("update_byNo : " + foodDao.updateByNo(new Food(121,"업데이트샌드위치",9000,10)));
		
//		updateByName test
//		System.out.println("update_byName : " + foodDao.updateByName(new Food(121,"업데이트샌드위치",8888,10)));

//		deleteByNo test
//		System.out.println("deleteByNo : " + foodDao.deleteByNo(121));
		
//		deleteByName test
//		System.out.println("deleteByName : " + foodDao.deleteByName("테스트샌드위치"));
		
//		deleteByCategoryNo test
//		System.out.println("deleteByCategoryNo : " + foodDao.deleteByCategoryNo(60));
	}

}
