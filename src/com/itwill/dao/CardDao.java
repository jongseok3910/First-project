package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

	public int deleteByNo(String card_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.CARD_DELETE);
		pstmt.setString(1, card_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}