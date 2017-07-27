package javabase.lean.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 读、写、创建文件
 * 
 * @see http://docs.oracle.com/javase/tutorial/essential/io/file.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月26日下午5:14:20
 */
public class ReadWriteAndCreate {

	/**
	 * 对于小文件的常见操作
	 * @author wei.w.zhou.integle.com
	 * @throws IOException 
	 * @copyright 2017年7月26日下午5:14:03
	 */
	public static void commonForSmall(String file) throws IOException {
		Path path = Paths.get(file);
		//字节读
		byte[] allbytes = Files.readAllBytes(path);
		
		//字节写
		Files.write(path, allbytes, StandardOpenOption.WRITE);
		
		//字符读
		List<String> alllines = Files.readAllLines(path);
		for(String line : alllines) {
			System.out.println(line);
		}
		
		//字符写
		Files.write(path, "你大爷的".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		
	}
	
	/**
	 * newBufferedReader读取文件，适合文本文件
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午5:38:42
	 */
	public static void bufferedRead(String file) throws IOException {
		
		Path path = Paths.get(file);
		
		Charset cs = Charset.forName("UTF-8");
		
		try(BufferedReader nbr = Files.newBufferedReader(path, cs)){
			String line = null;
			while ((line = nbr.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
	
	/**
	 * buffered写
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午5:42:36
	 */
	public static void bufferedWrite(String file) throws IOException {
		Path path = Paths.get(file);
		
		Charset cs = Charset.forName("UTF-8");
		
		try(BufferedWriter nbw = Files.newBufferedWriter(path, cs, StandardOpenOption.APPEND)) {
			nbw.write("你们好，我是你们的兄弟");
		} 
	}
	
	/**
	 * 无缓冲流的read，其实就是Files.newBufferedRead()的实现
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException 
	 * @copyright 2017年7月26日下午5:56:54
	 */
	public static void inputStreamRead(String file) throws IOException {
		Path path = Paths.get(file);
		
		try(InputStream nis = Files.newInputStream(path)) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(nis));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
	
	/**
	 * 无缓冲写入
	 * @author wei.w.zhou.integle.com
	 * @param file
	 * @throws IOException
	 * @copyright 2017年7月26日下午6:04:42
	 */
	public static void outputStreamWriter(String file) throws IOException {
		Path path = Paths.get(file);
		
		try(BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.APPEND))){
			bos.write("你他大爷的过来呀".getBytes());
		}
	}
	
	/**
	 * 使用channel读取数据
	 * @param file
	 * @throws IOException
	 */
	public static void ChannelRead(String file) throws IOException {
		//定义路径
		Path path = Paths.get(file);
		
		//开启通道，默认是reading
		try(SeekableByteChannel bchannel = Files.newByteChannel(path)) {
			
			//定义byteBuffer
			ByteBuffer allocate = ByteBuffer.allocate(10);
			//读取数据
			while(bchannel.read(allocate) > 0) {
				allocate.flip();
				System.out.println(Charset.defaultCharset().decode(allocate));
				allocate.rewind();
			}
		}
	}
	
	public static void channelWrite(String file) throws IOException {
		//制作文件路径
		Path path = Paths.get(file);
		
		//编辑文件操作模式
		Set<OpenOption> options = new HashSet<>();
		options.add(StandardOpenOption.APPEND);
		options.add(StandardOpenOption.CREATE);
		
		//编辑文件权限
		Set<PosixFilePermission> fs = PosixFilePermissions.fromString("rw-r-----");
		FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(fs);

		//编辑写入数据
		String data = "我是中国人，我爱自己的祖国";
		ByteBuffer byteBuffer = Charset.defaultCharset().encode(data);
		
		//开启通道，写入数据
		try(SeekableByteChannel sbc = Files.newByteChannel(path, options, attrs)) {
			sbc.write(byteBuffer);
		}
	}
	
	/**
	 * 创建文件，如果文件已存在，抛出错误
	 * 可以使用newOutputStream创建文件
	 * @param file
	 * @throws IOException 
	 */
	public static void createFile(String file) throws IOException {
		Path createFile = Files.createFile(Paths.get(file));
	}
	
	/**
	 * 创建临时文件
	 * @throws IOException
	 */
	public static void createTmpFile() throws IOException {
		Path ctf = Files.createTempFile("d", ".myapp");
		
		System.out.println(ctf.toAbsolutePath());
		
		Files.createTempFile(Paths.get("."), "d", ".myapp");
	}
	
	public static void main(String[] args) throws IOException {
//		commonForSmall("1_c.txt");
//		bufferedRead("1_w.txt");
//		bufferedWrite("1_w.txt");
//		outputStreamWriter("1_w.txt");
		ChannelRead("1_channel.txt");
		
//		channelWrite("1_channel.txt");
//		File file = new File("cac.txt");
//		createFile("create.txt");
//		createTmpFile();
		
	}
}
