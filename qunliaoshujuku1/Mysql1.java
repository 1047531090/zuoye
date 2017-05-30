package qunliaoshujuku1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql1 {
	private	static Connection connection = null;
	
	static{
		try{
			//¿ªÆôÊÂÎñ
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xfc","root","123456");
			if(!connection.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
			}
		}catch(Exception ee){
			ee.printStackTrace();
		}
		
	}
	private Mysql1(){
		
	}
	public static Connection getC(){
		
		return connection;
	}
}
