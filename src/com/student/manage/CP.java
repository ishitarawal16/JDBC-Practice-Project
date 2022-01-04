package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection con;
	
	public static Connection createC()
	{
		try{
			//load driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Create Connection
	    String user="root";
		String password="1234";
		String url="jdbc:mysql://localhost:3306/student_manage"; //for mysql db
		con=DriverManager.getConnection(url, user, password);
		
		
		
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
		}

}
