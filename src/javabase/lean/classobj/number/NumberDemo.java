package javabase.lean.classobj.number;

import org.junit.Test;

public class NumberDemo {

	//使用包装类的情景：1.作为类常量
	public final Integer a = 1;
	
	private int b ;
	
	//使用包装类的情景：2.作为方法参数
	public void setB(Integer b) {
		this.b = b;
	}
	
	@Test
	//使用包装类的情景：3.使用类方法将值转换为其他原始类型
	public void typeConvert() {
		float floatA = a.floatValue();
		byte byteA = a.byteValue();
		double doubleA = a.doubleValue();
		long longA = a.longValue();
		Short shortA = a.shortValue();
		double doubleShortA = shortA.doubleValue();
		System.out.println(byteA);
		System.out.println(doubleShortA);
	}
	
	@Test
	//使用Number类方法互相比较
	public void typeCompare() {
		Integer i = 120;
		Integer ii = 2147483647;
		Byte b = 127;
		Short s = 3;
		Long l = 5l;
		Float f = 10f;
		Double d = 9.0002d;
		
		System.out.println(i.compareTo(ii));
		System.out.println(b.compareTo(new Byte((byte) 6)));
		System.out.println(Integer.MAX_VALUE);
	}
	
	//Number类的相等判断
	@Test
	public void typeEqual() {
		Integer i = 120;
		Integer ia = 120;
		Short s = 120;
		//equals:类方法，用于判断number类的类型一样且具有相同的数值
		System.out.println("Integer equals Short:"+(i.equals(s)));
		
		//==:操作符，用于判断变量存储的值是否相等,包装类型必须相同，否则抛出异常
		int ii = 20;
		double ss = 20.000;
		System.out.println("int == short:"+(ii == ss));
		System.out.println("Integer == Integer:"+(i == ia));
		
		//使用包装类定义数字时，Double需要加D，Float需要加f，Long需要加l，原始变量不需要
		long ll = 23;
		Long l = 23l;
	}
}
