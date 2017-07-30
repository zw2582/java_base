package javabase.lean.thread;

public class Count2 {

	private int c1 = 0;
	private int c2 = 0;
	
	private Object c1o = new Object();
	private Object c2o = new Object();
	
	/**
	 * 如果直接用synchronized修饰方法，会让incrC1和incrC2的并发降低，事实上它们是可以并发的
	 * 所以使用synchronize statemnet
	 * 每一个对象都隐藏着一个内部锁
	 */
	public void incrC1() {
		synchronized (c1o) {
			c1++;
		}
	}
	
	public void incrC2() {
		synchronized (c2o) {
			c2++;
		}
	}
}
