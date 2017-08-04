package javabase.lean.environment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * properties
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月4日下午5:31:15
 */
public class PropertiesTest1 {
	
	private static final String defaultProperties = "defaultProperties.properties";
	
	public static void main(String[] args) throws IOException {
//		storePros();
//		Properties props = readPros();
//		getSystemProps();
		
		try(InputStream in = Files.newInputStream(Paths.get(defaultProperties))) {
			System.getProperties().load(in);
			System.getProperties().list(System.out);
		}
		
	}
	
	/**
	 * 写入属性
	 * @author wei.w.zhou.integle.com
	 * @throws IOException
	 * @copyright 2017年8月4日下午4:25:23
	 */
	public static void storePros() throws IOException {
		Properties props = new Properties();
		props.setProperty("nihao", "哈哈你大爷饿");
		
		try(OutputStream out = 
				Files.newOutputStream(Paths.get(defaultProperties), 
						StandardOpenOption.APPEND)) {
			props.store(out, "你好");
		}
	}

	/**
	 * 读取属性
	 * @author wei.w.zhou.integle.com
	 * @throws IOException
	 * @copyright 2017年8月4日下午4:25:39
	 */
	public static Properties readPros() throws IOException {
		Properties defaultProps;
		try(InputStream in = 
				Files.newInputStream(Paths.get(defaultProperties))) {
			defaultProps = new Properties();
			defaultProps.load(in);
			
			Set<Entry<Object, Object>> entrySet = defaultProps.entrySet();
			for(Entry<Object, Object> entry : entrySet) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
		return defaultProps;
	}
	
	/**
	 * 获取系统属性
	 * @author wei.w.zhou.integle.com
	 * @return
	 * @copyright 2017年8月4日下午5:32:32
	 */
	public static Properties getSystemProps() {
		Properties properties = System.getProperties();
		
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		for(Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		return properties;
	}
	
	/**
	 * 属性的相关操作
	 * @author wei.w.zhou.integle.com
	 * @param props
	 * @copyright 2017年8月4日下午5:32:07
	 */
	public static void commomMethod(Properties props) {
		System.out.println("************show method******");
		System.out.println("contaner key:"+props.containsKey("caca"));
		System.out.println("contaner object:"+props.contains("gogo"));
		
		System.out.println("gogo :"+props.getProperty("gogo", "gogo is ca"));
		
		System.out.println("************list all props******");
		props.list(System.out);
		
		System.out.println("************props.elements******");
		for (Enumeration<Object> e = props.elements(); e.hasMoreElements();)
		       System.out.println(e.nextElement());
		
		System.out.println("************props.keys********");
		for (Enumeration<Object> e = props.keys(); e.hasMoreElements();)
			System.out.println(e.nextElement());
		
		System.out.println("************props.propertyNames********");
		for (Enumeration e = props.propertyNames(); e.hasMoreElements();)
			System.out.println(e.nextElement());
		
		System.out.println("************stringPropertyNames********");
		for(String e : props.stringPropertyNames()) {
			System.out.println(e);
		}
		
		System.out.println("size:"+props.size());
	}
}
