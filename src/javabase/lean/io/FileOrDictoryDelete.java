package javabase.lean.io;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * 文件或者目录删除
 */
public class FileOrDictoryDelete {

	public static void main(String[] args) {
		/**
		 * 可以删除文件，目录和软连接，删除软连接不会删除目标，删除的目录必须是空的
		 */
		
		/**
		 * Files.delete(Path)
		 */
		try {
			Files.delete(Paths.get("del.txt"));
		} catch (NoSuchFileException e) {
			System.out.println("no such file or directory");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("directory not empty");
		} catch (IOException e) {
			System.out.println("file or directory cannot access");
		}
		
		/**
		 * deleteIfExists
		 */
		System.out.println("deleteIfExists delete file");
		try {
			Files.deleteIfExists(Paths.get("del.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
