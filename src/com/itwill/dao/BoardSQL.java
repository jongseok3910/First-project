package com.itwill.dao;
public class BoardSQL {
public static final String BOARD_INSERT=
"insert into board(board_no, board_date, board_content, board_rating, store_no) values(board_seq1.nextval,sysdate,?,?,?)";
public static final String BOARD_SELECT_BY_STORE_NO=
"select * from board where store_no=?";
public static final String BOARD_SELECT_ALL=
"select * from board";
public static final String BOARD_UPDATE_BY_NO=
"update board set board_content=?, board_rating=?, store_no=? where board_no=?";
public static final String BOARD_DELETE_BY_NO=
"delete board where board_no=?";

}
