package com.itwill.dao;

public class JumunSQL {
public static final String JUMUN_INSERT=
"insert into JUMUN(jumun_no,jumun_quantity,jumun_sum,jumun_payment,jumun_request,jumun_estimatedTime,card_no,member_no,food_no) values(?,?,?,?,?,?,?,?,?)";
public static final String JUMUN_UPDATE=
"update jumun set jumun_quantity=?, jumun_sum=?,jumun_payment=?,jumun_request=?,card_no=?,food_no=? where member_no";
public static final String JUMUN_DELETE=
"delete jumun where member_no=?";
public static final String JUMUN_SELECT_MEMBER_NO=
"select jumun_no,jumun_quantity,jumun_sum,jumun_payment,jumun_request,jumun_estimatedTime,card_no,food_no where member_no=?";
public static final String JUMUN_SELECT_ALL=
"select * from jumun";
}
