package com.itwill.vo;

import java.util.Date;

/*
이름            널?       유형            
------------- -------- ------------- 
BOARD_NO      NOT NULL NUMBER        
BOARD_DATE             DATE          
BOARD_CONTENT          VARCHAR2(255) 
BOARD_RATING           NUMBER        
STORE_NO               NUMBER   
 */
public class Board {
	private int board_no;
	private String board_date;
	private String board_content;
	private int board_rating;
	private int store_no;
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int board_no, String board_date, String board_content, int board_rating, int store_no) {
		super();
		this.board_no = board_no;
		this.board_date = board_date;
		this.board_content = board_content;
		this.board_rating = board_rating;
		this.store_no = store_no;
	}
	
	public Board(String board_content, int board_rating, int store_no) {
		super();
		this.board_content = board_content;
		this.board_rating = board_rating;
		this.store_no = store_no;
	}

	public Board(int board_no, String board_content, int board_rating, int store_no) {
		super();
		this.board_no = board_no;
		this.board_content = board_content;
		this.board_rating = board_rating;
		this.store_no = store_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_rating() {
		return board_rating;
	}

	public void setBoard_rating(int board_rating) {
		this.board_rating = board_rating;
	}

	public int getStore_no() {
		return store_no;
	}

	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_date=" + board_date + ", board_content=" + board_content + ", board_rating="
				+ board_rating + ", store_no=" + store_no + "]";
	}
	
}

