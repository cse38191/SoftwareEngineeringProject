package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DoLogin {
	DbConnection db = new DbConnection();
	
	public boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException {
		
        /*
         *  Connect sthn DB kai elegxos an yparxei user me to sigkekrimeno username kai password
         */
		
		Connection con = db.doConnect();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		pst = con.prepareStatement("Select * from users where username = ? and password = ?");
		pst.setString(1, username);
		pst.setString(2, password);
		rs = pst.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		 return false;
        }
        
    }
