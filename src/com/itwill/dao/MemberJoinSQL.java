package com.itwill.dao;

public class MemberJoinSQL {
	public static final String MemberJoin_insert=
			"insert into memberjoin(member_id, member_password, member_name, member_phone, member_address, member_joindate)"
			+ "values(?,?,?,?,?,sysdate)";
}
