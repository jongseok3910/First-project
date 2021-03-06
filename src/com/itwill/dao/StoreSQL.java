package com.itwill.dao;

public class StoreSQL {
	public static final String STORE_INSERT=
			"insert into Store values(STORE_SEQ1.NEXTVAL,?,?,?,?,?,?)"; 
	public static final String STORE_SELECT_BY_STORE_NAME=
			"select * from store where store_name=?";
	public static final String STORE_SELECT_BY_STORE_NO=
			"select * from store where store_no=?";
	public static final String STORE_SELECT_ALL=
			"select * from store order by store_no asc";
	public static final String STORE_UPDATE_BY_NO=
			"update store set store_name=?,store_businessTime=?,store_phone=?,store_address=?,jumun_estimatedTime=?,store_rating=? where store_no=?";
	public static final String STORE_UPDATE_BY_NAME=
			"update store set store_businessTime=?,store_phone=?,store_address=?,jumun_estimatedTime=?,store_rating=? where store_name=?";
	public static final String STORE_DELETE_BY_NAME=
			"delete store where store_name=?";
}