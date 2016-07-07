package com.lxp;

import java.sql.SQLException;

import com.lxp.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class ConnectionFactoryTest {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = (Connection) cf.makeConnection();
		System.out.println(conn.getAutoCommit());
	}

}
