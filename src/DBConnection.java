

import java.sql.*;

public class DBConnection {
	Connection con;
	java.sql.Statement statement;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jbdc.Driver");
			con=DriverManager.getConnection("jbdc:mysql:///employeemanagement","root","codeforinterview");
			statement=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
