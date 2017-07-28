package javabase.lean.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * 创建和读目录
 * 
 * http://docs.oracle.com/javase/tutorial/essential/io/dirs.html
 * 
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月28日下午3:49:48
 */
public class CreateAndReadDirectory {
	
	/**
	 * 获取root目录列表
	 * @author wei.w.zhou.integle.com
	 * @throws URISyntaxException
	 * @copyright 2017年7月28日下午3:51:41
	 */
	public static void listRootDir() throws URISyntaxException {
		Iterable<Path> rootDirs = FileSystems.getDefault().getRootDirectories();
		
		for(Path p : rootDirs) {
			System.out.println(p.toString());
		}
	}
	
	/**
	 * 创建目录
	 * 
	 * Files.createDirectory:创建一级目录
	 * Files.createDirectories:创建多级目录
	 * @author wei.w.zhou.integle.com
	 * @param isDos
	 * @throws IOException
	 * @copyright 2017年7月28日下午4:00:08
	 */
	public static void createDir(Boolean isDos) throws IOException {
		if (isDos) {
			Files.createDirectories(Paths.get("newdir/a/b"));
		} else {
			Set<PosixFilePermission> pfps = PosixFilePermissions.fromString("rw-r-----");
			FileAttribute<Set<PosixFilePermission>> fa = PosixFilePermissions.asFileAttribute(pfps);
			
			Files.createDirectories(Paths.get("/tmp/newdir"), fa);
		}
	}
	
	/**
	 * 创建临时目录
	 * @author wei.w.zhou.integle.com
	 * @throws IOException
	 * @copyright 2017年7月28日下午4:07:33
	 */
	public static void createTmpDir() throws IOException {
		Path tmpdir1 = Files.createTempDirectory("tmp_");
		System.out.println(tmpdir1.toAbsolutePath());
		
		Path tmpdir2 = Files.createTempDirectory(Paths.get("/"), "tmp_");
		System.out.println(tmpdir2.toAbsolutePath());
		
		Files.delete(tmpdir1);
		Files.delete(tmpdir2);
	}
	
	/**
	 * 列出目录对象
	 * @author wei.w.zhou.integle.com
	 * @throws IOException 
	 * @copyright 2017年7月28日下午4:15:05
	 */
	public static void listDirContent(String glob) throws IOException {
		Path path = Paths.get("./");
		
		try(DirectoryStream<Path> ds = glob == null ? 
				Files.newDirectoryStream(path) : 
					Files.newDirectoryStream(path, glob)) {
			String type = "other";
			for (Path obj : ds) {
				if (Files.isDirectory(obj)) {
					type = "dir";
				} else if (Files.isRegularFile(obj)) {
					type = "file";
				} else if (Files.isSymbolicLink(obj)) {
					type = "link";
				}
				System.out.println(type+"-"+obj.toRealPath().toString());
			}
		}
	}
	
	/**
	 * 自定义目录筛选器
	 * @author wei.w.zhou.integle.com
	 * @throws IOException
	 * @copyright 2017年7月28日下午4:44:23
	 */
	public static void listDirContentByFilter() throws IOException {
		//定义筛选器，只允许目录显示
		Filter<Path> filter = new DirectoryStream.Filter<Path>() {

			@Override
			public boolean accept(Path entry) throws IOException {
				return Files.isDirectory(entry);
			}
		};
		
		Path path = Paths.get("./");
		
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(path, filter)) {
			String type = "other";
			for (Path obj : ds) {
				if (Files.isDirectory(obj)) {
					type = "dir";
				} else if (Files.isRegularFile(obj)) {
					type = "file";
				} else if (Files.isSymbolicLink(obj)) {
					type = "link";
				}
				System.out.println(type+"-"+obj.toRealPath().toString());
			}
		}
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException {
//		listRootDir();
//		createDir(true);
//		createTmpDir();
		/**
		 * 使用GLOB过滤结果
		 */
//		listDirContent("*[1-9]*.txt");
		
		/**
		 * 使用自定义筛选器筛选目录
		 */
//		listDirContentByFilter();
	}
	
}
