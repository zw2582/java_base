package javabase.lean.classobj;

import java.util.Comparator;

import javabase.lean.classobj.MethodReference.B;

public class StringDemo {
	public int compareToIgnoreCase(String str) {
        Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		return comparator.compare("ca", str);
    }
	
	public static <T> void sort(T[] a, Comparator<? super T> c) {
        System.out.println("aca");
    }
	
	public static <T> void gogo(T[] p, B<? super T> c) {
		System.out.println("caca");
	}
}
