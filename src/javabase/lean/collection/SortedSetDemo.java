package javabase.lean.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortedSet的各种操作
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月22日下午3:40:32
 */
public class SortedSetDemo {
	
	public static void main(String[] args) {
		//初始化SortedSet集合
		SortedSet<String> ts = new TreeSet<>(Arrays.asList("c", "d", "a", "b"));
		System.out.println("初始化SortedSet集合："+ts);
		
		//1.范围操作
		System.out.println("范围操作："+ts.subSet("a", "c"));
		System.out.println("范围操作，全包围："+ts.subSet("a", "c\0"));
		System.out.println("headSet:"+ts.headSet("d"));
		System.out.println("tailSet:"+ts.tailSet("b"));
		
		//2.endpoint操作
		System.out.println("first:"+ts.first());
		System.out.println("last:"+ts.last());
		
		//3.访问comparator
		System.out.println("comparator:"+ts.comparator());
	}
}
