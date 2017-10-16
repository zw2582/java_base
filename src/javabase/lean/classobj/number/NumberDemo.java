package javabase.lean.classobj.number;

import java.rmi.registry.LocateRegistry;
import java.util.Calendar;
import java.util.Locale;

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
		
		float z = 23.12f;
		Float zz = 23.23f;
		
		double d = 23.23;
		Double dd = 23.23;
	}
	
	/**
	 * Integer特有的方法
	 */
	@Test
	public void IntegerMethod() {
		//Integer.decode:将字符串解析成整形
		//可接受十进制，八进制，十六进制的字符串表示，其他的抛出运行时错误
		Integer decodeval = Integer.decode("023");
		System.out.println("'023'被Integer.decode后＝"+decodeval);
		
		Integer decodeval2 = Integer.decode("0x23");
		System.out.println("'0x23'被Integer.decode后＝"+decodeval2);
		
		//Integer.parseInt:用不用的进制解析字符串为整数，抛出运行时异常
		int parseInt2 = Integer.parseInt("1001101010011111", 2);
		int parseInt8 = Integer.parseInt("23", 8);
		int parseInt10 = Integer.parseInt("50");
		int parseInt16 = Integer.parseInt("23", 16);
		System.out.format("int2:%d,int8:%d,int10:%d,int16:%d", parseInt2, 
				parseInt8, parseInt10, parseInt16);
		System.out.println();
		
		//Integer.valueOf与Integer.parseInt相似，只不过返回的是包装类型，且可以接受整形原始类型
		Integer value10 = Integer.valueOf("50");
		Integer v = Integer.valueOf(23);
		Integer value16 = Integer.valueOf("23", 16);
		System.out.format("int10:%d,v:%d,int16:%d", value10, 
				v, value16);
		
	}
	
	/**
	 * 数字格式化输出
	 */
	@Test
	public void numberFormat() {
		int i = 1324243;
		
		/**
		 * 010:总长度至少10个长度，不足用0占位
		 * －：表示左对齐
		 * ，：表示科学计数
		 * .3：表示3个小数点
		 */
		System.out.format("%d%n", i);
		System.out.format("%-8d%n", i);
		System.out.format("%08d%n", i);
		System.out.format("%0+10d%n", i);
		System.out.format("%,010d%n", i);
		
		double pi = Math.PI;
		System.out.format("%f%n", pi);
		System.out.format("%10.3f%n", pi);
		System.out.format("%-10.4f%n", pi);
		System.out.format("%010.3f%n", pi);
		System.out.format("%+,.7f%n", pi);
		System.out.format(Locale.FRANCE, "%.5f%n", pi);
		
		Calendar c = Calendar.getInstance();
		//日期表示
		System.out.format("%tY-%tm-%td %tl:%tM", c, c, c, c, c);
	}
	
	/**
	 * Math类的测试
	 */
	@Test
	public void mathTest() {
		int i = -12;
		
		float a = 23.85f;
		
		System.out.format("Math.abs:返回绝对值，%d%n", Math.abs(i));
		System.out.format("Math.ceil:返回大于当前值的最小整数，%.0f%n", Math.ceil(a));
		System.out.format("Math.floor：小于当前值的最大整数，%.0f%n", Math.floor(a));
		System.out.format("Math.rint:四舍五入当前值的整数，%.0f%n", Math.rint(a));
		System.out.format("Math.round:四舍五入当前值的整数，%d%n", Math.round(a));
		
		//0.0<= x < 1.0的随机数
		double random = Math.random();
	}
}
