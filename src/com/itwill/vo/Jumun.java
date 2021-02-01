package com.itwill.vo;
/*
이름                  널?       유형            
------------------- -------- ------------- 
JUMUN_NO            NOT NULL NUMBER        
JUMUN_QUANTITY               NUMBER        
JUMUN_SUM                    NUMBER        
JUMUN_PAYMENT                VARCHAR2(10)  
JUMUN_REQUEST                VARCHAR2(255) 
JUMUN_ESTIMATEDTIME          VARCHAR2(30)  
CARD_NO                      VARCHAR2(19)  
MEMBER_NO                    NUMBER        
FOOD_NO                      NUMBER      
 */
public class Jumun {
	private int jumun_no;
	private int jumun_quantity;
	private int jumun_sum;
	private String jumun_payment;
	private String jumun_request;
	private String jumun_estimatedTime;
	private String card_no;
	private int member_no;
	private int food_no;
	
	public Jumun() {
		// TODO Auto-generated constructor stub
	}

	public Jumun(int jumun_no, int jumun_quantity, int jumun_sum, String jumun_payment, String jumun_request,
			String jumun_estimatedTime, String card_no, int member_no, int food_no) {
		super();
		this.jumun_no = jumun_no;
		this.jumun_quantity = jumun_quantity;
		this.jumun_sum = jumun_sum;
		this.jumun_payment = jumun_payment;
		this.jumun_request = jumun_request;
		this.jumun_estimatedTime = jumun_estimatedTime;
		this.card_no = card_no;
		this.member_no = member_no;
		this.food_no = food_no;
	}

	public int getJumun_no() {
		return jumun_no;
	}

	public void setJumun_no(int jumun_no) {
		this.jumun_no = jumun_no;
	}

	public int getJumun_quantity() {
		return jumun_quantity;
	}

	public void setJumun_quantity(int jumun_quantity) {
		this.jumun_quantity = jumun_quantity;
	}

	public int getJumun_sum() {
		return jumun_sum;
	}

	public void setJumun_sum(int jumun_sum) {
		this.jumun_sum = jumun_sum;
	}

	public String getJumun_payment() {
		return jumun_payment;
	}

	public void setJumun_payment(String jumun_payment) {
		this.jumun_payment = jumun_payment;
	}

	public String getJumun_request() {
		return jumun_request;
	}

	public void setJumun_request(String jumun_request) {
		this.jumun_request = jumun_request;
	}

	public String getJumun_estimatedTime() {
		return jumun_estimatedTime;
	}

	public void setJumun_estimatedTime(String jumun_estimatedTime) {
		this.jumun_estimatedTime = jumun_estimatedTime;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getFood_no() {
		return food_no;
	}

	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}

	@Override
	public String toString() {
		return "Jumun [jumun_no=" + jumun_no + ", jumun_quantity=" + jumun_quantity + ", jumun_sum=" + jumun_sum
				+ ", jumun_payment=" + jumun_payment + ", jumun_request=" + jumun_request + ", jumun_estimatedTime="
				+ jumun_estimatedTime + ", card_no=" + card_no + ", member_no=" + member_no + ", food_no=" + food_no
				+ "]";
	}
	
}
