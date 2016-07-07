package com.lxp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.lxp.entity.User;
import com.mysql.jdbc.Connection;

public interface UserDao {
	public void save(Connection conn, User user) throws SQLException;

	public void update(Connection conn, Long id, User user) throws SQLException;
	
	public void delete(Connection conn, User user) throws SQLException;
	
	public ResultSet get(Connection conn, User user) throws SQLException;
}
