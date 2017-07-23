package javabase.lean.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javabase.lean.io.model.A;
/**
 * 同一个对象在一个流中输出两次，他们的引用地址一样
 * 同一个对象被写入不同的流，则它们变成两个完全不同的对象
 * @author zhangjiao
 *
 */
public class ObjectStream {
	
	public static final String file = "obj_io.txt";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		output();
//		input();
	}

	/**
	 * 对象输出
	 * @throws IOException
	 */
	public static void output() throws IOException {
		A a = new A();
		
		ObjectOutputStream oos = null;
		try {
			//ObjectStream 继承自DataStream,使用的是字节流
			oos =new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			oos.writeObject(a);
			oos.writeObject(a);
		} finally {
			if (oos != null) {
				oos.close();
			}
		}
	}
	
	/**
	 * 读入对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void input() throws IOException, ClassNotFoundException {
		try(ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(file)))){
			A a1 = (A) ois.readObject();
			A a2 = (A) ois.readObject();
//			A a3 = (A) ois.readObject();
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a1 == a2);
			System.out.println(a1.equals(a2));
//			System.out.println(a3);
		}
	}
}
