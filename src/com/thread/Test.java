package com.thread;

import javax.net.ssl.SSLException;

public abstract class Test {
	static int count = 30;

	public static void main(String[] args) throws InterruptedException {
		Object A = new Object();
		Object B = new Object();
		Object C = new Object();
		
		new Thread(new print(C, A, "A")).start();
		Thread.sleep(500);
		new Thread(new print(A, B, "B")).start();
		Thread.sleep(500);
		new Thread(new print(B, C, "C")).start();
	}
	
	private static class print implements Runnable{
		private Object pre;
		private Object self;
		private String name;
		
		public print(Object pre, Object self, String name) {
			super();
			this.pre = pre;
			this.self = self;
			this.name = name;
		}

		public void run(){
			while(count>0){
				synchronized (pre) {
					synchronized (self) {
						System.out.print(name);
						count--;
						self.notify();
					}
					if(count == 1)
						return;
					try {
						pre.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
