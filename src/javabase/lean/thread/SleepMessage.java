package javabase.lean.thread;

/**
 * 测试睡眠和终止线程
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月29日下午6:29:12
 */
public class SleepMessage {

	public static void main(String[] args) throws InterruptedException {
		//启动一个线程
		Thread thread = new Thread(new Message());
		thread.start();
		
		//等待4秒后终止线程，条件是该线程支持终止
		thread.sleep(4000);
		thread.interrupt();
	}
	
	static class Message implements Runnable {

		@Override
		public void run() {
			while (true) {
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//接收到打断，终止进程
					return;
				}
				System.out.println(1);*/
				/**
				 * 接收到打断，终止进程,
				 * 如果不加这个操作，外面无法打断该线程，这样的线程叫做不支持终止线程
				 */
				if (Thread.interrupted()) {
					return ;
				}
			}
		}
		
	}
}
