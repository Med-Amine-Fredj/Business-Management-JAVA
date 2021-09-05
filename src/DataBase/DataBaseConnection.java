package DataBase;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class DataBaseConnection {
	public static  Connection connection;
	
	 public static void connecter() throws ClassNotFoundException, SQLException
	 {      
		  	Class.forName("com.mysql.jdbc.Driver");  
		  	connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-commerciales","root","");
	 }
	 
}
