package javabase.lean.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question {

	public static void main(String[] args) throws IOException {
		//统计字符出现的次数
		System.out.println(totalCount("xanadu.txt", 'e'));
		
	}
	
	/**
	 * 统计字符出现的次数
	 * @author wei.w.zhou.integle.com
	 * @param uri
	 * @param a
	 * @return
	 * @throws IOException
	 * @copyright 2017年7月29日下午3:01:36
	 */
	public static int totalCount(String uri, char a) throws IOException {
		Path path = Paths.get(uri);
		
		int count = 0;
		try(BufferedReader br = Files.newBufferedReader(path)) {
			String line = null;
			
			while((line = br.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == a) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
