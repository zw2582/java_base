package javabase.lean.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 控制台输入
 * @author zhangjiao
 *
 */
public class CommandInput {

	public static void main(String[] args) throws IOException {
//		InputStreamReader isr = new InputStreamReader(System.in);
//		
//		int read = isr.read();
//		System.out.println(read);
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
	}
}
