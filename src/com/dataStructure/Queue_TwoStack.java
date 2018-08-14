package com.dataStructure;

import java.io.PipedInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Queue_TwoStack<E> {
	
	Stack<E> inStack =new Stack<E>();
	Stack<E> outStack = new Stack<E>();
	
	public Queue_TwoStack(){
		inStack = new Stack<E>();
		outStack = new Stack<E>();
	}
	
	public boolean isEmpty(){
		return inStack.isEmpty()&&outStack.isEmpty();
	}
	
	public synchronized void put(E data){
		inStack.push(data);
	}
	
	public synchronized E pop(){
		if(!outStack.isEmpty())
			return outStack.pop();
		while(!inStack.isEmpty()){
			outStack.push(inStack.pop());
		}
		return outStack.pop();
	}

	public static void main(String[] args) {
		Queue_TwoStack<Integer> queue = new Queue_TwoStack<Integer>();
		for(int i=0;i<10;i++)
			queue.put(i);
		while(!queue.isEmpty())
			System.out.println(queue.pop());
		
		int[] a = {1,2,3,4,5};
		int[] b =new int[5];
		System.arraycopy(a, 1, a, 0, 4);
		System.out.println(Arrays.toString(a));
	}

}
