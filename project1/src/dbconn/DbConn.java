package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	//DB와의 연결을 위한 Connection형의 참조변수를 선언해주는 class이다.
	private Connection con;
	
	public Connection getConnection() {
		return con;
	}

	public DbConn() throws ClassNotFoundException,
									SQLException {
		/*
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:"
				+ "1521:xe","c##project1","project1");
		*/
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:"
				+ "1521:xe","hr","hr");
	} 

}
