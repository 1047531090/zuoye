package jiqiren;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;

public class Robot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "http://www.baidu.com";
		try{
			//����URL����
			URL url1= new URL(url);
			
			URLConnection urlConnection = url1.open();
			urlConnection.connect();
			if(urlConnection)
			//��ȡ��������
			BufferedReader BufferedReader = new BufferedReader();
			StringBuffer stringBuffer = new StringBuffer();
			
					
		}catch(){
			e.p
		}
		
	}

}
