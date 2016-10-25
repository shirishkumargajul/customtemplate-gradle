package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MysqlJdbc {
	private static Properties prop;
	private static InputStream input;

	public static Connection getConnection() {
		try {
			//String filename = "config.properties";
    		//input = MysqlJdbc.class.getClassLoader().getResourceAsStream(filename);
			//input = new FileInputStream("config.properties");
			//prop = new Properties();
			//prop.load(input);
			Class.forName("com.mysql.jdbc.Driver");// prop.getProperty("DB_DRIVER_NAME"));
			// // load the jdbc driver catch (Exception e) 
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudproject2", "arjun", "arjun");
			//Connection connect = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("DB_USER_NAME"), prop.getProperty("DB_PASSWORD"));
			return connect;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConn(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occurs in closing the database!");
		}
	}
}
