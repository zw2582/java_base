package javabase.lean.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 使用blockingQueue代替GuardBlock2的代码
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月12日下午2:40:33
 */
public class GuardBlock3 {
	
	/**
	 * 定义生产者
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月12日下午2:32:30
	 */
	static class producter implements Runnable{
		
		private BlockingQueue<String> message;

		public producter(BlockingQueue<String> message) {
			super();
			this.message = message;
		}
		
		private String[] messageinfo = {"hello", "are you ok?","you are buzy", "DONE"};

		@Override
		public void run() {
			for (String m : messageinfo) {
				try {
					message.put(m);
					System.out.println("i put success");
//					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 消费端
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月12日下午2:34:45
	 */
	static class Customer implements Runnable {
		
		private BlockingQueue<String> message;
		
		public Customer(BlockingQueue<String> message) {
			super();
			this.message = message;
		}

		@Override
		public void run() {
			String m = null;
			try {
				Thread.sleep(4000);
				for(m = message.take(); !m.equals("DONE"); m = message.take()) {
					System.out.println(m);
					Thread.sleep(4000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		BlockingQueue<String> message = new LinkedBlockingDeque<>(1);
		
		new Thread(new producter(message)).start();
		new Thread(new Customer(message)).start();
	}
}
