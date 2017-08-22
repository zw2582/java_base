package javabase.lean.collection;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class StoredMap {

	public static void main(String[] args) {
		//1.初始化map
		TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				/*
				 * 此处不适用o2-o1的原因是，当o2为最大值，且o1为负数是，结果为负数
				 * 将产生偏差
				 */
//				return o2 - o1;
				return (o1 > o2 ? 1 : (o1 == o2 ? 0 : -1));
			}
		});
		
		tm.put(1, "caca1");
		tm.put(4, "caca4");
		tm.put(7, "caca7");
		tm.put(2, "caca2");
		tm.put(6, "caca6");
		
		//打印数据
		System.out.println(tm);
		
		//查看toArray()
		String[] ar = tm.values().toArray(new String[0]);
		for(String a : ar) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		//rang-view操作
		SortedMap<Integer, String> stm = tm.subMap(1, 7);
		System.out.println("subMap:"+stm);
		
		//headMap
		System.out.println("headMap:"+tm.headMap(7));
		//tailMap
		System.out.println("tailMap:"+tm.tailMap(4));
		
		//endpoint
		System.out.println("first:"+tm.firstEntry());
		System.out.println("last:"+tm.lastEntry());
		System.out.println(tm.pollLastEntry());
		System.out.println(tm.pollFirstEntry());
		System.out.println(tm.lastKey());
		
		//comparator
		System.out.println("comparator:"+tm.comparator().compare(7, 4));
	
	}
}
