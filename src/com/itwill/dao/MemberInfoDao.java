package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.MemberInfo;

public class MemberInfoDao {
	public int create(MemberInfo memberInfo) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberInfoSQL.MEMBERINFO_INSERT);
		pstmt.setString(1, memberInfo.getMember_id());
		pstmt.setString(2, memberInfo.getMember_password());
		pstmt.setString(3, memberInfo.getMember_name());
		pstmt.setString(4, memberInfo.getMember_phone());
		pstmt.setString(5, memberInfo.getMember_address());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public MemberInfo selectById(String member_id) throws Exception {
		MemberInfo memberInfo = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberInfoSQL.MEMBERINFO_SELECT_BY_ID);
		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			memberInfo = new MemberInfo(rs.getString("member_no"), 
										rs.getString("member_id"), 
										rs.getString("member_password"),
										rs.getString("member_name"),
										rs.getString("member_phone"),
										rs.getString("member_address"),
										rs.getString("member_joinDate")
										);
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return memberInfo;
	}
	public MemberInfo selectByCardNo(String card_no) throws Exception {
		MemberInfo memberInfo = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberInfoSQL.MEMBERINFO_SELECT_BY_CARD_NO);
		pstmt.setString(1, card_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			memberInfo = new MemberInfo(rs.getString("member_no"), 
										rs.getString("member_id"), 
										rs.getString("member_password"),
										rs.getString("member_name"),
										rs.getString("member_phone"),
										rs.getString("member_address"),
										rs.getString("member_joinDate")
										);
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return memberInfo;
	}
	public List<MemberInfo> selectAll() throws Exception {
		ArrayList<MemberInfo> memberInfoList = new ArrayList<MemberInfo>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberInfoSQL.MEMBERINFO_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			memberInfoList.add(new MemberInfo(rs.getString("member_no"), 
											  rs.getString("member_id"), 
											  rs.getString("member_password"),
											  rs.getString("member_name"),
											  rs.getString("member_phone"),
											  rs.getString("member_address"),
											  rs.getString("member_joinDate")
											  ));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return memberInfoList;
	}
	public int updateById(MemberInfo memberInfo) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberInfoSQL.MEMBERINFO_UPDATE_BY_ID);
		pstmt.setString(1,memberInfo.getMember_password());
		pstmt.setString(2,memberInfo.getMember_name());
		pstmt.setString(3,memberInfo.getMember_phone());
		pstmt.setString(4,memberInfo.getMember_address());
		pstmt.setString(5,memberInfo.getMember_id());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteById(String member_id) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberInfoSQL.MEMBERINFO_DELETE_BY_ID);
		pstmt.setString(1, member_id);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
