package javabase.lean.thread.model;

public class GuardBlockObj1 {

	public boolean d = false;
	
	public void set() {
		System.out.println(Thread.currentThread().getName()+":set d is true");
		synchronized (this) {
			d = true;
			notifyAll();
		}
	}
	
	public void go() {
		System.out.println(Thread.currentThread().getName()+":准备执行go");
		synchronized (this) {
			while(!d) {
				try {
					System.out.println(Thread.currentThread().getName()+":获取到锁，进入循环等待");
					wait();
					System.out.println("1");
				} catch (InterruptedException e) {
					return ;
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+":执行go");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":执行go完成");
	}
}
