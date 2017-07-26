package javabase.lean.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 文件属性管理
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月26日上午11:23:56
 */
public class FileAttribute {

	/**
	 * 一次读取文件多个属性
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年7月26日上午11:35:31
	 */
	public static void readBasicAttr(String file) {
		Path path = Paths.get(file);
		
		try {
			BasicFileAttributes basicAttr = Files.readAttributes(path, BasicFileAttributes.class);
			
			System.out.println("is Directory:"+basicAttr.isDirectory());
			System.out.println("is regular file:"+basicAttr.isRegularFile());
			System.out.println("is Symbolic link:"+basicAttr.isSymbolicLink());
			System.out.println("size:"+basicAttr.size());
			System.out.println("create Time:"+basicAttr.creationTime());
			System.out.println("last modifiedTime:"+basicAttr.lastModifiedTime());
			System.out.println("last accessTime:"+basicAttr.lastAccessTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取属性
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日上午11:43:18
	 */
	public static void readAttr(String file) throws IOException {
		Path path = Paths.get(file);
		
		System.out.println("is Directory:"+Files.isDirectory(path));
		System.out.println("is regular file:"+Files.isRegularFile(path));
		System.out.println("is Symbolic link:"+Files.isSymbolicLink(path));
		System.out.println("size:"+Files.size(path));
		System.out.println("create Time:"+Files.getLastModifiedTime(path));
		System.out.println("owner:"+Files.getOwner(path));
	}
	
	/**
	 * 修改最后修改时间
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日上午11:48:59
	 */
	public static void setLastModifiedTime(String file) throws IOException {
		Path path = Paths.get(file);
		
		System.out.println("before setlastModifiedTime:"+Files.getLastModifiedTime(path));
		
		//获取当前时间
		long currentTime = System.currentTimeMillis();
		
		//创建文件时间
		FileTime ft = FileTime.fromMillis(currentTime);
		
		//修改时间
		Files.setLastModifiedTime(path, ft);
		
		System.out.println("after setlastModifiedTime:"+Files.getLastModifiedTime(path));
	}
	
	/**
	 * DOS 文件系统的文件属性管理
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @throws IOException
	 * @copyright 2017年7月26日上午11:50:21
	 */
	public static void DosFileAttributes(String file) throws IOException {
		Path path = Paths.get(file);
		
		DosFileAttributes da = Files.readAttributes(path, DosFileAttributes.class);

		System.out.println("dos filekey:"+da.fileKey());
	}
	
	/**
	 * posix系统文件属性
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午1:38:59
	 */
	public static void PosixFileAttributes(String file) throws IOException {
		Path path = Paths.get(file);
		
		java.nio.file.attribute.PosixFileAttributes pfa = Files.readAttributes(path, java.nio.file.attribute.PosixFileAttributes.class);
		
		System.out.println("group:"+pfa.group());
		System.out.println("owner:"+pfa.owner());
		System.out.println("permissions:"+PosixFilePermissions.toString(pfa.permissions()));
	}
	
	/**
	 * PosixFilePermissions操作
	 * 
	 * asFileAttribute返回一个set权限，可以应用到Paths.createFile或者Paths.createDirectory
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年7月26日下午1:40:45
	 */
	public static void PosixFilePermissionsAction() {
		Set<PosixFilePermission> fs = PosixFilePermissions.fromString("rw-r--r--");
		
		for(PosixFilePermission f : fs) {
			System.out.println(f.toString());
		}
		java.nio.file.attribute.FileAttribute<Set<PosixFilePermission>> fspfp = PosixFilePermissions.asFileAttribute(fs);
	}
	
	/**
	 * 设置拥有者
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午1:53:56
	 */
	public static void setOwner(String file) throws IOException {
		Path path = Paths.get(file);
		
		UserPrincipal owner = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("sally");
		//设置拥有者
		Files.setOwner(path, owner);
		
		GroupPrincipal group = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByGroupName("group");
	
		//设置群组
		Files.getFileAttributeView(path, PosixFileAttributeView.class)
			.setGroup(group);
	}
	
	/**
	 * 自定义属性
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException 
	 * @copyright 2017年7月26日下午4:33:09
	 */
	public static void userDefindAttributes(String file) throws IOException {
		//写入自定义属性
		Path path = Paths.get(file);
		
		UserDefinedFileAttributeView udfav = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
		
		udfav.write("user.mimetype", Charset.defaultCharset().encode("text/html"));
		
		//读取自定义属性
		String name = "user.mimetype";
		ByteBuffer dst = ByteBuffer.allocate(udfav.size(name));
		udfav.read("user.mimetype", dst);
		dst.flip();
		
		String value = Charset.defaultCharset().decode(dst).toString();
	}
	
	/**
	 * 获取文件系统空间
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午4:59:05
	 */
	public static void getFileStore(String file) throws IOException {
		Path path = Paths.get(file);
		
		FileStore fs = Files.getFileStore(path);
		
		System.out.println("total space:"+fs.getTotalSpace()/1024+"KB");
		System.out.println("used:"+(fs.getTotalSpace() - fs.getUnallocatedSpace()) / 1024+"KB");
		System.out.println("avail:"+fs.getUsableSpace()/1024+"KB");
		System.out.println("unallocate:"+fs.getUnallocatedSpace()/1024+"KB");
		System.out.println(fs.getTotalSpace()/1024/1024/1024+"G");
	}
	
	public static void main(String[] args) throws IOException {
		readBasicAttr("c");
		
		readAttr("c");
		
		setLastModifiedTime("1_c.txt");
		
		DosFileAttributes("1_c.txt");
		
//		PosixFileAttributes("1_c.txt");
		
		PosixFilePermissionsAction();
		
		getFileStore("1_c.txt");
		
		
	}
}
