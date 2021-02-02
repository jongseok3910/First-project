package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.Jumun;

public class JumunDao {
	public int create(Jumun jumun) throws Exception {
	Connection con=ConnectionFactory.getConnection();
	PreparedStatement pstmt=con.prepareStatement(JumunSQL.JUMUN_INSERT);
	pstmt.setInt(1,jumun.getJumun_no());
	pstmt.setInt(2,jumun.getJumun_quantity());
	pstmt.setInt(3,jumun.getJumun_sum());
	pstmt.setString(4,jumun.getJumun_payment());
	pstmt.setString(5,jumun.getJumun_request());
	pstmt.setString(6,jumun.getJumun_estimatedTime());
	pstmt.setString(7,jumun.getCard_no());
	pstmt.setInt(8,jumun.getMember_no());
	pstmt.setInt(9,jumun.getFood_no());
	int rowCount=pstmt.executeUpdate();
	pstmt.close();
	ConnectionFactory.releaseConnection(con);
	return rowCount;
	}
	public Jumun selectByNo(int member_no) throws Exception {
		Jumun jumun=null;
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(JumunSQL.JUMUN_SELECT_MEMBER_NO);
	pstmt.setInt(1, member_no);
	ResultSet rs=pstmt.executeQuery();
	if (rs.next()) {
		int jumun_no=rs.getInt("jumun_no");
		int jumun_quantity=rs.getInt("jumun_quantity");
		int jumun_sum=rs.getInt("jumun_sum");
		String jumun_payment=rs.getString("jumun_payment");
		String jumun_request=rs.getString("jumun_request");
		String jumun_estimatedTime=rs.getString("jumun_estimatedTime");
		String card_no=rs.getString("card_no");
		int food_no=rs.getInt("food_no");
	}
	rs.close();
	pstmt.close();
	ConnectionFactory.releaseConnection(con);
    return jumun;
	}
	public List<Jumun> selectAll() throws Exception {
		ArrayList<Jumun> jumunList=new ArrayList<Jumun>();
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(JumunSQL.JUMUN_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int jumun_no=rs.getInt("jumun_no");
			int jumun_quantity=rs.getInt("jumun_quantity");
			int jumun_sum=rs.getInt("jumun_sum");
			String jumun_payment=rs.getString("jumun_payment");
			String jumun_request=rs.getString("jumun_request");
			String jumun_estimatedTime=rs.getString("jumun_estimatedTime");
			String card_no=rs.getString("card_no");
			int member_no=rs.getInt("member_no");
			int food_no=rs.getInt("food_no");
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return jumunList;
	}
	public int updateByNo(Jumun jumun) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(JumunSQL.JUMUN_UPDATE);
		pstmt.setInt(1,jumun.getJumun_quantity());
		pstmt.setInt(2,jumun.getJumun_sum());
		pstmt.setString(3,jumun.getJumun_payment());
		pstmt.setString(4,jumun.getJumun_request());
		pstmt.setString(5,jumun.getCard_no());
		pstmt.setInt(6,jumun.getFood_no());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByNo(int member_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(JumunSQL.JUMUN_DELETE);
		pstmt.setInt(1,member_no);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
