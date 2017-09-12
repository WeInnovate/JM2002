package com.jm2002.learn.jdbc.dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPSTMT {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			// performance issue with stmt
			// Statement stmt = con.createStatement();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO AJ002_LOGIN VALUES(?, ?)");
			Scanner scan = new Scanner(System.in);
			String choice = null;
			do {
				System.out.print("Enter the user name: ");
				String un = scan.nextLine();

				System.out.print("Enter the user password: ");
				String p = scan.nextLine();

				pstmt.setString(1, un);
				// INSERT INTO AJ002_LOGIN VALUES('Any001', ?)
				pstmt.setString(2, p);
				// INSERT INTO AJ002_LOGIN VALUES('Any001', '1234')
				int i = pstmt.executeUpdate();

				if (i != 0) {
					System.out.println("Record inserted successfully.");
				}
				System.out.println("Do you want to countinue ? 1. Yes - Y \n2. No - N\n");
				choice = scan.nextLine();
			} while (choice.equalsIgnoreCase("y"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
