package ganeshproject;
import java.sql.*;

public class Dbconnect {

	
		private static final  String   url="jdbc:mysql://localhost:3306/cinema";
		 private static final String  user="root";
		 private static final String  password="Ganesh@123";
		  public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
		
		}
	

}
