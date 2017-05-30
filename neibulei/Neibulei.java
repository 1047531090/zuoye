package neibulei;

import java.io.File;
import java.io.FileReader;
import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//public class Neibulei {
//	public static void main(String[] args) {
////		Map map = new HashMap();
////		Iterator iii = map.entrySet().iterator();
////		while(iii.hasNext()){
////			Map.Entry entry = (Map.Entry) iii.next();
////			Object key = entry.getKey();
////			Object val = entry.getValue();
////		}
//		
//		
//	}
//}


//public class Neibulei{
//	public static Neibulei iii = null;
//	public static Neibulei getIii(){
//		if(iii == null){
//			iii = new Neibulei();
//		}
//		return iii;
//	}
//	private Neibulei(){}
//}


//public class Neibulei{
//	public static Neibulei iii = new Neibulei();
//	public static Neibulei getIii(){
//		return iii;
//	}
//	private Neibulei(){}
//	public void show(){
//		
//	}
//}



public class Neibulei{
	public static void main(String[] args) {
		File file = new File("ming.tx");
		FileReader f = new FileReader(file);
		char[] chars = new char[1024];
		FileReader.read(chars);
		for(char c:chars){
			System.out.println("11111");
		}
	}
}