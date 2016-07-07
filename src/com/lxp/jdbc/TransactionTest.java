package com.lxp.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TransactionTest {
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
	
	public static void insertUserData(Connection conn) throws SQLException{
			String sql = "insert into tbl_user(id, name, password, email)" + "values(10, 'Tom', '123456', 'tom@gmail.com')";
			Statement st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向用户表中插入了" + count + "条记录");
	}
	
	public static void insertAddress(Connection conn) throws SQLException{
			String sql = "insert into tbl_address(id, city, country, user_id)" + "values(1, 'shanghai', 'china', 10)";
			Statement st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向地址表中插入了" + count + "条记录");
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			insertUserData(conn);
			insertAddress(conn);
		} catch (SQLException e) {
			System.out.println("=================" + "捕获到SQL异常" + "===================");
			e.printStackTrace();
			try {
				conn.rollback();
				System.out.println("===============事物回滚成功======================");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
}
