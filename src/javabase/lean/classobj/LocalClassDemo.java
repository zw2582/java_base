package javabase.lean.classobj;

import java.util.ArrayList;
import java.util.List;

public class LocalClassDemo {
	
	static String regularExpress = "abc";
	
	class innerClass {
		
		int innerA = 1;
		
		public void go() {
			System.out.println(innerA);
		}
		
		public void ca() {
			System.out.println("gdgd");
		}
	}
	
	/**
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年9月28日下午4:02:23
	 */
	public void go() {
		System.out.println(regularExpress);
	}
	
	int goca = 2;
	
	public static void goca() {
		int i = 1;
		System.out.println(regularExpress);
	}
	
	public void main() {
		
		//定义局部变量
		int phone = 4;
		List<String> a = new ArrayList<>();
		
		/**
		 * 定义在块中的内部类叫本地类
		 * 
		 * @author wei.w.zhou.integle.com
		 * @copyright 2017年9月28日下午2:21:24
		 */
		class PhoneNumber {
			
			//这叫遮蔽
			int phone = 5;
			
			static final String go="ca";
			
			public String toString() {
				int d= LocalClassDemo.this.goca;
				regularExpress = "sdf";
				
				//这叫遮蔽
				int phone = 7;
				
				//局部变量在封闭范围内访问必须是final或effectively final
				//phone = 5;
				
				a.add("caca");
				return "i am local class,phone:"+this.phone;
			}
			
			//本地类不可以定义静态成员
			/*public static void go() {
				System.out.println("caca");
			}*/
		}
		
		PhoneNumber pn = new PhoneNumber();
		System.out.println(pn);
	}
	
	public static void main(String[] args) {
		new LocalClassDemo().main();
	}
}
