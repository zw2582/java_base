package javabase.lean.classobj;

import java.util.Arrays;

/**
 * Object的继承操作
 * @author zhangjiao
 *
 */
public class ObjDemo {
	
	private int id;
	
	private String name;
	
	private long date;
	
	public static String publicName;
	
	public final int publicId=12;
	
	protected long publicDate;

	static class Cat implements Cloneable{
		private int id;
		
		private String name;
		
		protected native void ca();
		
		public static void main(String[] args) throws CloneNotSupportedException {
			Cat cat = new Cat();
			//1.clone方法必须实现Cloneable接口
			Object clone = cat.clone();
		}
	}
	
	/**
	 * 当对象变为垃圾的时候调用，但它的调用是不确定的
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("ObjDemo cleaned");
	}
	
	public void getClass(int i) {
		System.out.println("caca");
	}
	
	public static void main(String[] args) throws Throwable {
		ObjDemo objDemo = new ObjDemo();
		
		//object默认的equals是使用＝＝运算符判断的
		objDemo.equals(null);
		
		objDemo.finalize();
		
		//getClass返回一个Class对象，可以通过它获取到该对象的类信息，getClass不能被重写
		Class<? extends ObjDemo> objDemoCla = objDemo.getClass();
		//1.获取类名
		System.out.println("class name:"+objDemoCla.getName());
		//2.获取类的公有fields
		System.out.println(Arrays.asList(objDemoCla.getFields()));
		//3.获取类的公有方法
		System.out.println(Arrays.asList(objDemoCla.getMethods()));
		
		//hashcode是一个对象的哈西吗，它是对象的十六进制内存地址
		String a = new String("a");
		String b = new String("a");
		System.out.println("hashcode is equals:"+(a.hashCode() == b.hashCode()));
		System.out.println("equals method:"+(a.equals(b)));
		System.out.println("==opreator:"+(a==b));
	}
}
