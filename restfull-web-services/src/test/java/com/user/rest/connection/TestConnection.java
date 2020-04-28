package com.user.rest.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class TestConnection {

	static final Logger logger = LogManager
			.getLogger(TestConnection.class);
	
	@Test
	@Ignore
	public void testConnect() throws ClassNotFoundException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// BOGNTB017256\SQLEXPRESS01
			String connectionUrl = "jdbc:sqlserver://BOGNTB017256\\SQLEXPRESS1:1433;" + "databaseName=espejo_ccf04;"
					+ "user=sa;" + "password=holamundo";
			Connection con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected.");
			String SQL = "SELECT TOP 3* FROM trabajadores";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	@Test
	public void string() {
		String[] cadena = {"Dennis", "Grace", "Bjarne", "James"};
		System.out.println("With For each:");
		for (String ca : cadena) {
			logger.info(ca);
		}
		System.out.println("With clasic for:");
		for (int i = 0; i < cadena.length; i++) {
			logger.info(cadena[i]);
		}
	}

}
