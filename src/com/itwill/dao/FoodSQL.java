package com.itwill.dao;

public class FoodSQL {
	public static final String FOOD_INSERT=
			"insert into food values(?,?,?,?)";
	public static final String FOOD_SELECT_BY_NO=
			"select * from food where food_no=?";
	public static final String FOOD_SELECT_BY_NAME=
			"select * from food where food_name=?";
	public static final String FOOD_SELECT_BY_PRICE=
			"select * from food where food_price>=? and food_price <= ?";
	public static final String FOOD_SELECT_BY_CATEGORY_NO=
			"select * from food where category_no=?";
	public static final String FOOD_SELECT_ALL=
			"select * from food";
	public static final String FOOD_UPDATE_BY_NO=
			"update food set food_name=?,food_price=?,category_no=? where food_no=?";
	public static final String FOOD_UPDATE_BY_NAME=
			"update food set food_no=?,food_price=?,category_no=? where food_name=?";
	public static final String FOOD_DELETE_BY_NO=
			"delete food where food_no=?";
	public static final String FOOD_DELETE_BY_NAME=
			"delete food where food_name=?";
	public static final String FOOD_DELETE_BY_CATEGORY_NO=
			"delete food where category_no=?";
}
