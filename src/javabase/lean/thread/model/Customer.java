package javabase.lean.thread.model;

public class Customer implements Runnable{
	
	private Drop dorp;
	
	public Customer(Drop drop) {
		this.dorp = drop;
	}

	@Override
	public void run() {
		String message = "";
		try {
			for(message = dorp.tack(); !message.equals("DONE"); message = dorp.tack()) {
				System.out.println("message:"+message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
