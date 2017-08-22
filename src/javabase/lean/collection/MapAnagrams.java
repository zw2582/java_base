package javabase.lean.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MapAnagrams {

	public static void main(String[] args) throws FileNotFoundException {
		int minGroupSize = Integer.parseInt(args[1]);
		
		HashMap<String, List<String>> mutilMap = new HashMap<>();
		
		Scanner scanner = new Scanner(new File(args[0]));
		while (scanner.hasNext()) {
			String next = scanner.next();
			String apa = apa(next);
			
			List<String> l = mutilMap.get(apa);
			
			if (l == null) {
				mutilMap.put(apa, l = new ArrayList<String>());
			}
			l.add(next);
		}
		
		Iterator<List<String>> iterator = mutilMap.values().iterator();
		while (iterator.hasNext()) {
			List<String> next = iterator.next();
			if (next.size() >= minGroupSize) {
				System.out.println(next.size()+":"+next);
			}
		}
	}
	
	public static String apa(String next) {
		char[] a = next.toCharArray();
		Arrays.sort(a);
		
		return new String(a);
	}
}
