package lainxi_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fuwuduan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���Ͷˣ��ͻ��ˣ�
		//���նˣ�����ˣ�
		try{
			//��������˲���ͨע��˿�
			ServerSocket serversocket = new ServerSocket(8989);
			System.out.println("�����������ɹ�");
			//������Ӧ�˿�
			Socket sockect = serversocket.accept();
			System.out.println("���ڼ����˿�");
			InputStream inputStream = sockect.getInputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			StringBuffer stringBuffer = new StringBuffer();
			while((len = inputStream.read(bytes)) != -1){
				stringBuffer.append(new String(bytes,0,len));
			}
			System.out.println("�������ˣ����Ǹ�ʲô��");
			System.out.println("�ͻ��ˣ�"+stringBuffer.toString());
			
			inputStream.close();
			
			String address1 = new String(sockect.getInetAddress().getHostName());
			System.out.println("���������ʵ�ַ�ǣ�"+address1);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
