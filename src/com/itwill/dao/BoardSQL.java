package com.itwill.dao;
/*
Dao(Data Access Object)
 - 회원들의 데이터를 저장하고있는 파일(테이블)에
   CRUD(Create, Read, Update, Delete) 작업을 할수있는
   단위메쏘드를 가지고있는 클래스

 - MemberService객체 의 요청(메쏘드호출)을 받아서 
   Data Access(File, DB)에 관련된 단위기능(CRUD)을
   수행하는 객체
 */
public class BoardSQL {
public static final String BOARD_INSERT=
"insert into BOARD(board_no, board_date, board_content, board_rating, store_no) values(?,sysdate,?,?,?)";
public static final String BOARD_UPDATE=
"update board set board_content=?, board_rating=?, store_no=? where board_no=?";
public static final String BOARD_DELETE=
"delete board where board_no=?";
public static final String BOARD_SELECT_STORE_NO=
"select board_no, board_date, board_content, board_rating, from board where store_no=?";
public static final String BOARD_SELECT_ALL=
"select * from board";
}
