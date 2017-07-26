package javabase.lean.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 移动文件
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月26日上午11:05:21
 */
public class MoveFiles {

	public static void main(String[] args) {
		/**
		 * Files.move()
		 * 移动文件或者目录
		 */
		try {
			Files.move(Paths.get("aa"), Paths.get("b/aa1"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
