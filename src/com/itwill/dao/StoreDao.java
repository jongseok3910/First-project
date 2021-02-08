package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	    int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public Store selectByStoreName(String store_name) throws Exception {
		Store store = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_SELECT_BY_STORE_NAME);
		pstmt.setString(1, store_name);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			store = new Store(rs.getInt("store_no"),
							  rs.getString("store_name"),
							  rs.getString("store_businesstime"),
							  rs.getString("store_phone"),
							  rs.getString("store_address"),
							  rs.getInt("store_deliveryprice"),
							  rs.getString("jumun_estimatedtime"),
							  rs.getDouble("store_rating")							  
							  );
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return store;
	}
	public Store selectByStoreNo(int store_no) throws Exception {
		Store store = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_SELECT_BY_STORE_NO);
		pstmt.setInt(1, store_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			store = new Store(rs.getInt("store_no"),
					rs.getString("store_name"),
					rs.getString("store_businesstime"),
					rs.getString("store_phone"),
					rs.getString("store_address"),
					rs.getInt("store_deliveryprice"),
					rs.getString("jumun_estimatedtime"),
					rs.getDouble("store_rating")							  
					);
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return store;
	}
	public List<Store> selectAll() throws Exception {
		ArrayList<Store> storeList = new ArrayList<Store>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			storeList.add(new Store(rs.getInt("store_no"),
					  rs.getString("store_name"),
					  rs.getString("store_businesstime"),
					  rs.getString("store_phone"),
					  rs.getString("store_address"),
					  rs.getInt("store_deliveryprice"),
					  rs.getString("jumun_estimatedtime"),
					  rs.getDouble("store_rating")
					  ));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return storeList;
	}
	public int updateByStoreNo(Store store) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_UPDATE_BY_NO);
		pstmt.setString(1,store.getStore_name());
		pstmt.setString(2,store.getStore_businessTime());
		pstmt.setString(3,store.getStore_phone());
		pstmt.setString(4,store.getStore_address());
		pstmt.setInt(5,store.getStore_deliveryPrice());
		pstmt.setString(6,store.getJumun_estimatedTime());
		pstmt.setDouble(7,store.getStore_rating());
		pstmt.setInt(8,store.getStore_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int updateByStoreName(Store store) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_UPDATE_BY_NAME);
		pstmt.setString(1,store.getStore_businessTime());
		pstmt.setString(2,store.getStore_phone());
		pstmt.setString(3,store.getStore_address());
		pstmt.setInt(4,store.getStore_deliveryPrice());
		pstmt.setString(5,store.getJumun_estimatedTime());
		pstmt.setDouble(6,store.getStore_rating());
		pstmt.setString(7,store.getStore_name());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByName(String store_name) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(StoreSQL.STORE_DELETE_BY_NAME);
		pstmt.setString(1, store_name);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
