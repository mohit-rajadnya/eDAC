package utils;
import java.sql.*;

public interface DBUtils {
	
	static Connection fetchConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/acts?useSSL=false";
		
		return DriverManager.getConnection(url, "root" , "picaros");
		
	}

}
