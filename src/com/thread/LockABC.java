package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockABC {
	private static int count = 0;
	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		new Thread(new A()).start();
		new Thread(new B()).start();
		new Thread(new C()).start();
	}
	
	private static class A implements Runnable{

		@Override
		public void run() {
			while(count<30){
				if ( count % 3 == 0){
					lock.lock();
					System.out.print("A");
					count ++;
					lock.unlock();
				}
			}
		}
		
	}
	
	private static class B implements Runnable{

		@Override
		public void run() {
			while(count<30){
				if ( count % 3 == 1){
					lock.lock();
					System.out.print("B");
					count ++;
					lock.unlock();
				}
			}
		}
		
	}
	
	private static class C implements Runnable{

		@Override
		public void run() {
			while(count<30){
				if ( count % 3 == 2){
					lock.lock();
					System.out.print("C");
					count ++;
					lock.unlock();
				}
			}
		}
		
	}

}
