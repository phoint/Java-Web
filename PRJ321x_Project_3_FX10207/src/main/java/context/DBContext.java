package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	/* USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE OR MULTIPLE SQL INSTANCE(s)*/
	/* DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION */
	public Connection OpenConnection() throws Exception {
		String dbUrl = "jdbc:sqlserver://" + serverName + ":" + portNum + "\\" + instance + 
				";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty()) {
			dbUrl = "jdbc:sqlserver://" + serverName + ":" + portNum + ";databaseName=" + dbName;
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(dbUrl, userID, password);
	}
	
	/* Change/ Update information of your database connection, 
	 * DO NOT change the name of instance variable in this class */
	private final String serverName = "localhost";
	private final String dbName = "ShoppingDB";
	private final String portNum = "1433";
	private final String instance ="";
	private final String userID = "sa";
	private final String password = "sa";

}
