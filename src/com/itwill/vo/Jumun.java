package com.itwill.vo;


/*
이름                널?       유형            
----------------- -------- ------------- 
JUMUN_NO          NOT NULL NUMBER        
JUMUN_QUANTITY             NUMBER        
JUMUN_SUM                  NUMBER        
JUMUN_REQUEST              VARCHAR2(255) 
JUMUN_PAYMENTTYPE          VARCHAR2(30)  
JUMUN_PAYMENTTIME          DATE          
MEMBER_NO                  VARCHAR2(20)  
FOOD_NO                    NUMBER        
STORE_NO                   NUMBER  
 */
public class Jumun {
	private int jumun_no;
	private int jumun_quantity;
	private int jumun_sum;
	private String jumun_request;
	private String jumun_paymentType;
	private String jumun_paymentTime;
	private String member_no;
	private int food_no;
	private int store_no;
	
	public Jumun() {
		// TODO Auto-generated constructor stub
	}
	
	public Jumun(int jumun_quantity, int jumun_sum, String jumun_request, String jumun_paymentType,
			String member_no, int food_no, int store_no) {
		super();
		this.jumun_quantity = jumun_quantity;
		this.jumun_sum = jumun_sum;
		this.jumun_request = jumun_request;
		this.jumun_paymentType = jumun_paymentType;
		this.member_no = member_no;
		this.food_no = food_no;
		this.store_no = store_no;
	}

	public Jumun(int jumun_no, int jumun_quantity, int jumun_sum, String jumun_request, String jumun_paymentType,
			String jumun_paymentTime, String member_no, int food_no, int store_no) {
		super();
		this.jumun_no = jumun_no;
		this.jumun_quantity = jumun_quantity;
		this.jumun_sum = jumun_sum;
		this.jumun_request = jumun_request;
		this.jumun_paymentType = jumun_paymentType;
		this.jumun_paymentTime = jumun_paymentTime;
		this.member_no = member_no;
		this.food_no = food_no;
		this.store_no = store_no;
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

	public String getJumun_request() {
		return jumun_request;
	}

	public void setJumun_request(String jumun_request) {
		this.jumun_request = jumun_request;
	}

	public String getJumun_paymentType() {
		return jumun_paymentType;
	}

	public void setJumun_paymentType(String jumun_paymentType) {
		this.jumun_paymentType = jumun_paymentType;
	}

	public String getJumun_paymentTime() {
		return jumun_paymentTime;
	}

	public void setJumun_paymentTime(String jumun_paymentTime) {
		this.jumun_paymentTime = jumun_paymentTime;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public int getFood_no() {
		return food_no;
	}

	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}

	public int getStore_no() {
		return store_no;
	}

	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}

	@Override
	public String toString() {
		return "Jumun [jumun_no=" + jumun_no + ", jumun_quantity=" + jumun_quantity + ", jumun_sum=" + jumun_sum
				+ ", jumun_request=" + jumun_request + ", jumun_paymentType=" + jumun_paymentType
				+ ", jumun_paymentTime=" + jumun_paymentTime + ", member_no=" + member_no + ", food_no=" + food_no
				+ ", store_no=" + store_no + "]";
	}
	
	
}
