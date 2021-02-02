package com.itwill.dao;

public class MemberInfoSQL {
	public static final String MEMBERINFO_INSERT=
			"insert into memberinfo values(to_char(sysdate,'YYYY/MM/DD')||member_seq1.nextval,?,?,?)";
	public static final String MEMBERINFO_SELECT_BY_ID=
			"select * from memberinfo where member_id=?";
	public static final String MEMBERINFO_SELECT_BY_CARD_NO=
			"select * from memberinfo where card_no=?";
	public static final String MEMBERINFO_SELECT_ALL=
			"select * from memberinfo";
	public static final String MEMBERINFO_UPDATE_BY_ID=
			"update memberinfo set card_no=?,member_autulogin=? where member_id=?";
	public static final String MEMBERINFO_DELETE_BY_ID=
			"delete memberinfo where member_id=?";
}
