package com.lxp.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lxp.dao.UserDao;
import com.lxp.dao.impl.UserDaoImpl;
import com.lxp.entity.User;
import com.lxp.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class CheckUserService {
	private UserDao userDao = new UserDaoImpl();
	
	public boolean check(User user){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			ResultSet resultSet = userDao.get(conn, user);
			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}
}
