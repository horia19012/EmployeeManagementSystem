package database;


import java.sql.*;

public class DBConnection {
	Connection con;
	Statement statement;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///employeemanagement","root","YES");
			statement=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Statement getStatement() {
		return this.statement;
	}
	public Connection getConnection() {
		return this.con;
	}
}
