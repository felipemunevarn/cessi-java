package turismoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection con;
	private static String url = "jdbc:sqlite:turismo.db";
	
	public static Connection getConnection() throws SQLException {
		if(con == null) {
			con = DriverManager.getConnection(url);
		}
		return con;
	}
	
	public static void close() throws SQLException {
		con.close();
	}
}
