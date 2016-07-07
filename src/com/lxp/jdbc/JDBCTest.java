package com.lxp.jdbc;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCTest {
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//创建连接
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insert(){
		Connection conn = getConnection();
		try {
			String sql = "insert into tbl_user(name, password, email)" + "values('Tom', '123456', 'tom@gmail.com')";
			Statement st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中插入了" + count + "条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(){
		Connection conn = getConnection();
		try {
			String sql = "update tbl_user set email='tom@126.com' where name='tom'";
			Statement st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中更新了" + count + "条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(){
		Connection conn = getConnection();
		try {
			String sql = "delete from tbl_user where name='Tom'";
			Statement st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中删除了" + count + "条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		insert();
		
//		update();
		
		delete();
		
		
		
		
		
		
//		String sql = "select * from tbl_user";
//		Connection conn = null;
//		Statement st = null;
//		ResultSet rs = null;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "");
//			st = (Statement) conn.createStatement();
//			rs = st.executeQuery(sql);
//			
//			while(rs.next()){
//				System.out.print(rs.getInt("id") + "  ");
//				System.out.print(rs.getString("name") + "  ");
//				System.out.print(rs.getString("password") + "  ");
//				System.out.print(rs.getString("email") + "  ");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//			} catch (Exception e2) {
//			}
//			try {
//				st.close();
//			} catch (Exception e3) {
//			}
//			try {
//				conn.close();
//			} catch (Exception e4) {
//			}
//		}
	}
}
