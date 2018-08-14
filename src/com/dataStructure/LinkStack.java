package com.dataStructure;

public class LinkStack<E>{
	
	private Node head =null;
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public E peek(){
		if(isEmpty())
			return null;
		
		return (E) head.data;
	}
	
	public E pop(){
		E e = peek();
		
		if(e!=null){
			head = head.next;
		}
		return e;
	}

	public void push(E data){
		Node<E> temp = head;
		head = new Node<E>(data);
		head.next=temp;
		
	}
	public static void main(String[] args) {
		LinkStack<Integer> stack =new LinkStack<Integer>();
		for(int i=0;i<50;i++)
			stack.push(i);
		
		for(int i=0;i<50;i++)
		System.out.println(stack.pop());
	}
	
}

class Node<E>{
	Node<E> next = null;
	E data;
	
	public Node(E data){
		this.data = data;
	}
}