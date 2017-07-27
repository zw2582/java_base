package javabase.lean.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * 随机反问文件
 * http://docs.oracle.com/javase/tutorial/essential/io/rafs.html
 */
public class AccessRandomFile {

	public static void main(String[] args) throws IOException {
		String s = "i am here";
		ByteBuffer out = ByteBuffer.wrap(s.getBytes());
		
		ByteBuffer copy = ByteBuffer.allocate(12);
		
		String file = "1_w.txt";
		Path path = Paths.get(file);
		try(FileChannel fc = FileChannel.open(path, READ, WRITE)) {
			int nread;
			do {
				nread = fc.read(copy);
				System.out.println("nread:"+nread);
			} while(nread != -1 && copy.hasRemaining());
			
			fc.position(0);
			
			while(out.hasRemaining()) {
				System.out.println("write");
				fc.write(out);
			}
			
			long size = fc.size();
			fc.position(size-1);
			
			copy.flip();
			while(copy.hasRemaining())
				fc.write(copy);
			
			out.rewind();
			while(out.hasRemaining()) {
				fc.write(out);
			}
		}
		
	}
	
	public static void bufferTest() {
		ByteBuffer wrap = ByteBuffer.wrap("abcdefg".getBytes());
		
		System.out.println(Charset.defaultCharset().decode(wrap));
	}
}
