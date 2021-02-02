package com.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.vo.Food;

public class FoodDao {
	public int create(Food food) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_INSERT);
		pstmt.setInt(1,food.getFood_no());
		pstmt.setString(2,food.getFood_name());
		pstmt.setInt(3,food.getFood_price());
		pstmt.setInt(4,food.getCategory_no());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public Food selectByNo(int food_no) throws Exception {
		Food food=null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_SELECT_BY_NO);
		pstmt.setInt(1, food_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			food= new Food(rs.getInt("food_no"), 
					       rs.getString("food_name"),
					       rs.getInt("food_price"), 
					       rs.getInt("category_no"));
		}
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return food;
	}
	public Food selectByName(String food_name) throws Exception {
		Food food=null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_SELECT_BY_NAME);
		pstmt.setString(1, food_name);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			food= new Food(rs.getInt("food_no"), 
					       rs.getString("food_name"),
					       rs.getInt("food_price"), 
					       rs.getInt("category_no"));
		}
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return food;
	}
	public List<Food> selectByPrice(int low_price,int high_price) throws Exception {
		ArrayList<Food> foodList = new ArrayList<Food>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_SELECT_BY_PRICE);
		pstmt.setInt(1, low_price);
		pstmt.setInt(2, high_price);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			foodList.add(new Food(rs.getInt("food_no"),
								  rs.getString("food_name"),
								  rs.getInt("food_price"),
								  rs.getInt("category_no")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return foodList;
	}
	public List<Food> selectByCategoryNo(int category_no) throws Exception {
		ArrayList<Food> foodList = new ArrayList<Food>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_SELECT_BY_CATEGORY_NO);
		pstmt.setInt(1, category_no);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			foodList.add(new Food(rs.getInt("food_no"),
								  rs.getString("food_name"),
								  rs.getInt("food_price"),
								  rs.getInt("category_no")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return foodList;
	}
	public List<Food> selectAll() throws Exception {
		ArrayList<Food> foodList = new ArrayList<Food>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			foodList.add(new Food(rs.getInt("food_no"),
								  rs.getString("food_name"),
								  rs.getInt("food_price"),
								  rs.getInt("category_no")));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return foodList;
	}
	public int updateByNo(Food food) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_UPDATE_BY_NO);
		pstmt.setString(1, food.getFood_name());
		pstmt.setInt(2, food.getFood_price());
		pstmt.setInt(3, food.getCategory_no());
		pstmt.setInt(4, food.getFood_no());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int updateByName(Food food) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_UPDATE_BY_NAME);
		pstmt.setInt(1, food.getFood_no());
		pstmt.setInt(2, food.getFood_price());
		pstmt.setInt(3, food.getCategory_no());
		pstmt.setString(4, food.getFood_name());
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByNo(int food_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_DELETE_BY_NO);
		pstmt.setInt(1, food_no);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByName(String food_name) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_DELETE_BY_NAME);
		pstmt.setString(1, food_name);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
	public int deleteByCategoryNo(int category_no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FoodSQL.FOOD_DELETE_BY_CATEGORY_NO);
		pstmt.setInt(1, category_no);
		int rowCount=pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return rowCount;
	}
}
