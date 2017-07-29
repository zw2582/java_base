package javabase.lean.io;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class OtherMethod {

	public static void main(String[] args) throws IOException {
		Path file = Paths.get("D:\\workspace_php\\integle_ec\\www\\views\\shop\\index.php");

		//获取content-type
		String contentType = Files.probeContentType(file);
		
		System.out.format("%s 的content-type是%s%n", file.getFileName(), contentType);
		
		//获取路径分隔符
		System.out.println("路径分隔符:"+File.separator);
		System.out.println("路径分隔符:"+FileSystems.getDefault().getSeparator());
		
		//获取文件系统的文件存储
		System.out.println("获取文件系统的文件存储");
		Iterable<FileStore> fss = FileSystems.getDefault().getFileStores();
		for(FileStore fs : fss) {
			System.out.println(fs);
		}
		/*FileChannel fc = FileChannel.open(file);
		
		fc.position(fc.size());*/
		
	}
}
