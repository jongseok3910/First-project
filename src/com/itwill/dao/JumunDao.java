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
	pstmt.setString(4,jumun.getJumun_request());
	pstmt.setString(5,jumun.getJumun_paymentType());
	pstmt.setString(6,jumun.getJumun_paymentTime());
	pstmt.setString(7,jumun.getMember_no());
	pstmt.setInt(8,jumun.getFood_no());
	pstmt.setInt(9,jumun.getStore_no());
	int rowCount=pstmt.executeUpdate();
	pstmt.close();
	ConnectionFactory.releaseConnection(con);
	return rowCount;
	}
	public List<Jumun> selectByMemberNo(String member_no) throws Exception {
		ArrayList<Jumun> jumunList=new ArrayList<Jumun>();
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(JumunSQL.JUMUN_SELECT_BY_MEMBER_NO);
		pstmt.setString(1, member_no);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			jumunList.add(new Jumun(rs.getInt("jumun_no"),
									rs.getInt("jumun_quantity"),
									rs.getInt("jumun_sum"),
									rs.getString("jumun_request"),
									rs.getString("jumun_paymentType"),
									rs.getString("jumun_paymentTime"),
									rs.getString("member_no"),
									rs.getInt("food_no"),
									rs.getInt("store_no")
									));
		}
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return jumunList;
	}
	public Jumun selectByJumunNo(int jumun_no) throws Exception {
		Jumun jumun=new Jumun();
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(JumunSQL.JUMUN_SELECT_BY_JUMUN_NO);
		pstmt.setInt(1, jumun_no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			jumun=new Jumun(rs.getInt("jumun_no"),
					rs.getInt("jumun_quantity"),
					rs.getInt("jumun_sum"),
					rs.getString("jumun_request"),
					rs.getString("jumun_paymentType"),
					rs.getString("jumun_paymentTime"),
					rs.getString("member_no"),
					rs.getInt("food_no"),
					rs.getInt("store_no")
					);
		}
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
			jumunList.add(new Jumun(rs.getInt("jumun_no"),
									rs.getInt("jumun_quantity"),
									rs.getInt("jumun_sum"),
									rs.getString("jumun_request"),
									rs.getString("jumun_paymentType"),
									rs.getString("jumun_paymentTime"),
									rs.getString("member_no"),
									rs.getInt("food_no"),
									rs.getInt("store_no")
								    ));
		}
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return jumunList;
	}
	public int updateByNo(Jumun jumun) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(JumunSQL.JUMUN_UPDATE_BY_JUMUN_NO);
		pstmt.setInt(1,jumun.getJumun_quantity());
		pstmt.setInt(2,jumun.getJumun_sum());
		pstmt.setString(3,jumun.getJumun_request());
		pstmt.setString(4,jumun.getJumun_paymentType());
		pstmt.setString(5,jumun.getJumun_paymentTime());
		pstmt.setString(6,jumun.getMember_no());
		pstmt.setInt(7,jumun.getFood_no());
		pstmt.setInt(8,jumun.getStore_no());
		pstmt.setInt(9,jumun.getJumun_no());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByNo(int jumun_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(JumunSQL.JUMUN_DELETE_BY_JUMUN_NO);
		pstmt.setInt(1,jumun_no);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
