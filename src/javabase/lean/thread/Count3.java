package javabase.lean.thread;
/**
 * 关于原子操作
 * @author zhangjiao
 *
 */
public class Count3 {

	private volatile int c = 0;
	
	public synchronized void incre() {
		try {
			int a = c;
			Thread.sleep(100);
			a = a + 1;
			Thread.sleep(100);
			c = a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void getValue() {
		try {
			int a = c;
			Thread.sleep(100);
			a = a - 1;
			Thread.sleep(100);
			c = a;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class CountRunner implements Runnable {
		
		private Count3 count;
		
		private boolean get;
		
		private int index;
		
		public CountRunner(Count3 count, boolean get, int index) {
			this.count = count;
			this.get = get;
			this.index = index;
		}

		@Override
		public void run() {
			while (index-- > 0) {
				if (get) {
					this.count.getValue();
				} else {
					this.count.incre();
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Count3 count = new Count3();
		int index = 5;
		Thread t1 = new Thread(new CountRunner(count, true, index));
		Thread t2 = new Thread(new CountRunner(count, false, index));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(count.c);
	}
}
