package com.lxp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lxp.dao.UserDao;
import com.lxp.entity.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareCall("insert into tbl_user(name, password, email) values(?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		
	}

	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		
	}

	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareCall("select * from tbl_user where name = ? and password = ?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		return ps.executeQuery();
	}

}
