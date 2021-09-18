package com.DAO.TVB;

import java.sql.*;

public class Conexion {
	
	static String bd="tienda";
	static String login="roo";
	static String password="1310";
	static String url="jdbc:mysql://localhost:3308/"+bd;
	
	Connection connection=null;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,login,password);
			if(connection!=null) {
				System.out.println("Conexion de bd"+bd+"exitosa");
			}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void desconectar() {
		connection=null;
	}
	
}
