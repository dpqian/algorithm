package com.thread;

import javax.net.ssl.ExtendedSSLSession;

public class SyncABC {
	private static int count = 0;
	private static Object object = new Object();

	public static void main(String[] args) {
		new A().start();
		new B().start();
		new C().start();
	}
	
	private static class A extends Thread{
		public void run(){
			while(count < 30){
				if (count % 3 == 0){
					synchronized (object) {
						System.out.print("A");
						count ++;
						object.notifyAll();
						try {
							object.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	private static class B extends Thread{
		public void run(){
			while(count < 30){
				if (count % 3 == 1){
					synchronized (object) {
						System.out.print("B");
						count ++;
						object.notifyAll();
						try {
							object.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	private static class C extends Thread{
		public void run(){
			while(count < 30){
				if (count % 3 == 2){
					synchronized (object) {
						System.out.print("C");
						count ++;
						object.notifyAll();
						try {
							object.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
