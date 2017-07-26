package javabase.lean.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ca {
	
	private String go;
	
	
	public String getGo() {
		return go;
	}

	public void setGo(String go) {
		this.go = go;
	}

	public void caca1() throws FileNotFoundException {
		throw new FileNotFoundException();
	}

	public static void main(String[] args) throws IOException {
		/*int read = System.in.read();
		System.out.println("in:"+read);*/
		
		System.out.println("输入包含空格，制表符在内的字符串");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read3 = br.readLine();
		System.out.println("read3:"+read3);
		
		System.out.println("输入一段文字：");
		Scanner scanner = new Scanner(System.in);
		String read2 = scanner.nextLine();
		System.out.println("read2:"+read2);
	}

}
