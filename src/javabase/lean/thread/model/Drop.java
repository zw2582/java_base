package javabase.lean.thread.model;

public class Drop {

	private String message;
	
	private boolean empty = true;
	
	/**
	 * 生产者生产消息，当消息不为空时，等待消费者读取后，生产消息，随后激活消费者等待线程
	 * @param message
	 * @throws InterruptedException
	 */
	public synchronized void put(String message) throws InterruptedException {
		while(!empty) {
			wait();
		}
		this.message = message;
		empty = false;
		notifyAll();
	}
	
	/**
	 * 消费者获取消息，如果消息为空，则等待直到消息存在后获取消息，获取完毕后，激活生产者等待线程
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized String tack() throws InterruptedException {
		while(empty) {
			wait();
		}
		empty = true;
		notifyAll();
		return message;
	}
}
