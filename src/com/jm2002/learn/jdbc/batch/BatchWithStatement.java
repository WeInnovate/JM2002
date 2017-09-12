package com.jm2002.learn.jdbc.batch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jm2002.learn.jdbc.util.DbObjectFactory;

public class BatchWithStatement {

	static Connection con;
	static Statement stmt;

	public static void main(String[] args) {
		try {
			con = DbObjectFactory.getConnection();
			stmt = con.createStatement();

			Scanner scan = new Scanner(System.in);
			String choice = null;

			do {
				System.out.print("Enter the user name: ");
				String un = scan.nextLine();

				System.out.print("Enter the user password: ");
				String p = scan.nextLine();

				// int i = stmt.executeUpdate("INSERT INTO AJ002_LOGIN
				// VALUES("+un+", "+p+")");
				stmt.addBatch("INSERT INTO AJ002_LOGIN VALUES('" + un + "', '" + p + "')");

				/*
				 * if(i > 0){
				 * System.out.println("Record has been inserted successfully.");
				 * }
				 */

				System.out.print("Do you wnat to continue(Y/N): ");
				choice = scan.nextLine();

			} while (choice.equalsIgnoreCase("y"));

			int[] arr = stmt.executeBatch();

			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
					stmt.close();
				} catch (SQLException e) {
					System.out.println("Exception came during closing the DB connnection.");
					e.printStackTrace();
				}
			}
		}
	}

}
