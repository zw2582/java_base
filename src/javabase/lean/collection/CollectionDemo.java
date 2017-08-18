package javabase.lean.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Collection接口
 * {@link http://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html}
 * @author wei.w.zhou.integle.com
 * @since 2017年8月18日下午2:26:06
 */
public class CollectionDemo {

	public static void main(String[] args) {
//		testTrave();
//		testRemove();
//		blukOpration();
		collectionArray();
	}
	
	//测试循环
	public static void testTrave() {
		List<String> c = Arrays.asList("a", "b", "c");
		//1.使用聚合操作
		c.stream().forEach(e->System.out.print(e+" "));
		
		//2.使用for-each
		System.out.println();
		for(String a : c) {
			System.out.print(a+" ");
		}
		
		//3.iterator
		System.out.println();
		Iterator<String> i = c.iterator();
		while (i.hasNext()) {
			String is = i.next();
			System.out.print(is+" ");
		}
		
	}
	
	/**
	 * 测试遍历删除
	 * iterator.remove是在迭代期间删除元素的唯一安全方法
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午2:33:18
	 */
	public static void testRemove() {
		HashSet<String> hs = new HashSet<>(Arrays.asList("a", "b", "c"));
		
		Iterator<String> it = hs.iterator();
		String its;
		while (it.hasNext()) {
			its = it.next();
			if (its.equals("b")) {
				it.remove();
			}
		}
		
		System.out.println();
		
		//使用for-each删除，报错
		/*for (String s : hs) {
			if (s.equals("b")) {
				hs.remove(s);
			}
			System.out.print(s+" ");
		}*/
		
		for (String s : hs) {
			if (s.equals("b")) {
				hs.remove(s);
			}
			System.out.print(s+" ");
		}
	}
	
	/**
	 * 批量操作
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午3:07:00
	 */
	public static void blukOpration() {
		//返回一个不变的set，仅包含指定的元素
		Set<String> sc = Collections.singleton("c");
		
		Set<String> c = new HashSet<>(Arrays.asList("a", "b", "c"));
		
		//批量删除
		c.removeAll(sc);
		
		c.removeAll(Collections.singleton(null));
		
		System.out.println(c);
	}
	
	/**
	 * 集合的转数组操作
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午3:16:08
	 */
	public static void collectionArray() {
		Set<String> c = new HashSet<>(Arrays.asList("a", "b", "c", "1"));
		
		Object[] arr1 = c.toArray();
		for(Object o : arr1) {
			System.out.print(o+" ");
		}
		System.out.println();
		
		//如果知道类型，可以转化为相应的类型
		String[] arr2 = c.toArray(new String[0]);
		for(String o : arr2) {
			System.out.print(o+" ");
		}
	}
}
