package javabase.lean.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Set集合操作
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月18日下午4:24:08
 */
public class SetDemo {
	
	public static void main(String[] args) {
		blukOpration();
	}

	/**
	 * Collection转换到Set
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午4:32:37
	 */
	public static void collectionToSet() {
		Collection<String> c = Arrays.asList("e", "d", "i", "1", "i", "3", "a","b","c","g","f");
		
		//HashSet无序
		Set<String> hashset = c.stream().collect(Collectors.toSet());
		hashset.stream().forEach(e->System.out.print(e+" "));
		
		//LinkedHashSet 按照加入顺序排序
		System.out.println();
		LinkedHashSet<String> lhs = c.stream()
				.collect(Collectors.toCollection(LinkedHashSet::new));
		lhs.stream().forEach(e->System.out.print(e+" "));
		
		//TreeSet 按照值顺序排序
		System.out.println();
		TreeSet<String> ts = c.stream()
				.collect(Collectors.toCollection(TreeSet::new));
		ts.stream().forEach(e->System.out.print(e+" "));
	}
	
	/**
	 * Set的批量操作
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月18日下午4:33:14
	 */
	public static void blukOpration() {
		Set<String> s1 = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
		Set<String> s2 = new HashSet<>(Arrays.asList("c", "d", "f"));
		
		//子集判断
		System.out.println("s2是否是s1的子集："+s1.containsAll(s2));
		
		//获取交集
		s1.retainAll(s2);
		System.out.println("交集："+s1);
		
		//获取并集
		s1 = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
		s1.addAll(s2);
		System.out.println("并集："+s1);
		
		//获取差集
		s1 = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
		s1.removeAll(s2);
		System.out.println("差集："+s1);
	}
}
