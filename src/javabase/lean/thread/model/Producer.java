package javabase.lean.thread.model;

import java.util.Random;

public class Producer implements Runnable{

	private Drop dorp;
	
	public Producer(Drop drop) {
		this.dorp = drop;
	}

	@Override
	public void run() {
		String[] messageinfo = {
				"hello,machik",
				"i am kangkang",
				"do you remember me",
				"are you fine",
				"DONE"
		};
		
		Random random = new Random();
		
		for (int i =0; i< messageinfo.length; i++) {
			try {
				dorp.put(messageinfo[i]);
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
