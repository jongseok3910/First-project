package com.itwill.dao;

public class CategorySQL {
	public static final String CATEGORY_INSERT=
			"insert into category values(?,?)";
	public static final String CATEGORY_SELECT_BY_NO=
			"select * from category where category_no=?";
	public static final String CATEGORY_SELECT_BY_NAME=
			"select * from category where category_name=?";
	public static final String CATEGORY_SELECT_ALL=
			"select * from category";
	public static final String CATEGORY_UPDATE_BY_NO=
			"update category set category_name=? where category_no=?";
	public static final String CATEGORY_UPDATE_BY_NAME=
			"update category set category_no=? where category_name=?";
	public static final String CATEGORY_DELETE_BY_NO=
			"delete category where category_no=?";
	public static final String CATEGORY_DELETE_BY_NAME=
			"delete category wehre category_name=?";
}
