package com.itwill.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.Board;

public class BoardDao {
	public int create(Board board) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(BoardSQL.BOARD_INSERT);
		pstmt.setInt(1, board.getBoard_no());
		pstmt.setString(2, board.getBoard_content());
		pstmt.setInt(3, board.getBoard_rating());
		pstmt.setInt(4, board.getStore_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public Board selectByNo(int store_no) throws Exception {
		Board board=null;
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(BoardSQL.BOARD_SELECT_STORE_NO);
		pstmt.setInt(1, store_no);
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			int board_no=rs.getInt("board_no");
	        Date board_date=rs.getDate("board_date");
	        String board_content=rs.getString("board_content");
	        double board_rating=rs.getDouble("board_rating");
					        
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
	    return board;
	}
	public List<Board> selectAll() throws Exception {
		ArrayList<Board> boardList= new ArrayList<Board>();
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(BoardSQL.BOARD_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int board_no=rs.getInt("board_no");
			Date board_date=rs.getDate("board_no");
	        String board_content=rs.getString("board_content");
	        double board_rating=rs.getDouble("board_rating");
	        int store_no=rs.getInt("store_no");
						
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return boardList;
		
	}
	public int updateByNo(Board board) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BoardSQL.BOARD_UPDATE);
		pstmt.setInt(1, board.getStore_no());
		pstmt.setInt(2, board.getBoard_rating());
		pstmt.setString(3, board.getBoard_content());
		pstmt.setInt(4, board.getBoard_no());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
		
		
	}
	public int deleteByNo(int board_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(BoardSQL.BOARD_DELETE);
		pstmt.setInt(1,board_no);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
