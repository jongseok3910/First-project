package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itwill.vo.Store;

public class StoreDao {
	public int create(Store store) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(StoreSQL.STORE_INSERT);
	    pstmt.setInt(1,store.getStore_no());
	    pstmt.setString(2, store.getStore_name());
	    pstmt.setString(3, store.getStore_businessTime());
	    pstmt.setString(4, store.getStore_phone());
	    pstmt.setString(5, store.getStore_address());
	    pstmt.setInt(6, store.getStore_deliveryPrice());
	    pstmt.setString(7,store.getJumun_estimatedTime());
	    pstmt.setDouble(8, store.getStore_rating());
	    pstmt.setInt(9, store.getCategory_no());
	    pstmt.setInt(10, store.getJumun_no());
	    int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public void selectByName() throws Exception {}
	public void selectByCategoryNo() throws Exception {}
	public void selectAll() throws Exception {}
	public int updateByName(Store store) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_UPDATE_BY_NAME);
		pstmt.setString(1,store.getStore_businessTime());
		pstmt.setString(2,store.getStore_phone());
		pstmt.setString(3,store.getStore_address());
		pstmt.setInt(4,store.getStore_deliveryPrice());
		pstmt.setString(5,store.getJumun_estimatedTime());
		pstmt.setDouble(6,store.getStore_rating());
		pstmt.setInt(7,store.getCategory_no());
		pstmt.setInt(8,store.getJumun_no());
		pstmt.setString(9,store.getStore_name());
		return 0;
	}
	public int deleteByName(String store_name) throws Exception {
		return 0;
	}
}
