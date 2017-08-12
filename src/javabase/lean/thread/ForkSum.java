package javabase.lean.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * fork/join框架将任务切分为更小的任务，提高应用性能
 * 1.定义任务ForkJoinTask
 * 2.实现切分逻辑
 * 3.定义ForkJoinPool执行器
 * 4.执行任务pool.invoke()
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月12日下午1:11:22
 */
public class ForkSum extends RecursiveAction{
	
	private int[] src;
	
	private int start;
	
	private int length;
	
	private int[] des;
	
	public ForkSum(int[] src, int start, int length, int[] des) {
		super();
		this.src = src;
		this.start = start;
		this.length = length;
		this.des = des;
	}
	
	/**
	 * 执行逻辑
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月12日下午1:10:39
	 */
	public void myCompute() {
		for(int i = start; i < start+length; i++) {
			des[i] = src[i];
		}
	}

	private int limit = 1000;

	@Override
	protected void compute() {
		//切分任务
		if (length <= limit) {
			myCompute();
		} else {
			int split = length / 2;
			invokeAll(new ForkSum(src, start, split, des), 
					new ForkSum(src, start+split, length - split, des));
		}
	}
	
	public static void main(String[] args) {
		int[] src = new int[1000];
		int[] des = new int[1000];
		
		for (int i = 0; i< 1000; i++) {
			src[i] = i;
		}
		
		long startTime = System.currentTimeMillis();
		
		//执行fork/join任务
		ForkSum forkSum = new ForkSum(src, 0, src.length, des);
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(forkSum);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		System.out.println(des[899]);
	}

}
