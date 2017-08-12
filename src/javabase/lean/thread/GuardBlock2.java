package javabase.lean.thread;

import javabase.lean.thread.model.Customer;
import javabase.lean.thread.model.Drop;
import javabase.lean.thread.model.Producer;

/**
 * 利用守卫块，制作一个生产消费机制
 * 生产者生产消息，只有在消费者已读的情况下生产
 * 消费者获取消息，只有在生产着已生产之后才能获取
 * @author zhangjiao
 *
 */
public class GuardBlock2 {

	public static void main(String[] args) throws InterruptedException {
		Drop drop = new Drop();
		
		new Thread(new Customer(drop)).start();
		new Thread(new Customer(drop)).start();
		new Thread(new Customer(drop)).start();
		Thread.sleep(2000);
		
		new Thread(new Producer(drop)).start();
	}
}
