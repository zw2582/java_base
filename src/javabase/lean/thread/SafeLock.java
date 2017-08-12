package javabase.lean.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用lock解死锁
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月7日下午5:49:21
 */
public class SafeLock {

	static class Friend {
		
		private String name;
		private final Lock lock = new ReentrantLock();
		
		public Friend(String name) {
			this.name = name;
		}
		
		/**
		 * 必须同时获取到自己的锁和盆友的锁
		 * @author wei.w.zhou.integle.com
		 * @param bower
		 * @return
		 * @copyright 2017年8月7日下午5:30:28
		 */
		public boolean getLock(Friend bower) {
			boolean myLock = false;
			boolean bowerLock = false;
			
			try {
				myLock = lock.tryLock();
				bowerLock = bower.lock.tryLock();
			} finally {
				if (!(myLock && bowerLock)) {
					if (myLock) {
						lock.unlock();
					}
					if (bowerLock) {
						bower.lock.unlock();
					}
				}
			}
			
			return myLock && bowerLock;
		}
		
		public void bower(Friend friend) {
			if (getLock(friend)) {
				try {
					System.out.println("i bower to :"+friend.name);
					friend.bowerBack();
				} finally {
					lock.unlock();
					friend.lock.unlock();
				}
			} else {
				System.out.println("等着");
			}
 			
		}
		
		public void bowerBack() {
			System.out.println(this.name+": bower back");
		}
	}
	
	static class loopLock implements Runnable {
		
		Friend friend1;
		Friend friend2;
		
		public loopLock(Friend friend1, Friend friend2) {
			this.friend1 = friend1;
			this.friend2 = friend2;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				friend1.bower(friend2);
			}
		}
	}
	
	public static void main(String[] args) {
		Friend caca = new Friend("caca1");
		Friend gogo = new Friend("gogo1");
		
		new Thread(new loopLock(caca, gogo)).start();
		new Thread(new loopLock(gogo, caca)).start();
	}
}
