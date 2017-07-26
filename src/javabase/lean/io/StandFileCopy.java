package javabase.lean.io;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class StandFileCopy {

	public static void main(String[] args) {
		/**
		 * Files.copy复制文件或文件夹，如果文件已存在报错
		 * 文件夹复制只能复制文件夹，不能复制里面的内容
		 */
		try {
			Files.copy(Paths.get("a"), Paths.get("b"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Files.copy还可以复制软连接
		 * 默认只复制软连接内容，不复制软连接本身，也就是它的source不复制
		 * 要复制需要带上LinkOption.NOFOLLOW_LINKS
		 */
		try {
			Files.copy(Paths.get("c"), Paths.get("c2"), LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
