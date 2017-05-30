package xiancheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Peizhi2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		File file = new File("src/com/yanxin/Text.txt");
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
				RandomAccessFile randomaccessfile=null;
				try {
					randomaccessfile = new RandomAccessFile(file,"rw");
					randomaccessfile.seek(file.length());
					randomaccessfile.write(userInput.getBytes());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					if(randomaccessfile!=null){
						try {
							randomaccessfile.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
					if(userInput.equals(userInput)){
						System.out.println("登陆成功");
					}
			
	}

}
