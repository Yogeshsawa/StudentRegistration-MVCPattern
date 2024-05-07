package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConDb 
{
	public static Connection myconnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
}
