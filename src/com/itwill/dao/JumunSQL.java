package com.itwill.dao;
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
public class JumunSQL {
public static final String JUMUN_INSERT=
"insert into jumun values(JUMUN_SEQ1.NEXTVAL,?,?,?,?,sysdate,?,?,?)";
public static final String JUMUN_SELECT_BY_MEMBER_NO=
"select * from jumun where member_no=? order by jumun_paymenttime desc";
public static final String JUMUN_SELECT_BY_JUMUN_NO=
"select * from jumun where jumun_no=?";
public static final String JUMUN_SELECT_ALL=
"select * from jumun";
public static final String JUMUN_UPDATE_BY_JUMUN_NO=
"update jumun set jumun_quantity=?, jumun_sum=?,jumun_request=?,jumun_paymentType=?,jumun_paymentTime=?,member_no=?,food_no=?,store_no=? where jumun_no=?";
public static final String JUMUN_DELETE_BY_JUMUN_NO=
"delete jumun where jumun_no=?";
}
