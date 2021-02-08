package com.itwill.service;

import java.util.List;

import com.itwill.dao.MemberInfoDao;
import com.itwill.vo.MemberInfo;


public class MemberService {
	private MemberInfoDao memberInfoDao;
	
	public MemberService() {
		memberInfoDao=new MemberInfoDao();
	}
	//1.회원가입
	/*
	 * 	아이디 존재여부체크(아이디 중복체크 기능구현)
	 * -존재하면 메세지:아이디중복(가입불가 기능)
	 * -존재안하면 가입:순서대로 정보 입력
	 */
	public boolean memberIdCheck(String idStr) throws Exception{
		boolean isRegister=false;
		if (!isExistedId(idStr)) {
			isRegister=true;
		} else {
			isRegister=false;
		}
		return isRegister;
	}
	public boolean memberRegister(MemberInfo newMemberInfo) throws Exception{
		boolean isRegister=false;
		if (!isExistedId(newMemberInfo.getMember_id())) {
			memberInfoDao.create(newMemberInfo);
			isRegister=true;
		} else {
			isRegister=false;
		}
		return isRegister;
	}
	
	
	//2.회원탈퇴
	/*
	 * 회원탈퇴 확인 체크
	 * 아이디 삭제(delete사용)
	 */
	public int memberUnRegister(String id) throws Exception{
		return memberInfoDao.deleteById(id);
		
	}
	//3.로그인
	/*
	 * 	성공
	 * 아이디존재안함
	 * 패스워드불일치
	 */
	public int login(String id,String password) throws Exception{
		/*
		 * 0.성공
		 * 1. 아이디존재안함
		 * 2. 패스워드 불일치
		 */
		int result=-9999;
		if (isExistedId(id)) {
			//아이디 존재
			MemberInfo findMember = memberInfoDao.selectById(id);
			if (findMember.getMember_password().equals(password)) {
				//패스워드 일치
				result=0;
			}else {
				//패스워드 불일치
				result=2;
			}
		}else {
			//아이디 존재안함
			result=1;
		}
		return result;
	}
	//5.회원정보보기&수정
	/*
	 * 회원아이디로 1명정보 검색(select by id사용)
	 * 정보수정(update사용)
	 */
	public MemberInfo selectById(String idStr) throws Exception {
		return memberInfoDao.selectById(idStr);
	}
	//전체멤버 보기
	public List<MemberInfo> selectMemberAll() throws Exception {
		return memberInfoDao.selectAll();
	}
	
	public int memberUpdate(MemberInfo memberInfo) throws Exception{
		return memberInfoDao.updateById(memberInfo);
	}
	public boolean isExistedId(String id)  throws Exception{
		boolean isExisted=false;
		MemberInfo memberInfo = memberInfoDao.selectById(id);
		if(memberInfo==null) {
			isExisted=false;
		}else if(memberInfo!=null) {
			isExisted=true;
		}
		return isExisted;
	}
	
}
