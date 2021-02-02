package com.itwill.dao;

public class StoreSQL {
public static final String STORE_INSERT=
"insert into Store(store_no,store_name,store_businessTime,store_phone,store_address,store_deliveryPrice,jumun_estimatedTime,store_rating,category_no,jumun_no) values(?,?,?,?,?,?,?,?,?,?)"; 
public static final String STORE_UPDATE=
"update store set store_name=?,store_businessTime=?,store_phone=?,store_address=?,store_deliveryPrice=?,jumun_estimatedTime=?,store_rating=?,category_no=?,jumun_no=? where store_no=?";
public static final String STORE_DELETE=
"delete store where store_no=?";
public static final String STORE_SELECT=
"select store_name,store_businessTime,store_phone,store_address,store_deliveryPrice,jumun_estimatedTime,store_rating,category_no,jumun_no where store_no=?";
public static final String STORE_SELECT_ALL=
"select * from store";
}
