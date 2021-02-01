package com.itwill.vo;
/*
이름          널?       유형            
----------- -------- ------------- 
FOOD_NO     NOT NULL NUMBER        
FOOD_NAME            VARCHAR2(255) 
FOOD_PRICE           NUMBER        
CATEGORY_NO          NUMBER
 */

public class Food {
	private int food_no;
	private String food_name;
	private int food_price;
	private int category_no;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(int food_no, String food_name, int food_price, int category_no) {
		super();
		this.food_no = food_no;
		this.food_name = food_name;
		this.food_price = food_price;
		this.category_no = category_no;
	}

	public int getFood_no() {
		return food_no;
	}

	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getFood_price() {
		return food_price;
	}

	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}

	public int getCategory_no() {
		return category_no;
	}

	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	@Override
	public String toString() {
		return "Food [food_no=" + food_no + ", food_name=" + food_name + ", food_price=" + food_price + ", category_no="
				+ category_no + "]";
	}
	
}
