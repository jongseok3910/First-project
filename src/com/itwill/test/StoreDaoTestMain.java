package com.itwill.test;

import com.itwill.dao.StoreDao;
import com.itwill.vo.Store;

public class StoreDaoTestMain {

	public static void main(String[] args) throws Exception {
		StoreDao storeDao = new StoreDao();
		
		///create method test
		System.out.println("insert : " + storeDao.create(new Store(1,"샌드위치","12:00","02-1234-1234","강남역",3500,"1234",12.12,12,12)));

		//selectByName test
		System.out.println("selectByName : " + storeDao.selectByName("샌드위치먹자"));
		
		//selectAll test
		System.out.println("selectAll : " + storeDao.selectAll());
		
		///updateByName test
		System.out.println("updateByName : " + storeDao.updateByName("샌드위치업데잍트"));
		
		//deleteByName test
		System.out.println("deleteByName : " + storeDao.deleteByName("샌드위치"));
	}

}
