package kehuyufuwu;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.omg.CORBA.PUBLIC_MEMBER;

//客户端
public class FasongduanDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			socket = new Socket("192.168.199.144", 9999);
			System.out.println("是否连接成功" + socket.isConnected());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		File file = new File("Text.txt");
		// 输入
		try {
			InputStream in = new FileInputStream(file);
			byte[] b = new byte[1024];
			int len = 0;
			int temp = 0;
			StringBuffer sb = new StringBuffer();
			while ((temp = in.read(b)) != -1) {
				b[len] = (byte) temp;
				len++;
			}
			in.close();

			// 输出
			OutputStream out = socket.getOutputStream();
			out.write(b);
			out.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}