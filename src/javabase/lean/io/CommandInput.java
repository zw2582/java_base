package javabase.lean.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

import javabase.lean.exception.Ca;

/**
 * 控制台输入
 * @author zhangjiao
 * printStream:支持各种数据类型的打印
 * DataStream:支持各种原始类型包括String的流的写出和读入,输入的结果是二进制的，看不懂的
 * Scanner：支持数据读入的分割，以及类型检查和转换
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
		ps.print(new Ca());

		//检查printStream的错误，PrintStream不会抛出IOException
		//		ps.checkError();
		while(sc.hasNext()) {
			ps.printf("data:%s%n", sc.next());
//			System.out.println(sc.next());
		}
		
	}
}
