package javabase.lean.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * List接口
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月18日下午5:12:43
 */
public class ListDemo {
	
	public static void main(String[] args) {
		testListIterator();
	}
	
	/**
	 * 遍历
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午8:49:36
	 */
	public static void testListIterator() {
		//定义List集合
		String[] a = new String[]{"a", "b", "c","1","2","4","7","6"};
		ArrayList<String> al = new ArrayList<>(Arrays.asList(a));
		
		//正向遍历
		ListIterator<String> lit = al.listIterator(5);
		while (lit.hasNext()) {
			System.out.print(lit.next()+" ");
		}
		
		//反向遍历
		System.out.println();
		while (lit.hasPrevious()) {
			System.out.print(lit.previous()+" ");
		}
		
		//for-each遍历+删除
		System.out.println();
		for(;lit.hasNext();) {
			String as = lit.next();
			if (as.equals("a")) {
				lit.remove();
			}
			System.out.print(as+" ,nextIndex:"+lit.nextIndex());
		}
		System.out.println(lit.nextIndex());
		
		
		//聚合遍历
		System.out.println();
		al.stream().forEach(e->System.out.print(e+" "));
	}
	
	/**
	 * 添加所有
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午8:48:28
	 */
	public static void testAddAll() {
		String[] a = new String[]{"a", "b", "c","1","2","4","7","6"};
		
		ArrayList<String> al = new ArrayList<>(Arrays.asList(a));
		
		al.addAll(3, Arrays.asList("g","z"));
		
		System.out.println(al);
	}
	
	public static void testAsList() {
		String[] a = new String[]{"a", "b", "c","1","2","4","7","6"};
		/*
		 * Arrays.asList:允许将数组视为列表,
		 * 他不复制数组，所有的修改操作依然在数组中完成
		 * 生成的列表不是通用的List实现，它不提供添加删除操作，数组不能调整大小
		 */
		List<String> al = Arrays.asList(a);
		a[2] = "f";
		System.out.println(al);
		
		//Collections.shuffle打乱顺序
		Collections.shuffle(al, new Random());
		System.out.println(al);
	}
	
	/**
	 * 删除元素
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午8:18:45
	 */
	public static void remove() {
		List<String> al = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		Iterator<String> it = al.iterator();
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
	}

}
