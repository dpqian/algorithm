package com.dataStructure;

public class SingleLinkedList {

	Node head = null;

	public class Node {

		//Node forward = null;
		Node next = null;
		int data;

		public Node(int data) {
			super();
			this.data = data;
		}

	}
	

	public void addNode(int i) {
		Node newNode = new Node(i);

		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
	}

	// 删除第index个节点
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}

		if (index == 1) {
			head = head.next;
			return true;
		}

		int i = 2;
		Node preNode = head;
		Node curNode = head.next;
		while (curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}

			i++;
			preNode = curNode;
			curNode = curNode.next;
		}
		return true;
	}

	// 链表长度
	public int length() {
		int len = 0;

		if (head == null)
			return 0;

		Node temp = head;
		len++;
		while (temp.next != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	// 排序，从小到大,返回头结点
	public Node sort() {
		int temp;
		Node curNode = head;
		Node nextNode = curNode.next;

		while (curNode != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data > nextNode.data) {
					temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}

	/**
	 * 删除链表中重复数据
	 */
	public void deleteDuplecate(Node head) {
		Node p = head;

		while (p != null) {
			Node q = p;
			while (q.next != null) {
				if (p.data == q.next.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			p = p.next;
		}
	}

	/**
	 * 找出链表中倒数第K个元素,只遍历一次
	 */
	public Node findNode(Node head, int k) {
		Node n1 = head;
		Node n2 = head;

		if (k < 1)
			return null;
		for (int i = 0; i < k - 1 && n2 != null; i++) {
			n2 = n2.next;
		}

		if (n2 == null) {
			System.out.println("k不合法");
			return null;
		}

		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	/**
	 * 链表反转,非递归
	 */
	public void reverseLinkedList(Node head) {
		Node curNode = head;
		Node preNode = null;
		Node nextNode = null;
		Node reverseHead = head;

		while (curNode != null) {
			nextNode = curNode.next;

			if (nextNode == null) {
				this.head = curNode;
			}
			curNode.next = preNode;
			preNode = curNode;
			//curNode = curNode.next;
			curNode = nextNode;
		}
	}
	
	/**
	 * 递归反向输出链表
	 */
	public void printListReversely(Node head){
		if(head!=null){
			printListReversely(head.next);
			System.out.println(head.data);
		}
	}
	
	/**
	 * 寻找单链表中间节点
	 */
	public Node SearchMid(Node head){
		Node p = head;
		Node q = head;
		
		while(q!=null&&q.next!=null&&q.next.next!=null){
			p=p.next;
			q=q.next.next;
		}
		
		return p;
	}
	
	/**
	 * 判断链表是否有环
	 */
	public boolean isLoop(Node head){
		Node fast = head;
		Node slow = head;
		
		if(fast == null){
			return false;
		}
		
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				return true;
		}
		return false;
	}
	
	/**
	 * 找出环入口点
	 */
	public Node findLoopEntry(Node head){
		Node slow = head;
		Node fast = head;
		
		if(fast==null)
			return null;
		
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				break;
			}
				
		}
		
		if(fast!=slow)
			return null;
		
		Node p = head;
		Node q =fast;
		while(q!=p){
			p=p.next;
			q=q.next;
		}
		return p;
	}
	
	/**
	 * 判断链表是否相交，若有找出交点
	 */
	public Node isIntersect(Node h1,Node h2){
		int len1=0,len2=0;
		Node head1=h1;
		Node head2=h2;
		if(h1==null||h2==null)
			return null;
		
		while(h1!=null){
			h1=h1.next;
			len1++;
		}
		
		while(h2!=null){
			h2=h2.next;
			len2++;
		}
		
		if(h1!=h2)
			return null;
		
	if(len1>=len2){
		int d =len1-len2;
		while(d!=0){
			head1=head1.next;
			d--;
		}
	}else{
		int d=len2-len1;
		while(d!=0){
			head2=head2.next;
			d--;
		}
	}
	
	while(head1!=head2){
		head1=head1.next;
		head2=head2.next;
	}
	return head1;
		
	}
	
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
