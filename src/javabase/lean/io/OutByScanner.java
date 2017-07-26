package javabase.lean.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * scanner 测试
 * @author zhangjiao
 *
 */
public class OutByScanner {
	
	private static final String file = "1.txt";

	public static void main(String[] args) throws IOException {
		Scanner sc = null;
				
		try {
			sc = new Scanner(new BufferedReader(new FileReader(file)));
			sc.useDelimiter(",\\s*");
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		
	}
}
