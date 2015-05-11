package com.easylearnjava.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *This class interacts with the database and fetches the password and returns to LoginService class.
 */
public class LoginDao {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LoginDao ld = new LoginDao();
		ld.getUserDetails();
	}
	
	

	public void getUserDetails() throws ClassNotFoundException, SQLException {

		Connection con;
		Statement stmt;
		DBConnection dbConn = new DBConnection();
		String passwordFromDB = null;
		
			con = dbConn.giveMeABridge();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from USER");
			
			while(rs.next()){
				int id = rs.getInt("USER_ID");
				String un = rs.getString("USER_NAME");
				String pwd = rs.getString("user_password");
				
				System.out.println(id + " " + un + " " + pwd);
			}
		
	}
		

}
