package com.itwill.dao;

public class JumunSQL {
public static final String JUMUN_INSERT=
"insert into jumun values(?,?,?,?,?,?,?)";
public static final String JUMUN_SELECT_BY_MEMBER_NO=
"select * from jumun where member_no=?";
public static final String JUMUN_SELECT_ALL=
"select * from jumun";
public static final String JUMUN_UPDATE_BY_JUMUN_NO=
"update jumun set jumun_quantity=?, jumun_sum=?,jumun_request=?,jumun_payment=?,food_no=? where jumun_no=?";
public static final String JUMUN_DELETE_BY_JUMUN_NO=
"delete jumun where jumun_no=?";
}
