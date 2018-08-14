package com.dataStructure;

import java.util.Arrays;

public class MyStack<E> {
	private Object[] stack;
	private int size;

	public MyStack() {
		stack = new Object[10];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E peek() {
		if (isEmpty())
			return null;
		return (E) stack[size - 1];
	}

	public E pop() {
		E e = peek();
		if (e != null) {
			stack[size - 1] = null;
			size--;
		}
		return e;
	}

	public void push(E e) {
		ensureCapacity(size+1);
		stack[size] = e;
		size++;
	}

	private void ensureCapacity(int size) {
		int len = stack.length;
		int newLength = 10;
		if (size > len) {
			stack = Arrays.copyOf(stack, len+newLength);
		}
	}

	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<Integer>();
		for (int i = 0; i < 50; i++)
			s.push(i);
		System.out.println(s);
	}
}
