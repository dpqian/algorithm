package com.dataStructure;

import com.dataStructure.SingleLinkedList.Node;

public class App {

	public static void main(String[] args) {
		
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		//list.printList();
		
		Node head = list.head;
		
		System.out.println();
		
		/*
		list.deleteDuplecate(list.head);
		list.printList();
		*/
		
		//System.out.println(list.findNode(list.head,5).data);
		
		//list.reverseLinkedList(list.head);
		//list.printList();
		
		//list.printListReversely(head);
		
		//¡¥±Ìª∑≤‚ ‘
		list.head.next.next.next.next.next.next=list.head.next.next;
		Node entry=list.findLoopEntry(list.head);
		//list.printList();
		System.out.println(entry.data);
	}

}
