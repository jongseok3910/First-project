package com.itwill.test;

import java.lang.reflect.Member;

import com.itwill.dao.MemberInfoDao;
import com.itwill.vo.MemberInfo;

public class MemberInfoDaoTestMain {

	public static void main(String[] args) throws Exception{
		
		MemberInfoDao memberInfoDao = new MemberInfoDao();
		
		System.out.println("create: " + memberInfoDao.create(new MemberInfo(1,"aaa","1234-1234",null)));
		/*
		MemberInfo memberInfo =  memberInfoDao.selectById("aaa");
		
		System.out.println("selectById : " + memberInfo);
		
		memberInfo.setMember_no(1);
		memberInfo.setMember_id("aaa");
		memberInfo.setCard_no("1234-1234");
		memberInfo.setMember_autologin(null);
		*/
		
		
	}
}
