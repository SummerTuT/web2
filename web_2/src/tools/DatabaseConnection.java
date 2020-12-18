package tools;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	private static final String JDBCPROPERTY = "jdbc.property";
	private static String DBDRIVER = "";
	private static String DBURL = "";
	private static String DBUSER = "";
	private static String PASSWORD = ""; 
	private Connection con;
	
	
	static {
		try {
			Properties property = new Properties();

			InputStream is = DatabaseConnection.class.getClassLoader()
								.getResourceAsStream("resource/"+JDBCPROPERTY);
			property.load(new InputStreamReader(is, "utf-8"));
			is.close();
			DBDRIVER = property.getProperty("DBDRIVER");
			DBURL = property.getProperty("DBURL");
			DBUSER = property.getProperty("DBUSER");
			PASSWORD = property.getProperty("PASSWORD");
			// 加载驱动，只需注册一次就行
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//构造方法，实例化对象时创建连接对象
	public DatabaseConnection() {
		try {
			
			this.con = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//直接返回实例化对象时创建的连接对象
	public Connection getConnection() {
		return this.con;
	}
	//关闭连接对象
	public void close() {
		if (this.con != null) {
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
