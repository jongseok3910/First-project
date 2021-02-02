package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.vo.Card;

public class CardDao {
	public void create(Card card) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.Card_insert);
		pstmt.setString(1, card.getCard_no());
		pstmt.setString(2, card.getCard_validity()); 
		pstmt.setInt(3, card.getCard_cvc());
		pstmt.setInt(4, card.getCard_password());
	}

	public void deleteByNo(Card card) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CardSQL.Card_delete);
		pstmt.setString(1, card.getCard_no());
	}
}