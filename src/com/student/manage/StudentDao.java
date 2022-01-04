package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;



public class StudentDao {
	public static boolean insertStudentToDB(Student st)
	{
		//JDBC CODE
		boolean f=false;
		try {
			Connection con= CP.createC();
			String q="insert into Students(sname, sphone, scity) values(?,?,?)"; //Dynamic Query
			//PreparedStatement is used for Dynamic query
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the values in query
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate(); //As Query is not fetching Data
			f=true;
		
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	return f;	
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		//JDBC CODE
				boolean f=false;
				try {
					Connection con= CP.createC();
					String q="delete from Students where sid=?"; //Dynamic Query
					//PreparedStatement is used for Dynamic query
					PreparedStatement pstmt=con.prepareStatement(q);
					//set the values in query
					pstmt.setInt(1, userId);
				
					
					//execute
					pstmt.executeUpdate(); //As Query is not fetching Data
					f=true;
				
					
					
				}catch(Exception e){
					e.printStackTrace();
					
				}
			return f;	
		
		
	}

	public static void showAll() {
		// TODO Auto-generated method stub
		
		try {
			Connection con= CP.createC();
			String q="Select * from Students"; //Static Query
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q); //As query is fetching data
			
			//Printing Data
			while(set.next())
			{
				
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				System.out.println("-----------------------------");



				
			}
		
	
		}catch(Exception e){
			e.printStackTrace();
			
		}


		
		
	}

}
