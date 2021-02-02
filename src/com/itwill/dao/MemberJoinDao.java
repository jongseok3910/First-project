package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.vo.MemberJoin;

public class MemberJoinDao {
	public void create(MemberJoin memberJoin) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberJoinSQL.MemberJoin_insert);
		pstmt.setString(1, memberJoin.getMember_id());
		pstmt.setString(2, memberJoin.getMember_password());
		pstmt.setString(3, memberJoin.getMember_name());
		pstmt.setString(4, memberJoin.getMember_phone());
		pstmt.setString(5, memberJoin.getMember_address());
		pstmt.setDate(6, memberJoin.getMember_joinDate());
		// Date 타입이 안먹혀요

		pstmt.close();
		ConnectionFactory.releaseConnection(con);
	
		
		
	}

}
