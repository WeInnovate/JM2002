package com.jm2002.learn.jdbc.dml;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jm2002.learn.jdbc.util.DbObjectFactory;

public class DataManipulationLanguage {

	static Scanner scan;
	static Statement stmt;

	public static void main(String[] args) {
		try {
			Connection con = DbObjectFactory.getConnection();
			stmt = DbObjectFactory.getStatement(con);

			scan = new Scanner(System.in);

			System.out.println("Please enter your choice:");
			System.out.println("1. Insert \n2. Update \n3. Delete \n0. Exit\n");

			String choice = scan.nextLine();

			switch (choice) {
			case "1":
				insertData();

				break;
			case "2":
				updateData();

				break;
			case "3":
				deleteData();

				break;
			case "0":
				System.exit(1);
				break;

			default:
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteData() {
		System.out.print("Enter the user name: ");
		String un = scan.nextLine();

		int i;
		
		try {
			i = stmt.executeUpdate("DELETE FROM AJ002_LOGIN WHERE USER_NAME = '"+un+"'");
			if (i != 0) {
				System.out.println("Record deleted successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateData() {

	}

	private static void insertData() {
		String insertChoice = "";
		do{
			System.out.print("Enter the user name: ");
			String un = scan.nextLine();

			System.out.print("Enter the user password: ");
			String p = scan.nextLine();

			int i = 0;
			
			try {
				i = stmt.executeUpdate("INSERT INTO AJ002_LOGIN VALUES('"+un+"', '"+p+"')");
				if (i != 0) {
					System.out.println("Record inserted successfully.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to countinue ? 1. Yes - Y \n2. No - N\n");
			insertChoice = scan.nextLine();
		}while(insertChoice.equalsIgnoreCase("Y"));
		main(null);
	}
}
