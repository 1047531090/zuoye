package lianxi;
import java.io.*;
import java.util.*;

public class Shurubufugai {
	public static void main(String[] args){
		//�û���������д��һ���ļ���
		Scanner scanner = new Scanner(System.in);
		File file = new File("test.txt");
		if(!file.exists()){
			try{
				file.createNewFile();
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		String userInput = "";
		System.out.println("�������ļ����ݣ�");
		userInput = scanner.nextLine();
		
		
		//�ȶ�ȡԭ���ļ�������
		StringBuffer stringBuffer = new StringBuffer();
		int len;
		byte[] bytes = new byte[1024];
		FileInputStream fileInputStream = null;
		try{
			fileInputStream = new FileInputStream(file);
			while((len = fileInputStream.read(bytes)) != -1){
				stringBuffer.append(new String(bytes,0,len));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fileInputStream != null){
				try{
					fileInputStream.close();
				}catch(IOException e){
					e.printStackTrace();
				}
				
			}
		}
		
		//ԭ���ļ�������
				String oldcontext = stringBuffer.toString();
				String writercontext = "";
				if("".equals(oldcontext)){
					writercontext = userInput+'\n';
				}else{
					writercontext = oldcontext+userInput;
				}
				
				//д��
				FileWriter filewriter = null;
				try {
					filewriter = new FileWriter(file);
					filewriter.write(writercontext);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{			
					if(filewriter!=null){
						try {
							filewriter.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		
	}
	
	
}
