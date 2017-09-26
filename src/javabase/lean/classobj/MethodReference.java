package javabase.lean.classobj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class MethodReference {
	

	public static void main(String[] args) {
		//原始lambda
		A a = (e)->System.out.println(e); 
		a.dd("caca");
		
		//静态方法引用
		A a1 = Person::go;
		a1.dd("gogo");
		
		//实例方法引用
		Person p1 = new Person();
		A a2 = p1::go2;
		a2.dd("gogo2");
		
		//引用特定类型的任意对象的实例方法
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		
		Person p2 = new Person();
		Person p3 = new Person();
		Person[] pl = {p1,p2,p3};
		
		Arrays.sort(pl, Person::comparetor);
		
		StringDemo.sort(pl, Person::comparetor);
		
		//引用构造函数
		//1.传统lambda
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,2,3,4));
		HashSet<Integer> dest = transform(al, ()->new HashSet<>());
		System.out.println(dest);
		
		//2.引用构造函数
		HashSet<Integer> dest2 = transform(al, HashSet::new);
		System.out.println(dest2);
	}
	
	public static <T> void gogo(T[] p, B<? super T> c) {
		System.out.println("caca");
	}
	
	
	interface Supplier<T> {
		T get();
	}
	
	/**
	 * 转换所有元素到另一个集合
	 */
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transform(
			SOURCE source, Supplier<DEST> supplier) {
		DEST dest = supplier.get();
		
		dest.addAll(source);
		return dest;
	}
	
	interface A {
		public void dd(String a);
	}
	
	interface B<T> {
		public int pp(T a);
	}
	
	static class Person {
		
		public int comparetor(Person p) {
			return -1;
		}
		
		public static void go(String a) {
			System.out.println(a);
		}
		
		public void go2(String a) {
			System.out.println(a);
		}
		
		public int god(Person p) {
			return -1;
		}
		
		public static <T> void getCA(B<? super T> b, T a) {
			System.out.println("caca:"+b.pp(a));
		}
		
		public String ppDD(String a) {
			
			return "ca";
		}
	}
}
