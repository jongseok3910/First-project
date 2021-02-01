package com.itwill.vo;
/*
이름               널?       유형           
---------------- -------- ------------ 
MEMBER_NO        NOT NULL NUMBER       
MEMBER_ID                 VARCHAR2(10) 
CARD_NO                   VARCHAR2(19) 
MEMBER_AUTOLOGIN          VARCHAR2(1)  
 */
public class MemberInfo {
	private int member_no;
	private String member_id;
	private String card_no;
	private char member_autologin;
}
