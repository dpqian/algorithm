package com.dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<E> {
	
	private Object[] arr = null;
	private int size;
	private int front;
	
	public ArrayQueue(){
		arr = new Object[10];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void ensureCapasity(int size){
		if(size>arr.length){
			int newLength = 10;
			arr = Arrays.copyOf(arr, arr.length+newLength);
		}
	}
	
	public void push(E data){
		ensureCapasity(size+1);
		arr[size++]=data;
	}
	
	public E peek(){
		if(isEmpty())
			return null;
		return (E)arr[0];
	}
	
	public E pop(){
		//E data = peek();
		size--;
		return (E) arr[front++];
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> q= new ArrayQueue<Integer>();
		for(int i=0;i<30;i++)
			q.push(i);
		while(!q.isEmpty())
			System.out.println(q.pop());
	}

}
