package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	public static void main(String[] args) {
		ExecutorService pool1 = Executors.newFixedThreadPool(2);
		//ExecutorService pool1 = Executors.newSingleThreadExecutor();
		TestThread t1 = new TestThread(1);
		TestThread t2 = new TestThread(2);
		TestThread t3 = new TestThread(3);
		TestThread t4 = new TestThread(4);
		TestThread t5 = new TestThread(5);
		pool1.submit(t1);
		pool1.submit(t2);
		pool1.submit(t3);
		pool1.submit(t4);
		pool1.submit(t3);
		pool1.submit(t4);
		pool1.submit(t3);
		pool1.submit(t4);
	}
	
	static class TestThread extends Thread{
		private int name;
		public TestThread(int name){
			this.name = name;
		}
		public void run(){
			while(true)
			System.out.println(name);
		}
	}

}
