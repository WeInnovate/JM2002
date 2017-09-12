package com.jm2002.learn.jdbc.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("UPDATE AJ002_LOGIN SET PASSWORD = 'TU1' WHERE USER_NAME = 'TestUser1'");

			if (i != 0) {
				System.out.println("Record is updated successfully.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
