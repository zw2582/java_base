package javabase.lean.classobj;

import java.util.Iterator;

/**
 * 内部类的使用
 * http://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年9月26日下午7:48:30
 */
public class DataStruct {

	private static final Integer SIZE = 14;
	
	private Integer[] data = initData();
	
	protected final Integer[] initData() {
		Integer[] d = new Integer[SIZE];
		for (int i = 0; i < SIZE ;i ++) {
			d[i] = i;
		}
		return d;
	}
	
	/**
	 * 利用自定义遍历器遍历数组
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年9月26日下午7:57:17
	 */
	public void printEven() {
		DataStructIterator dsi = new DataStructIterator();
		while (dsi.hasNext()) {
			System.out.println(dsi.next());
		}
	}
	
	/**
	 * 内部类迭代器
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年9月26日下午7:56:05
	 */
	private class DataStructIterator implements Iterator<Integer> {
		
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < SIZE;
		}

		@Override
		public Integer next() {
			Integer inext = data[index];
			index+=2;
			
			return inext;
		}
		
	}
	
	/*
	 * 程序入口测试
	 */
	public static void main(String[] args) {
		DataStruct ds = new DataStruct();
		ds.printEven();
	}
}
