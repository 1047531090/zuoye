package lianjieshujuku;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mainlianjie {
	private static Connection connection = null;
		static{
			try {
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiwu","root","XFC1047531090..");
				if (!connection.isClosed()) {
					System.out.println("�ɹ����ӵ����ݿ�");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	public Mainlianjie(){
		
	}
	
	public static Connection getC(){
		return connection;
	}
	
	public static void main(String[] args) {
		new Mainlianjie();
	}
}
