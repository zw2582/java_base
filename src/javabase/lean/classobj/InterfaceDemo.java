package javabase.lean.classobj;

public interface InterfaceDemo {

	/**
	 * 接口中所有域都是隐式public static final的，可忽略这些修饰符
	 */
	final String caca = "ca";
	
	String ca="ca";
	
	/**
	 * 升级接口
	 * 当需要增加新的功能时，如果直接增加，则所有已经继承的类需要修改，这样不好
	 * 解决：
	 * 1.可以建立default方法，或者static方法
	 * 2.新建接口extends该接口
	 */
	default void go() {
		System.out.println("caca");
	}
	
	static void ca() {
		System.out.println("ca");
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.go();
		InterfaceDemo.ca();
	}
	
	/**
	 * 实现类
	 */
	class Demo implements InterfaceDemo {
		
		public void go2() {
			ca();
			System.out.println("ggo");
		}
	}
	
}
