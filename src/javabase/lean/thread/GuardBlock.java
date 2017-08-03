package javabase.lean.thread;

import javabase.lean.thread.model.GuardBlockObj1;

/**
 * 守卫锁
 * @author zhangjiao
 *
 */
public class GuardBlock implements Runnable{
	
	private GuardBlockObj1 obj1;
	private boolean set = false;
	
	public GuardBlock(GuardBlockObj1 obj1, boolean set) {
		this.obj1 = obj1;
		this.set = set;
	}

	public static void main(String[] args) throws InterruptedException {
		GuardBlockObj1 obj1 = new GuardBlockObj1();
		
		Thread t1 = new Thread(new GuardBlock(obj1, false));
		t1.start();
		Thread t3 = new Thread(new GuardBlock(obj1, false));
		t3.start();
		
		t1.join(1000);
		Thread t2 = new Thread(new GuardBlock(obj1, true));
		t2.start();
		
//		t1.interrupt();
	}

	@Override
	public void run() {
		if (set) {
			obj1.set();
		} else {
			obj1.go();
		}
	}
}
