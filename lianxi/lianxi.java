package lianxi;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class lianxi {
	
	public static void main(String[] args){
		
		List list = new ArrayList();
		list.add("1112");
		list.add("222");
		
		List lists = new ArrayList();
		lists.add("1112");
		
		for(int i = 0 ; i<list.size();i++){
			System.out.println("����:"+list.get(i));
		}
		
		System.out.println("����:"+list.contains("1112"));//�жϼ������Ƿ����ָ����Ԫ��
		
		System.out.println(list.containsAll(lists));//���ؼ������Ƿ������һ���������е�Ԫ��
		
		System.out.println(lists.isEmpty());
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(lists.iterator());
		}
		
		/*
		 * ������ʽ1
		 * List<String> list = new ArrayList<String>();
		 *list.add("111");
		 *list.add("222");
		 *
		 *for(int i = 0 ; i<list.size();i++){
		 *	System.out.println("����:"+list.get(i));
		 *}
		 *
		 *for(String s:list){
		 *	System.out.println("����:"+s);
		 *}
		 */
		
		
		
		/*
		 * ������ʽ2---������
		 * Iterator iterator = list.iterator();
		 *while(iterator.hasNext()){
		 *	System.out.println("Ԫ�أ�"+iterator.next());;
		 *}
		 */
		
//		list.remove(0);
//		System.out.println("get0:"+list.get(0));
		
		
		
	}
}

 
