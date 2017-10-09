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
		testIteratorRemove();
	}
	
	public static void testBlukOpration() {
		//定义List集合
		String[] a = new String[]{"a", "b", "c"};
		ArrayList<String> al = new ArrayList<>(Arrays.asList(a));
		
		String[] a1 = new String[]{"b","c"};
		List<String> al1 = new ArrayList<>(Arrays.asList(a1));
		
		//fill
//		Collections.fill(al, "d");
		System.out.println(al);
		
		//fistSubList
		System.out.println(Collections.indexOfSubList(al, al1));
	}
	
	/**
	 * range-view操作
	 * subList
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月21日下午2:11:04
	 */
	public static void testSubList() {
		//定义List集合
		String[] a = new String[]{"a", "b", "c"};
		ArrayList<String> al = new ArrayList<>(Arrays.asList(a));
		
		//返回的list有主list支持，所以所有非结构操作都会互相影响
		List<String> subList = al.subList(0, 3);
		
		//显示的索引位置不一样
		System.out.println("*****显示不同元素的索引****");
		System.out.println(al.indexOf("c"));
		System.out.println(subList.indexOf("c"));
		
		//添加元素
		System.out.println("****添加元素****");
		subList.add("d");
		System.out.println(al.indexOf("d"));
		System.out.println(subList.indexOf("d"));
		
		//删除元素
		System.out.println("****删除元素****");
		subList.clear();
		System.out.println(al);
		System.out.println(subList);
		
		//主list添加元素
		System.out.println("****主list添加元素****");
		al.remove(2);
		System.out.println(al);
		System.out.println(subList);
	}
	
	/**
	 * 遍历
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午8:49:36
	 */
	public static void testListIterator() {
		//定义List集合
		String[] a = new String[]{"a", "b", "c"};
		ArrayList<String> al = new ArrayList<>(Arrays.asList(a));
		
		//正向遍历
		ListIterator<String> lit = al.listIterator(0);
		System.out.println(lit.nextIndex());
		System.out.println(lit.previousIndex());
		while (lit.hasNext()) {
			System.out.print(lit.next()+" ");
			System.out.print("index:"+lit.nextIndex()+",");
		}
		System.exit(0);
		
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
		
		System.out.println(al);
	}
	
	public static void testBluk() {
		List<String> al = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		al.removeAll(Collections.singleton("b"));
		System.out.println(al);
		
		al.addAll(Arrays.asList("e","f"));
		System.out.println("addAll:"+al);
		
		boolean containsAll = al.containsAll(Arrays.asList("a", "c"));
		System.out.println("containsAll:"+containsAll);
		
		al.retainAll(Arrays.asList("a","c","f"));
		System.out.println("retainAll:"+al);
		
	}
	
	public static void testIteratorRemove() {
		List<String> al = new ArrayList<>(Arrays.asList("a", "b", "c"));
		ListIterator<String> iterator = al.listIterator();
		
		while(iterator.hasNext()){
			iterator.next();
			iterator.add("dd");
		}
		
		al.stream().forEach(e->System.out.print(e+","));
	}

}
