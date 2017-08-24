package javabase.lean.classobj;

import java.util.Comparator;

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
}
