package com.itwill.dao;

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
