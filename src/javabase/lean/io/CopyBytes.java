package javabase.lean.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示byte stream的操作过程，所有的byte stream都来自于InputStream和OutputStream
 * 有byte stream的类，比如FileInputStream
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月16日下午5:05:54
 */
public class CopyBytes {

	/**
	 * 复制文本
	 * 一次一个字节
	 * 
	 * 这是一个低级的I/O处理程序，应该避免；
	 * 而且文本中包含字符，应该使用字符流，字节流只适用于最原始的I/O
	 * 
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @throws IOException
	 * @copyright 2017年7月16日下午5:07:36
	 */
	public static void main(String[] args) throws IOException{
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream("1.txt");
			fo = new FileOutputStream("1_c.txt");
			
			int c;
			while ((c = fi.read()) != -1) {
				fo.write(c);
			}
		} finally {
			//一定要确保不再使用资源后，关闭流，即使会抛出异常，所以使用finally，防止内存泄露
			if(fi != null) {
				fi.close();
			}
			if(fo != null) {
				fo.close();
			}
		} 
		
	}
}
