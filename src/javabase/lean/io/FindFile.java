package javabase.lean.io;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * 寻找文件
 * 
 * http://docs.oracle.com/javase/tutorial/essential/io/find.html
 * 
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月29日下午12:20:24
 */
public class FindFile {

	public static void main(String[] args) {
		//创建匹配器，每个filesystem都支持创建匹配器
		final PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
		
		Path path = Paths.get("caca.txt");
		//进行目录匹配
		boolean result = pathMatcher.matches(path);
		
		System.out.println("是否匹配："+result);
	}
}
