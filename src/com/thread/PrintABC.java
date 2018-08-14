package com.thread;

public class PrintABC {

	public static void main(String[] args) throws InterruptedException {
		Object A = new Object();
		Object B = new Object();
		Object C = new Object();
		
		Print printA = new Print("A", C, A);
		Print printB = new Print("B", A, B);
		Print printC = new Print("C", B, C);
		
		new Thread(printA).start();
		Thread.sleep(500);
		new Thread(printB).start();
		Thread.sleep(500);
		new Thread(printC).start();
		Thread.sleep(500);
	}
	
	private static class Print implements Runnable{
		private String name;
		private Object pre;
		private Object self;
		private int count = 10;
		
		public Print(String name, Object pre, Object self) {
			this.name = name;
			this.pre = pre;
			this.self = self;
		}


		@Override
		public void run() {
			while(count > 0){
				synchronized (pre) {
					synchronized (self) {
						System.out.print(name);
						count--;
						self.notify();
					}
					try {
						if (count == 0) {
							return;
						} 
						pre.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
