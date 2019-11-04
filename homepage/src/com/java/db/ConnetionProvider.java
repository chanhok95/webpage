package com.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class ConnetionProvider {

	/*
	 * public static Connection getConnetion() {
	 * 
	 * 
	 * Connection conn=null;
	 * 
	 * 
	 * try { String url="jdbc:oracle:thin:@localhost:1521:xe"; String id="mvc";
	 * String pass="1234";
	 * 
	 * conn = DriverManager.getConnection(url,id,pass); } catch (SQLException e) {
	 * System.out.println("Connetion Error : "+ e); // e.printStackTrace(); } return
	 * conn; }
	 */
	public static Connection getConnetion() {
		
		Connection conn=null;
		
		try {
			Context initContext = new InitialContext();	//Server  컨텍스트 객체
			
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); //리소스(태그)를 가져온다. /리소스를 찾는 접두어
			
			DataSource ds = (DataSource)envContext.lookup("jdbc/mvcDB"); //리소스 안에 있는 java/mvcDB
			
			 conn = ds.getConnection();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Server  컨텍스트 객체
		
		//리소스(태그)를 가져온다.
		
		//리소스 안에 있는 java/mvcDB
		
		
		
		return conn;
	}

}
