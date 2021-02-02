package com.itwill.vo;
/*
이름            널?       유형           
------------- -------- ------------ 
CARD_NO       NOT NULL VARCHAR2(19) 
CARD_VALIDITY          DATE         
CARD_CVC               NUMBER       
CARD_PASSWORD          NUMBER    
 */

import java.util.Date;

public class Card {
	private String card_no;
	private String card_validity;
	private int card_cvc;
	private int card_password;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String card_no, String card_validity, int card_cvc, int card_password) {
		super();
		this.card_no = card_no;
		this.card_validity = card_validity;
		this.card_cvc = card_cvc;
		this.card_password = card_password;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getCard_validity() {
		return card_validity;
	}

	public void setCard_validity(String card_validity) {
		this.card_validity = card_validity;
	}

	public int getCard_cvc() {
		return card_cvc;
	}

	public void setCard_cvc(int card_cvc) {
		this.card_cvc = card_cvc;
	}

	public int getCard_password() {
		return card_password;
	}

	public void setCard_password(int card_password) {
		this.card_password = card_password;
	}

	@Override
	public String toString() {
		return "Card [card_no=" + card_no + ", card_validity=" + card_validity + ", card_cvc=" + card_cvc
				+ ", card_password=" + card_password + "]";
	}
	
}
