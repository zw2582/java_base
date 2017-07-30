package javabase.lean.thread;
/**
 * 关于原子操作
 * @author zhangjiao
 *
 */
public class Count3 {

	private volatile int c = 0;
	
	public void incre() {
		c++;
	}
	
	public void getValue() {
		c++;
		System.out.println(c);
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
					count.incre();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Count3 count = new Count3();
		int index = 1000;
		new Thread(new CountRunner(count, true, index)).start();
		new Thread(new CountRunner(count, true, index)).start();
	}
}
