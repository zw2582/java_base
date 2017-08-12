package javabase.lean.thread;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用原子变量避免线程干扰
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月12日下午1:48:52
 */
public class AtomicCounter {

	private AtomicInteger i = new AtomicInteger(0);
	
	public void add() {
		i.incrementAndGet();
	}
	
	public void dec() {
		i.decrementAndGet();
	}
}
