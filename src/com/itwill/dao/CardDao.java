package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.Card;

public class CardDao {
	public int create(Card card) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.CARD_INSERT);
		pstmt.setString(1, card.getCard_no());
		pstmt.setString(2, card.getCard_validity()); 
		pstmt.setInt(3, card.getCard_cvc());
		pstmt.setInt(4, card.getCard_password());
		pstmt.setString(5, card.getMember_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}

	public int deleteByCardNo(String card_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.CARD_DELETE);
		pstmt.setString(1, card_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	
	
	public int updateByMemberNo(Card card) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.CARD_UPDATE_BY_MEMBER_NO);
		pstmt.setString(1, card.getCard_no());
		pstmt.setString(2, card.getCard_validity()); 
		pstmt.setInt(3, card.getCard_cvc());
		pstmt.setInt(4, card.getCard_password());
		pstmt.setString(5, card.getMember_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public Card selectByMemberNo(String member_no) throws Exception{
		Card card = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.CARD_SELECT_BY_MEMBER_NO);
		pstmt.setString(1, member_no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			card = new Card(rs.getString("card_no"),
						rs.getString("card_validity"),
						rs.getInt("card_cvc"),
						rs.getInt("card_password"),
						rs.getString("member_no"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return card;
	}
	
	
	
	
}