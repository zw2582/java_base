package javabase.lean.exception;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * java基础之exception
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月7日下午1:54:33
 */
public class ExceptionCatch {

	/**
	 * 
	 * 遍历压缩包，并将压缩包名称输出到指定文件
	 * 
	 * 使用try-with-resources创建多个可关闭资源，并执行业务
	 * 可关闭资源指任何实现了java.lang.AutoCloseable的对象，包括实现java.io.Closeable的所有对象
	 */
	public static void writeToFileZipFileContents(String zipFileName, String outputFileName) throws java.io.IOException {
		Path outputFilePath = Paths.get(outputFileName);
		
		/*
		 * try-with-resources声明两个可关闭资源Zipfile和BufferedWriter
		 */
		try(ZipFile zf = new ZipFile(zipFileName);
				BufferedWriter wirte = Files.newBufferedWriter(outputFilePath, StandardCharsets.US_ASCII)) {
			for(Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				String newline = System.getProperty("line.seperator");
				String zipEntryName = ((ZipEntry)entries.nextElement()).getName()+newline;
				wirte.write(zipEntryName, 0 , zipEntryName.length());
			}
		};
	}
	
	/**
	 * 自动关闭java.sql.Statement对象
	 * @throws SQLException 
	 */
	public static void viewTable(Connection con) {
		String query = "select * from integle_apply";
		
		/*
		 * try-with-resources声明Statement可关闭资源，并在执行结束之后关闭资源，不论try执行成功还是失败
		 */
		try(Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("name");
			}
		} catch (SQLException e) {
			//捕获异常
			e.printStackTrace();
			
			//如果在清理资源的过程中抛出异常，则这些异常被抑制，可以通过try异常的getSuppressed()方法取回这些抑制的异常
			e.getSuppressed();
		} finally {
			/*
			 * 虽然try-with-resources会在try执行之后清理资源，
			 * 但仍然可以自定义catch和finally，catch和finally在清理资源之后执行
			 */
			System.out.println("i am finally");
		}
	}
	
	/**
	 * 发生Java虚拟机中的动态链接故障或其他硬故障时，虚拟机会引发错误。 简单的程序通常不会捕获或抛出错误。
	 */
	public static void throwError() {
		throw new Error("wocuole");
	}
	
	/**
	 * 大多数程序抛出并捕获从Exception类派生的对象。 异常表示发生问题，但不是严重的系统问题。 你编写的大多数程序都会抛出异常，而不是错误。
	 */
	public static void throwException() {
		throw new IllegalAccessError();
	}
	
	public static void throwException2() {
		throw new IllegalArgumentException();
	}
	
	public static void throwException3() {
		throw new NullPointerException();
	}
	
	public static void throwException4() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	public static void main(String[] args) throws IOException {
		int read = System.in.read();
		System.out.println("in:"+read);
	}
}
