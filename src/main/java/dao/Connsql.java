package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connsql {

	public static final String DRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/courset?characterEncoding=utf8";
	public static final String DBUSER = "root";
	public static final String DBPASS = "z82625541";
	private static Connection conn = null;
	private static PreparedStatement pStat = null;
	private static ResultSet rs = null;

	public static Connection getConnectionn() {
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			return null;
		}
	}

	public static void close() {
		try {
			if (rs != null)
				rs.close();
			if (pStat != null)
				pStat.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
