package com.db.helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String uname = "ganesh";
	private static String pwd = "ganesh";

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,uname,pwd);

		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// end of static block

	//method to return DB con
	public static Connection getCon() {
		return con;
	}

}
