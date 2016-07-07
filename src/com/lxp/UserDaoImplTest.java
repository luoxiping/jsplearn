package com.lxp;

import java.sql.SQLException;

import com.lxp.dao.UserDao;
import com.lxp.dao.impl.UserDaoImpl;
import com.lxp.entity.User;
import com.lxp.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class UserDaoImplTest {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setName("Tom");
			tom.setPassword("123456");
			tom.setEmail("tom@gmail.com");
			userDao.save(conn, tom);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
