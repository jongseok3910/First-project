package com.itwill.test;
/*
 * test 완료
 * MemberJoinDao create생성시 -> MemberInfoDao에도 정보 update 해야함
 */
import com.itwill.dao.MemberJoinDao;
import com.itwill.vo.MemberJoin;

public class MemberJoinDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberJoinDao memberJoinDao = new MemberJoinDao();
		
//		create test
//		System.out.println("insert : " + memberJoinDao.create(new MemberJoin("ID6","PW6","테스트","010-6666-6666","서울시 강남구 아이티윌아파트 6동 601호")));

	}

}
