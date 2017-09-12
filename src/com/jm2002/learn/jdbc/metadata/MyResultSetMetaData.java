package com.jm2002.learn.jdbc.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.jm2002.learn.jdbc.util.DbObjectFactory;

public class MyResultSetMetaData {

	public static void main(String[] args) {
		try (Connection con = DbObjectFactory.getConnection(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM AJ002_LOGIN");

			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Table Name: " + rsmd.getTableName(1));
			System.out.println("Column Count: " + rsmd.getColumnCount());
			
			System.out.println(rsmd.getColumnName(1) + "(" + rsmd.getColumnTypeName(1) + ") " + rsmd.getColumnName(2)
			+ "(" + rsmd.getColumnTypeName(2) + ")");
			while (rs.next()) {
				System.out.println(rs.getString(1)+"			"+rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
