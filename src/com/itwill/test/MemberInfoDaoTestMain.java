package com.itwill.test;

import java.lang.reflect.Member;

import com.itwill.dao.MemberInfoDao;
import com.itwill.vo.MemberInfo;

public class MemberInfoDaoTestMain {

	public static void main(String[] args) throws Exception{
		
		MemberInfoDao memberInfoDao = new MemberInfoDao();

		System.out.println("create: " + memberInfoDao.create(new MemberInfo("2021/02/028","ID6","6486-5774-1331-6456",null)));
		
		
		/*
		MemberInfo memberInfo =  memberInfoDao.selectById(ID6");
		
		System.out.println("selectById : " + memberInfo);
		
		memberInfo.setMember_no("6");
		memberInfo.setMember_id("ID6");
		memberInfo.setCard_no("6486-5774-1331-6456");
		memberInfo.setMember_autologin(null);
		*/
		
		
	}
}
