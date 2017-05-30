package xiancheng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Peizhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		File file = new File("Text.txt");
		if(!file.exists()){
			try {	
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//用户输入的内容
		String userInput="";
		System.out.println("请输入你要输入的内容");
		userInput=sc.nextLine();
		//先读取原来文件的内容
		StringBuffer stringbuffer = new StringBuffer();
		int len;
		byte[] bytes = new byte[1024];
		FileInputStream fileinputstream = null;
		try {
			fileinputstream = new FileInputStream(file);
			while((len = fileinputstream.read(bytes))!=-1){
				stringbuffer.append(new String(bytes,0,len));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if(fileinputstream!=null){
				try {
					fileinputstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//原来文件的内容
		String oldcontext = stringbuffer.toString();
		String writercontext = "";
		if("".equals(oldcontext)){
			writercontext = userInput+'\n';
		}else{
			writercontext = oldcontext+userInput;
		}
		
		//写入
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
		/*if(writercontext.equals(writercontext)){
			System.out.println("登陆成功");
		}*/
	}
}
