package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public Connection doConnect() throws ClassNotFoundException, SQLException{
		Connection con = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softeng", "root", "root");
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
