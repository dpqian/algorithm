package com.dataStructure;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Stack_TwoQueue<E> {

	private ConcurrentLinkedQueue<E> inQueue;
	private ConcurrentLinkedQueue<E> outQueue;

	public Stack_TwoQueue() {
		inQueue = new ConcurrentLinkedQueue<E>();
		outQueue = new ConcurrentLinkedQueue<E>();
	}

	public boolean isEmpty() {
		synchronized (inQueue) {
			return inQueue.isEmpty();
		}
	}

	public void put(E data) {
		synchronized (inQueue) {
			inQueue.add(data);
		}
	}

	public E pop() {
		synchronized (inQueue) {
			while (inQueue.size() > 1) {
				outQueue.add(inQueue.poll());
			}
			E data = inQueue.poll();
			while (outQueue.size() > 0) {
				inQueue.add(outQueue.poll());
			}
			return data;
		}
	}

	public int size() {
		synchronized (inQueue) {
			return inQueue.size();
		}
	}

	public static void main(String[] args) {
		Stack_TwoQueue<Integer> queue = new Stack_TwoQueue<Integer>();
		for (int i = 0; i < 10; i++)
			queue.put(i);
		while (queue.size() > 0)
			System.out.println(queue.pop());
	}

}
