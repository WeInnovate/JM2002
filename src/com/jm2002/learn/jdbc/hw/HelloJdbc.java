package com.jm2002.learn.jdbc.hw;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc {
	public static void main(String[] args) {
		try {
//			Class.forName("org.h2.Driver");
//			make connection
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			//execute the command/statement/instruction
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM AJ002_LOGIN");
			//retrieve the result and process it
			System.out.println("User Name Password");
			System.out.println("__________________");
			while(rs.next()){
				String name = rs.getString(1);
				String pass = rs.getString(2);
				
				System.out.println(name+" "+pass);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
