package javabase.lean.classobj;

/**
 * 继承demo
 * @author wei.w.zhou.integle.com
 * @copyright 2017年9月30日下午2:58:52
 */
public class InheritsDemo {

	public String a = "a";
	
	public static String b = "b";
	
	private String c = "c";
	
	public void getA() {
		System.out.println(a);
	}
	
	public static void getB() {
		System.out.println(b);
	}
	
	class InnerDemo {
		
		public void go() {
			System.out.println(c);
			System.out.println("i am inner");
		}
	}
	
	static class Demo extends InheritsDemo {
		
		public void go() {
			System.out.println("go");
		}
		
		public static void getB() {
			System.out.println("bb");
		}
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.getB();
		demo.getA();
	}
}
