package llllll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	private static Connection con = null;
	public static Connection getInstace(){
		try {
			//驱动程序名
			String driver = "com.mysql.jdbc.Driver";
			//加载驱动程序
	    	Class.forName(driver);
	    	//1.声明Connection对象， getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
}
