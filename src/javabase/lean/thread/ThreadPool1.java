package javabase.lean.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool1 {

	public static void main(String[] args) {
		/**
		 * return new ThreadPoolExecutor(nThreads, nThreads,
         *                             0L, TimeUnit.MILLISECONDS,
         *                             new LinkedBlockingQueue<Runnable>());
		 */
		ExecutorService ftp = Executors.newFixedThreadPool(5);
		
		/**
		 * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                             60L, TimeUnit.SECONDS,
         *                             new SynchronousQueue<Runnable>());
		 */
		ExecutorService ctp = Executors.newCachedThreadPool();
	}
}
