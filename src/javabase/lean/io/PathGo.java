package javabase.lean.io;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path Operations
 * http://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 * @author zhangjiao
 *
 */
public class PathGo {

	public static void main(String[] args) {
		Path path = Paths.get("/home/log/ab.txt");
		
		System.out.println(path.toString());
		System.out.println(path.getName(0));
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getFileSystem());
		System.out.println(path.getParent());
		System.out.println(path.getRoot());
		
		//将文件路径转换为浏览器可打开的模式
		System.out.println(path.toUri());
		
		//将路径转换为绝对路径，如果传入的是绝对路径，则返回原值，这对处理用户输入的
		//路径非常有效
		System.out.println(path.toAbsolutePath());
		
		/**
		 * 相对路径可能在getRoot和getParent中返回null，但绝对路径不会
		 * toAbsolutePath()并不需要文件真实存在
		 */
		Path path2 = Paths.get("go.txt");
		
		System.out.println(path2.getRoot());
		System.out.println(path2.getParent());
		
		Path ap2 = path2.toAbsolutePath();
		System.out.println(ap2.getRoot());
		System.out.println(ap2.getParent());
		
		/**
		 * toRealPath:
		 * 1.如果传入参数true，则支持软连接
		 * 2.如果是相对路径，则返回绝对路径
		 * 3.如果路径中有冗余，则删除冗余
		 * 如果文件不存在或文件无法访问，则抛出异常NoSuchFileException
		 */
		Path path3 = Paths.get("./1.txt");
		try {
			Path realPath = path3.toRealPath();
			System.out.println(realPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * resolve:
		 * 合并路径
		 * 如果传入的是绝对路径，则返回绝对路径
		 */
		Path path4 = Paths.get("home/caca");
		Path resolve = path4.resolve("./go.txt");
		System.out.println(resolve);
		
		/**
		 * relativize:
		 * 创建相对路径导航
		 * 如果只有一个路径是绝对路径，则无法构建相对路径
		 */
		Path bar = Paths.get("bar");
		Path sollr = Paths.get("sollr");
		System.out.println(bar.relativize(sollr));
		System.out.println(sollr.relativize(bar));
		
		Path home = Paths.get("home/bar");
		System.out.println(bar.relativize(home));
		System.out.println(home.relativize(bar));
		
		/**
		 * equals,startWith,endWith:用于比较路径
		 * Paths实现了Iterable，可以实现便利
		 * Paths还实现了Comparable,可以支持比较和排序
		 * isSameFile：判断路径是否定位了同一个文件
		 */
	}

}
