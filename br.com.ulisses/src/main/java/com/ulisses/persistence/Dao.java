package com.ulisses.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	Connection con;
	ResultSet rs = null;
	PreparedStatement stmt = null;

	public void open() {

		String url = "jdbc:mysql://ww1z3ews50vo6nc4:d0hri643wvtoaslx@mna97msstjnkkp7h.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/xysd9gy2psc27cs9";
		String user = "ww1z3ews50vo6nc4";
		String password = "d0hri643wvtoaslx";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
