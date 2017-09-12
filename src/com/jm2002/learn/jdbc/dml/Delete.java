package com.jm2002.learn.jdbc.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("DELETE FROM AJ002_LOGIN WHERE USER_NAME = 'TestUser1'");
			
			if(i != 0){
				System.out.println("Record deleted successfully.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
