package com.jm2002.learn.jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import com.jm2002.learn.jdbc.util.DbObjectFactory;

public class BatchWithPreparedStatement {

	public static void main(String[] args) {
		try (Connection con = DbObjectFactory.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO AJ002_LOGIN VALUES(?, ?)")) {

			Scanner scan = new Scanner(System.in);
			String choice = null;

			do {
				System.out.print("Enter the user name: ");
				String un = scan.nextLine();

				System.out.print("Enter the user password: ");
				String p = scan.nextLine();

				pstmt.setString(1, un);
				pstmt.setString(2, p);

				pstmt.addBatch();

				System.out.print("Do you wnat to continue(Y/N): ");
				choice = scan.nextLine();

			} while (choice.equalsIgnoreCase("y"));

			int[] arr = pstmt.executeBatch();

			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
