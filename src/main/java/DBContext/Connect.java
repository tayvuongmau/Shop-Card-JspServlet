package DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	//kết nối data
	public static Connection openConnection() {
		Connection conn = null;
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//kết nối data
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3","root","thang1993");
			} catch (SQLException e ) {
				e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		    	e.printStackTrace();
			}
		return conn;	
	}
	
	//đóng kết nối
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//đóng statement
	public static void closeStatement(PreparedStatement statement) {
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//đóng ResultSet
	public static void closeResultSet(ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
