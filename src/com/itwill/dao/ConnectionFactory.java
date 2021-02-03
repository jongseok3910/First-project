package com.itwill.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Connection객체 생성,해체를 담당하는 객체
 */
public class ConnectionFactory {
	private static String driverClass="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@182.237.126.19:1521:xe";
	private static String user="javabackend85";
	private static String password="javabackend85";
	private ConnectionFactory() {
		
	}
	public static Connection getConnection() throws Exception {
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	public static Connection getConnection(String driverClass,String url,String user,String password) throws Exception {
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		return con;
	}
	public static void releaseConnection(Connection con) throws Exception {
		con.close();
	}
}
