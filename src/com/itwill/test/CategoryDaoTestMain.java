/*
 * test 완료
 */
package com.itwill.test;

import com.itwill.dao.CategoryDao;

public class CategoryDaoTestMain {

	public static void main(String[] args) throws Exception {
		CategoryDao categoryDao = new CategoryDao();
//		create test
//		System.out.println("insert : " + categoryDao.create(new Category(70, "테스트")));
		
//		selectByNo test
		System.out.println("selectByNo : " + categoryDao.selectByNo(60));
		
//		selectByName test
		System.out.println("selectByName : " + categoryDao.selectByName("샌드위치"));
		
//		selectAll test
		System.out.println("selectAll : " + categoryDao.selectAll());
		
//		updateByNo test
//		System.out.println("updateByNo : " + categoryDao.updateByNo(new Category(70,"테스트1")));
		
//		updateByName test
//		System.out.println("updatByName : " + categoryDao.updateByName(new Category(80,"테스트1")));
		
//		deleteByNo test
		System.out.println("deleteByNo : " + categoryDao.deleteByNo(80));
		
//		deleteByName test
		System.out.println("deleteByName : " + categoryDao.deleteByName("테스트"));
	}

}
