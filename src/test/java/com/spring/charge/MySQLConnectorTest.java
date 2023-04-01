package com.spring.charge;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectorTest {
	
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String URL
	= "jdbc:mysql://127.0.0.1:3306/basicboard?serverTimezone=UTC&characterEncoding=UTF-8&useSSL=false";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "Kjm0408^^";
	
	@Test
	public void testConnect() throws Exception{
		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
			
			System.out.println(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
