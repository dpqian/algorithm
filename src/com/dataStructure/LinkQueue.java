package com.dataStructure;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkQueue<E> {
	private Node<E> head = null;
	private Node<E> tail =null;
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void put(E data){
		Node<E> node = new Node<E>(data);
		if(head==null)
			head=tail=node;
		tail.next=node;
		tail=node;
	}
	
	public E pop(){
		if(head==null)
			return null;
		E data = head.data;
		head=head.next;
		return data;
	}
	
	public int size(){
		int size = 0;
		Node node =head;
		while(node!=null){
			size++;
			node=node.next;
		}
		return size;
	}
	
	public static void main(String[] args) {
		LinkQueue<Integer> queue = new LinkQueue<Integer>();
		for(int i=0;i<10;i++)
			queue.put(i);
		System.out.println("队列长度为"+queue.size());
		while(!queue.isEmpty())
			System.out.println(queue.pop());
		System.out.println("队列长度为"+queue.size());
	}

}


