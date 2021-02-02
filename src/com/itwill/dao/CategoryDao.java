package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.Category;

public class CategoryDao {
	public int create(Category category) throws Exception {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_INSERT);
		pstmt.setInt(1, category.getCategory_no());
		pstmt.setString(2, category.getCategory_name());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public Category selectByNo(int category_no) throws Exception {
		Category category = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_SELECT_BY_NO);
		pstmt.setInt(1, category_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			category = new Category(rs.getInt("category_no"),
								    rs.getString("category_name"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return category;
	}
	public Category selectByName(String category_name) throws Exception {
		Category category = null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_SELECT_BY_NAME);
		pstmt.setString(1, category_name);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			category = new Category(rs.getInt("category_no"),
								    rs.getString("category_name"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return category;
	}
	public List<Category> selectAll() throws Exception {
		ArrayList<Category> categoryList = new ArrayList<Category>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			categoryList.add(new Category(rs.getInt("category_no"),
										  rs.getString("category_name")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return categoryList;
	}
	public int updateByNo(Category category) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_UPDATE_BY_NO);
		pstmt.setString(1, category.getCategory_name());
		pstmt.setInt(2, category.getCategory_no());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int updateByName(Category category) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_UPDATE_BY_NAME);
		pstmt.setInt(1, category.getCategory_no());
		pstmt.setString(2, category.getCategory_name());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByNo(int category_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_DELETE_BY_NO);
		pstmt.setInt(1, category_no);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByName(String category_name) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CategorySQL.CATEGORY_DELETE_BY_NAME);
		pstmt.setString(1, category_name);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
