package com.itwill.vo;
/*
이름                  널?       유형           
------------------- -------- ------------ 
STORE_NO            NOT NULL NUMBER       
STORE_NAME                   VARCHAR2(30) 
STORE_BUSINESSTIME           VARCHAR2(30) 
STORE_PHONE                  VARCHAR2(13) 
STORE_ADDRESS                VARCHAR2(50)       
JUMUN_ESTIMATEDTIME          VARCHAR2(30) 
STORE_RATING                 NUMBER             
 */
public class Store {
	private int store_no;
	private String store_name;
	private String store_businessTime;
	private String store_phone;
	private String store_address;
	private String jumun_estimatedTime;
	private Double store_rating;
	
	public Store() {
		// TODO Auto-generated constructor stub
	}

	public Store(int store_no, String store_name, String store_businessTime, String store_phone, String store_address,
			String jumun_estimatedTime, Double store_rating) {
		super();
		this.store_no = store_no;
		this.store_name = store_name;
		this.store_businessTime = store_businessTime;
		this.store_phone = store_phone;
		this.store_address = store_address;
		this.jumun_estimatedTime = jumun_estimatedTime;
		this.store_rating = store_rating;
	}

	public int getStore_no() {
		return store_no;
	}

	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_businessTime() {
		return store_businessTime;
	}

	public void setStore_businessTime(String store_businessTime) {
		this.store_businessTime = store_businessTime;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getJumun_estimatedTime() {
		return jumun_estimatedTime;
	}

	public void setJumun_estimatedTime(String jumun_estimatedTime) {
		this.jumun_estimatedTime = jumun_estimatedTime;
	}

	public Double getStore_rating() {
		return store_rating;
	}

	public void setStore_rating(Double store_rating) {
		this.store_rating = store_rating;
	}

	@Override
	public String toString() {
		return "Store [store_no=" + store_no + ", store_name=" + store_name + ", store_businessTime="
				+ store_businessTime + ", store_phone=" + store_phone + ", store_address=" + store_address
				+ ", jumun_estimatedTime=" + jumun_estimatedTime + ", store_rating=" + store_rating + "]";
	}
	
}
