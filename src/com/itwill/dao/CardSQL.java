package com.itwill.dao;

public class CardSQL {
	
public static final String Card_insert=
"insert into card(card_no, card_validity, card_cvc, card_password) values(?,?,?,?)";

public static final String Card_delete=
"delete card where card_no";

}
