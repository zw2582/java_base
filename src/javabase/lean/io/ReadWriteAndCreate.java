package javabase.lean.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * 读、写、创建文件
 * 
 * @see http://docs.oracle.com/javase/tutorial/essential/io/file.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月26日下午5:14:20
 */
public class ReadWriteAndCreate {

	/**
	 * 对于小文件的常见操作
	 * @author wei.w.zhou.integle.com
	 * @throws IOException 
	 * @copyright 2017年7月26日下午5:14:03
	 */
	public static void commonForSmall(String file) throws IOException {
		Path path = Paths.get(file);
		//字节读
		byte[] allbytes = Files.readAllBytes(path);
		
		//字节写
		Files.write(path, allbytes, StandardOpenOption.WRITE);
		
		//字符读
		List<String> alllines = Files.readAllLines(path);
		for(String line : alllines) {
			System.out.println(line);
		}
		
		//字符写
		Files.write(path, "你大爷的".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		
	}
	
	/**
	 * newBufferedReader读取文件，适合文本文件
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午5:38:42
	 */
	public static void bufferedRead(String file) throws IOException {
		
		Path path = Paths.get(file);
		
		Charset cs = Charset.forName("UTF-8");
		
		try(BufferedReader nbr = Files.newBufferedReader(path, cs)){
			String line = null;
			while ((line = nbr.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
	
	/**
	 * buffered写
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午5:42:36
	 */
	public static void bufferedWrite(String file) throws IOException {
		Path path = Paths.get(file);
		
		Charset cs = Charset.forName("UTF-8");
		
		try(BufferedWriter nbw = Files.newBufferedWriter(path, cs, StandardOpenOption.APPEND)) {
			nbw.write("你们好，我是你们的兄弟");
		} 
	}
	
	/**
	 * 无缓冲流的read，其实就是Files.newBufferedRead()的实现
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException 
	 * @copyright 2017年7月26日下午5:56:54
	 */
	public static void inputStreamRead(String file) throws IOException {
		Path path = Paths.get(file);
		
		try(InputStream nis = Files.newInputStream(path)) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(nis));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
	
	/**
	 * 无缓冲写入
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午6:04:42
	 */
	public static void outputStreamWriter(String file) throws IOException {
		Path path = Paths.get(file);
		
		try(BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.APPEND))){
			bos.write("你他大爷的过来呀".getBytes());
		}
	}
	
	public static void main(String[] args) throws IOException {
//		commonForSmall("1_c.txt");
//		bufferedRead("1_w.txt");
//		bufferedWrite("1_w.txt");
		outputStreamWriter("1_w.txt");
	}
}
