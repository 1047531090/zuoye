package huigu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Huigu1 {
	public static void main(String[] args) {
		File file = new File("test.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String  s = "xiaoxu";
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(s.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
