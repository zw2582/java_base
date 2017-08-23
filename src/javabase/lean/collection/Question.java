package javabase.lean.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * http://docs.oracle.com/javase/tutorial/collections/interfaces/QandE/questions.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月23日上午11:50:41
 */
public class Question {
	
	public static void main(String[] args) {
		exercise3();
	}

	public static void question1() {
		//1.不是真的属于Collection接口的集合
		System.out.println("Map");
		
		//2.Collection框架中接口都指定泛型的优点有哪些？
		System.out.println("便于编译时检查检查，避免运行时错误");
		
		//3.什么接口表示不能保存重复元素
		System.out.println("Set");
		
		//4.collection框架的顶层是
		System.out.println("Collection");
		
		//5.什么集合是有序的且可以保存重复元素
		System.out.println("List");
		
		//6.什么集合表示在执行之前保存元素
		System.out.println("Queue");
		
		//7.什么集合表示键值对映射
		System.out.println("Map");
		
		//8.具有两个端点操作的Queue叫什么
		System.out.println("Deque");
		
		//9.三种遍历List集合的不同方法
		System.out.println("streams");
		System.out.println("for-each");
		System.out.println("iterator");
		
		//10.以下说法是否正确：aggregate opration是修改集合底层的变异操作
		System.out.println(false);
	}
	
	/**
	 * Write a program that prints its arguments in random order. 
	 * Do not make a copy of the argument array. 
	 * Demonstrate how to print out the elements using both streams 
	 * and the traditional enhanced for statement.
	 */
	public static void exercise1() {
		String[] a = {"a", "b", "c", "d"};
		
		//1.打乱数组且不制作副本
		List<String> al = Arrays.asList(a);
		Collections.shuffle(al);
		
		//2.流输出
		al.stream().forEach(e->System.out.print(e+" "));
		
		//2.for-each输出
		System.out.println();
		for(String ai: a) {
			System.out.print(ai+" ");
		}
	}
	
	/**
	 * Take the FindDupsexample and modify it to use a SortedSet 
	 * instead of a Set. Specify a Comparator so that case is ignored 
	 * when sorting and identifying set elements.
	 */
	public static void exercise2() {
		String a = "TAKE the take and modify it to use a IT";
		String[] as = a.split(" ");
		
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				//忽略大小写
				return o1.toLowerCase().compareTo(o2.toLowerCase());
			}
		});
		for (String i : as) {
			ts.add(i);
		}
		System.out.println(ts);
	}
	
	/**
	 * Write a method that takes a List<String> and applies 
	 * String.trim to each element.
	 */
	public static void exercise3() {
		String[] a = {"a ", " b ", "c"};
		List<String> l = Arrays.asList(a);
		System.out.println("原始数据："+l);
		
		//聚合操作不会影响集合底层，所以不行
		l.stream().map(String::trim).close();
		
		//for-each不允许修改元素，iterator只有remove，所以只有选择listIterator
		for(ListIterator<String> ai = l.listIterator();ai.hasNext();) {
			ai.set(ai.next().trim());
		}
		
		System.out.println();
		for(String ai : a) {
			System.out.print(ai+",");
		}
	}
	
	public static void exercise4() {
		//1.List,
		//2.Set,
		//3.Map, 
		//4.Queue,
	}
}
