package javabase.lean.thread;

/**
 * 演示一个线程干扰异常
 * @author zhangjiao
 * 
 * 因为c++在java层不是原子操作，分为三部，1.取回c，2.增加c，3.返回c
 * 所有结果如下
 * 
 * Thread A: Retrieve c.
 * Thread B: Retrieve c.
 * Thread A: Increment retrieved value; result is 1.
 * Thread B: Decrement retrieved value; result is -1.
 * Thread A: Store result in c; c is now 1.
 * Thread B: Store result in c; c is now -1.
 *
 */
public class Counter {

	private int c = 0;
	
	public synchronized void increment() {
//		System.out.println("add");
		c++;
	}
	
	public synchronized void decrement() {
//		System.out.println("jian");
		c--;
	}
	
	public int getValue() {
		return c;
	}
	
	static class CounterRunner implements Runnable {
		
		private int index = 1;
		
		private Counter counter;
		
		private boolean add;
		
	    public CounterRunner(int index, Counter counter, boolean add) {
	    	this.index = index;
	    	this.counter = counter;
	    	this.add = add;
		}

		@Override
		public void run() {
			while(index-- > 0) {
				if (add)
					counter.increment();
				else 
					counter.decrement();
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					return;
//				}
				if (Thread.interrupted()) {
					return;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		Counter counter = new Counter();
		
		Thread t1 = new Thread(new CounterRunner(5000, counter, true));
		t1.start();
		Thread t2 = new Thread(new CounterRunner(5000, counter, false));
		t2.start();
		Thread t3 = new Thread(new CounterRunner(5000, counter, true));
		t3.start();
		Thread t4 = new Thread(new CounterRunner(5000, counter, false));
		t4.start();
		
//		Thread.sleep(1000);
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		long end = System.currentTimeMillis();
		System.out.println(counter.getValue());
		System.out.format("耗时：%d", (end - start));
	}
}
