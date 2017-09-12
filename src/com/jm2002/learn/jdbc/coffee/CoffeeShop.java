package com.jm2002.learn.jdbc.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jm2002.learn.jdbc.util.DbObjectFactory;

public class CoffeeShop {

	/**
	 * CREATE TABLE JM2002_COFFEE_SUMMARY(COFFEE_NAME VARCHAR, PRICE DECIMAL,
	 * QUANTITY NUMBER, TOTAL_EARNING DECIMAL);
	 * 
	 * CREATE TABLE JM2002_COFFEE_ORDER(COFFEE_NAME VARCHAR, DATE TIMESTAMP,
	 * PRICE DECIMAL);
	 * 
	 * INSERT INTO JM2002_COFFEE_SUMMARY VALUES('Capuchino', 100.0, 10, 0.0);
	 * 
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String choice = "";

		List<Coffee> coffeeList = new ArrayList<Coffee>();

		try (Connection con = DbObjectFactory.getConnection();
				Statement stmt = DbObjectFactory.getStatement(con);
				PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO JM2002_COFFEE_ORDER VALUES(?,?,?)");
				PreparedStatement pstmt2 = con.prepareStatement("UPDATE JM2002_COFFEE_SUMMARY SET QUANTITY=QUANTITY - ?, TOTAL_EARNING=TOTAL_EARNING + ? WHERE COFFEE_NAME=?")) {

			con.setAutoCommit(false);
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM JM2002_COFFEE_SUMMARY");

			while (rs.next()) {
				String coffeeName = rs.getString(1);
				double coffeePrice = rs.getDouble(2);
				int coffeeQuantity = rs.getInt(3);

				Coffee coffee = new Coffee(coffeeName, coffeePrice, coffeeQuantity);
				coffeeList.add(coffee);
			}

			System.out.println(coffeeList);

			do {
				System.out.println("Please select your coffee:");

				for (int i = 0; i < coffeeList.size(); i++) {
					System.out.println((i + 1) + ". " + coffeeList.get(i).getCoffeeName());
				}
				System.out.println("0. Exit");
				System.out.print("Your choice please: ");
				choice = scan.nextLine();

				if (choice.equals("1")) {
					pstmt1.setString(1, coffeeList.get(0).getCoffeeName());
					pstmt1.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
					pstmt1.setDouble(3, coffeeList.get(0).getPrice());
					
					pstmt2.setInt(1, 1);
					pstmt2.setDouble(2, coffeeList.get(0).getPrice());
					pstmt2.setString(3, coffeeList.get(0).getCoffeeName());
				} else if (choice.equals("2")) {
					pstmt1.setString(1, coffeeList.get(1).getCoffeeName());
					pstmt1.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
					pstmt1.setDouble(3, coffeeList.get(1).getPrice());
					
					pstmt2.setInt(1, 1);
					pstmt2.setDouble(2, coffeeList.get(1).getPrice());
					pstmt2.setString(3, coffeeList.get(1).getCoffeeName());
				} else if (choice.equals("3")) {
					pstmt1.setString(1, coffeeList.get(2).getCoffeeName());
					pstmt1.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
					pstmt1.setDouble(3, coffeeList.get(2).getPrice());
					
					pstmt2.setInt(1, 1);
					pstmt2.setDouble(2, coffeeList.get(2).getPrice());
					pstmt2.setString(3, coffeeList.get(2).getCoffeeName());
				} else if (choice.equals("0")) {
					System.exit(1);
				}
				
				int insertedRecords = pstmt1.executeUpdate();
				
//				int annke = 10/0;
				
				int updatedRecords = pstmt2.executeUpdate();
				
				

				if (insertedRecords > 0) {
					System.out.println("Your coffee is ready.");
				}	
				
				if (updatedRecords > 0) {
					System.out.println("Summary table updated.");
				}
				
				if(insertedRecords > 0 && updatedRecords > 0){
					System.out.println("Commiting the transactions");
					con.commit();
				}

				System.out.print("Do you want to continue? (y/n): ");
				choice = scan.nextLine();
			} while (choice.equalsIgnoreCase("Y"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
