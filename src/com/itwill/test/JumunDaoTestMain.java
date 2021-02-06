package com.itwill.test;

import java.util.List;

import com.itwill.dao.JumunDao;
import com.itwill.vo.Jumun;

public class JumunDaoTestMain {

	public static void main(String[] args) throws Exception {
		JumunDao jumunDao = new JumunDao();
		/*
		Jumun jumun = new Jumun(3,
				   10000,
				   "많이주세요",
				   "카드결제",
				   "2021020410",
				   120,
				   6);
		/*
		jumunDao.create(jumun);
		//int no=jumunDao.create(jumun);
		//System.out.println(no);
		*/
		jumunDao.updateByTypeIsNull("실험2", "카드결제22", "202102041");
	}

}
