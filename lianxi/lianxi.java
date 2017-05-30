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
			System.out.println("长度:"+list.get(i));
		}
		
		System.out.println("长度:"+list.contains("1112"));//判断集合里是否包含指定的元素
		
		System.out.println(list.containsAll(lists));//返回集合里是否包含另一集合内所有的元素
		
		System.out.println(lists.isEmpty());
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(lists.iterator());
		}
		
		/*
		 * 遍历方式1
		 * List<String> list = new ArrayList<String>();
		 *list.add("111");
		 *list.add("222");
		 *
		 *for(int i = 0 ; i<list.size();i++){
		 *	System.out.println("长度:"+list.get(i));
		 *}
		 *
		 *for(String s:list){
		 *	System.out.println("长度:"+s);
		 *}
		 */
		
		
		
		/*
		 * 遍历方式2---迭代器
		 * Iterator iterator = list.iterator();
		 *while(iterator.hasNext()){
		 *	System.out.println("元素："+iterator.next());;
		 *}
		 */
		
//		list.remove(0);
//		System.out.println("get0:"+list.get(0));
		
		
		
	}
}

 
