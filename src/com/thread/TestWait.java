package com.thread;

public class TestWait implements Runnable{
	private volatile static Object object1 = new Integer(0);

	public static void main(String[] args) throws InterruptedException {
		TestWait testWait = new TestWait();
		new Thread(testWait).start();
		Thread.sleep(3000);
		synchronized (object1) {
			object1.notify();
		}
	}

	@Override
	public void run() {
		while(true){
			synchronized (object1) {
				System.out.println("1");
				System.out.println("1");
				System.out.println("1");
				try {
					object1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("2");
				System.out.println("2");
				System.out.println("2");
			}
		}
	}

}
