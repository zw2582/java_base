package javabase.lean.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	
	public static final String file = "data.txt";
	
	public static void main(String[] args) throws IOException {
//		output();
		input();
	}
	
	/**
	 * 读取
	 * @throws IOException
	 */
	public static void input() throws IOException {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			//如果不保持读取顺序，要么数据不对，要么，抛出EOFException
			Double dv = dis.readDouble();
			int iv = dis.readInt();
			
			String sv = dis.readUTF();
			
			System.out.printf("dv:%f,iv:%d,sv:%s", dv,iv,sv);
		} finally {
			if (dis != null) {
				dis.close();
			}
		}
	}

	/**
	 * 输出
	 * @throws IOException
	 */
	public static void output() throws IOException {
		DataOutputStream dos =null;
		try {
			dos= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			
			dos.writeDouble(123.2);
			dos.writeInt(23);
			dos.writeUTF("你好，我的大神");
		} finally {
			if (dos != null) {
				dos.close();
			}
		}
	}
}
