package javabase.lean.classobj.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringDemo {

	//子序列操作
	@Test
	public void stringChar() {
		String a = "abcdefg";
		
		System.out.println("charAt:"+a.charAt(2));
		//返回【2，5）之间的子序列
		System.out.println("返回【2，5）之间的子序列:"+a.substring(2, 5));
		
		System.out.println("返回【2，之后的子序列："+a.substring(2));
	}
	
	//搜索
	@Test
	public void stringSearch() {
		String a = "abcdefg";
		
		System.out.println("搜索a的位置："+a.indexOf('a'));
		System.out.println("搜索de的位置："+a.indexOf("de"));
		System.out.println("从索引3处开始搜索f的位置"+a.indexOf("b", 3));
		System.out.println("搜索cde是否存在于字符串中："+a.contains("cde"));
	}
	
	//替换
	@Test
	public void stringRepalce() {
		String a = "abcdefg";
		
		System.out.println("替换b："+a.replace('b', '2'));
		System.out.println("replace:"+a.replace("bc", "234"));
		System.out.println("replaceAll:"+a.replaceAll("c?a", "234"));
		System.out.println("repalceFirst:"+a.replaceFirst("c?a", "234"));
	}
	
	/**
	 * String比较
	 */
	@Test
	public void stringCompare() {
		String a = "abcdefg";
		String b = "defghij";
		
		System.out.println("startWith:"+a.startsWith("abc"));
		System.out.println("startWith index:"+a.startsWith("def", 3));
		System.out.println("endWith:"+a.endsWith("efg"));
		
		System.out.println("equals:"+a.equals("abcdefg"));
		System.out.println("equalsIgnoreCase:"+a.equalsIgnoreCase("ABCDEFG"));
		System.out.println("compareto:"+a.compareTo(b));
		System.out.println("compareToIgnoreCase:"+a.compareToIgnoreCase("DEFGHIJ"));
		
		System.out.println("matches:"+a.matches("\\w+"));
		System.out.println("regionMatches:"+a.regionMatches(0, "iiabcdefgii", 2, 7));
	}
	
	/**
	 * StringBuilder
	 */
	@Test
	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder("abcd");
		System.out.println("length:"+sb.length());
		System.out.println("capacity:"+sb.capacity());
		
		sb.setLength(2);
		System.out.println("after setLength, length:"+sb.length());
		System.out.println("after setLength, capacity:"+sb.capacity());
		System.out.println(sb);
		
		String a= "23423423";
	}
	
	/**
	 * 自动装箱和拆箱
	 */
	public void autoBoxingUnBoxing() {
		//装箱
		//1.分配给包装类型变量
		Integer a = 1;
		List<Integer> al = new ArrayList<>();
		//2.作为参数传递给相应的包装类型的方法，int传递给Integer的集合，java并不报错，因为他执行了自动装箱
		al.add(12);
		//就像这样
		al.add(Integer.valueOf(23));
		
		//拆箱
		//1.分配给原始类型变量
		int b = new Integer(12);
		//2.作为参数床递给相应的原始类型的方法
		
	}
	
}
