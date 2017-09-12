package com.jm2002.learn.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.jm2002.learn.jdbc.util.DbObjectFactory;

public class DatabseMetaData {

	public static void main(String[] args) {
		try(Connection con = DbObjectFactory.getConnection();){
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			
			System.out.println(dbmd.getDatabaseMinorVersion());
			System.out.println(dbmd.getDatabaseMajorVersion());
			
			System.out.println(dbmd.getURL());
			System.out.println(dbmd.getUserName());
			
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			System.out.println(dbmd.getDriverMinorVersion());
			System.out.println(dbmd.getDriverMajorVersion());
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}

}
