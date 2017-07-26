package javabase.lean.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerProvice {
	
	public static void main(String[] args) throws IOException {
		test2();
	}
	
	public static void test2() throws IOException {
		Pattern p = Pattern.compile("^\\t\\d+\\s+");
		Matcher m = null;
		try(BufferedReader br = new BufferedReader(new FileReader("1.txt"));) {
			String line = null;
			while ((line = br.readLine())!=null) {
				System.out.println(line);
				m = p.matcher(line);
				if (m.find()) {
					System.out.println(line);
				}
			}
		}
	}

	public static void test1() throws IOException {
		Scanner scanner = null;
		PrintStream ps = null;
		String sql = "INSERT INTO `district` (`id`,`name`, `pid`,`national_code`) VALUES (%d,'%s',%d, '%s');";
		try {
			scanner = new Scanner(new BufferedReader(new FileReader("1.txt")));
			
			int code=0;
			String addr = null;
			int index = 0;
			String subaddr = null;
			int id = 241;
			ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("natinal_code.sql")));
			while(scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					code = scanner.nextInt();
				} else {
					addr = scanner.next();
				}
				index++;
				if (index % 2 == 0 && code >0 && addr != null) {
					subaddr = addr.substring(0, addr.length()-1);
					ps.printf(sql, code, addr, subaddr);
				}
			}
		} finally {
			scanner.close();
			if (ps != null) {
				ps.close();
			}
		}
		
		
	}

}
