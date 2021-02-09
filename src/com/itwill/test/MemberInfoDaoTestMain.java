package com.itwill.test;

import java.lang.reflect.Member;
import java.util.List;

import com.itwill.dao.BoardDao;
import com.itwill.dao.MemberInfoDao;
import com.itwill.vo.MemberInfo;

public class MemberInfoDaoTestMain {

    public static void main(String[] args) throws Exception{

        //MemberInfo MemberInfo= new MemberInfo (null,"ID10","1111","이현민","010-1234-5678","경기도 다산동",null);
    	MemberInfoDao memberInfoDao = new MemberInfoDao();
        
        
//      create test -> 오류 
        //System.out.println("insert: " + memberInfoDao.create(MemberInfo));

//		selectByID test 성공
//		System.out.println("selectByID : " + memberInfoDao.selectById("ID1"));
		
//		selectByCardNo test 성공
//		System.out.println("selectByID : " + memberInfoDao.selectByCardNo("4685-0046-4764-8858"));
		
//		selectAll test 성공
        List<MemberInfo> memberList = memberInfoDao.selectAll();
        for (MemberInfo member : memberList) {
			System.out.println(member.getMember_name());
		}
		//System.out.println("selectAll : " + memberInfoDao.selectAll());
		
//		updateByName test
//		System.out.println("updateByID : " + memberInfoDao.updateById("3213-4213-3333-1242","T","ID5"));
		
//		deleteByName test
//		System.out.println("deleteByID : " + memberInfoDao.deleteById("ID4"));
   

    }
}