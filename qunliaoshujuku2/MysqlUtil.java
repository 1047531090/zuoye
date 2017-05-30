package qunliaoshujuku2;

import java.sql.Connection;
import java.sql.DriverManager;
//数据库
public class MysqlUtil {
	//保证整个应用程序只有一个连接
	private static Connection connection = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xfc","root","123");
			if(!connection.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private MysqlUtil(){
		
	}
	public static Connection getInstance(){	
		return connection;
	}
}
