package com.jm2002.learn.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbObjectFactory {

	static Connection con = null;
	static Statement stmt = null;

	public static Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		}
		return con;
	}

	public static Statement getStatement(Connection con) throws SQLException {

		if (stmt == null || stmt.isClosed()) {
			stmt = con.createStatement();
		}
		return stmt;
	}
}
