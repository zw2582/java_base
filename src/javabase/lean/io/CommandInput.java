package javabase.lean.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
		
		PrintStream ps = new PrintStream(new FileOutputStream("print_stream.txt"));

		//检查printStream的错误，PrintStream不会抛出IOException
		//		ps.checkError();
		while(sc.hasNext()) {
			ps.printf("data:%s%n", sc.next());
//			System.out.println(sc.next());
		}
	}
}
