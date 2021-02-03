package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.Board;

public class BoardDao {
	public int create(Board board) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(BoardSQL.BOARD_INSERT);
		pstmt.setInt(1,board.getBoard_no());
		pstmt.setString(2,board.getBoard_content());
		pstmt.setInt(3,board.getBoard_rating());
		pstmt.setInt(4,board.getStore_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	
	public Board selectByNo(int store_no) throws Exception {
		Board board = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BoardSQL.BOARD_SELECT_BY_NO);
		pstmt.setInt(1,store_no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			board = new Board(rs.getInt("board_no"),
					          rs.getDate("board_date"),
					          rs.getString("board_content"),
					          rs.getInt("board_rating"),
					          rs.getInt("store_no")
					 	 	 );
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return board;
		
	}
	public List<Board> selectAll() throws Exception {
		ArrayList<Board> boardList = new ArrayList<Board>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BoardSQL.BOARD_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			boardList.add(new Board(rs.getInt("board_no"),
					  rs.getDate("board_date"),
			          rs.getString("board_content"),
			          rs.getInt("board_rating"),
			          rs.getInt("store_no")
			          ));
					
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return boardList;
				
	}
	public int updateByNo(Board board) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BoardSQL.BOARD_UPDATE_BY_NO);
		pstmt.setString(1,board.getBoard_content());
		pstmt.setInt(2,board.getBoard_rating());
		pstmt.setInt(3,board.getStore_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;

	}
	public int deleteByNo(int board_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BoardSQL.BOARD_DELETE_BY_NO);
		pstmt.setInt(1,board_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
