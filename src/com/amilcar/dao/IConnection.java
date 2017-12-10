package com.amilcar.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public interface IConnection {

	default public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/persona", "root", "");

			if(con != null) 
				System.out.println("Connection ok");
			else 
				System.out.println("Connection refused");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		return con;
	}
}