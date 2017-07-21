package javabase.lean.io;

public class TypeNote {

	/**
	 * 类型比较
	 * 包装类型值比较要用equals，==是类型比较，但是如果包装类型是0或者1的话，比较有效
	 * 方法返回类型比较，要用equals，==是比较方法的应用地址
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年7月20日下午3:16:08
	 */
	public static void main(String[] args) {
		TypeNote caca = new TypeNote();
		Integer i = 181;
		Integer a = 181;
		
		Short c = 181;
		
		boolean result = (getI() == 181);
		System.out.println(result);
		
		result = (i.equals(a));
		System.out.println(result);
		
		result = (i.equals(c));
		System.out.println(result);
	}
	
	public static Integer getI() {
		return 181;
	}
	
	public static Integer getA() {
		return 181;
	}

}
