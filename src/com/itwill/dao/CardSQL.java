package com.itwill.dao;

public class CardSQL {
	
public static final String CARD_INSERT=
"insert into card values(?,?,?,?,?)";

public static final String CARD_DELETE=
"delete card where card_no=?";

}
