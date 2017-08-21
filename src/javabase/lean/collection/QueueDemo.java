package javabase.lean.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> q = new LinkedBlockingDeque<>(2);
		
		//超出边界时，offer返回false，add抛出异常
		System.out.println(q.offer("a"));
		System.out.println(q.offer("b"));
		System.out.println(q.offer("c"));
		System.out.println(q.offer("d"));
		
		System.out.println("remove:"+q.remove());
		
//		System.out.println(q.add("d"));
		
		//当队列为空时，poll返回null，remove抛出异常
		q.clear();
		System.out.println(q.poll());
//		System.out.println(q.remove());
		
		//当队列为空时，peek返回null，element抛出异常
		System.out.println(q.peek());
//		System.out.println(q.element());
		
	}
}
