package com.itwill.dao;

public class CardSQL {
	
	public static final String CARD_INSERT=
	"insert into card values(?,?,?,?,?)";
	
	public static final String CARD_UPDATE_BY_MEMBER_NO=
	"update card set card_no=?,card_validity=?,card_cvc=?,card_password=? where member_no=?";
	
	public static final String CARD_DELETE=
	"delete card where card_no=?";

}
