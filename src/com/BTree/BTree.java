package com.BTree;

import java.util.LinkedList;
import java.util.Queue;

public class BTree {
	private Node root;

	public BTree() {
		root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent =current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public void buildTree(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}
	}
	
	//中序遍历
	public void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.left);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.right);
		}
	}
	
	public void inOrder(){
		inOrder(root);
	}
	
	//先序遍历
	public void preOrder(Node localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.data);
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	
	public void preOrder(){
		this.preOrder(root);
	}
	
	//后序遍历
	public void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data);
		}
	}
	
	public void postOrder(){
		postOrder(root);
	}
	
	//层序遍历
	public void layerOrder(){
		Queue<Node> queue = new LinkedList<>();
		if(root!=null){
			queue.add(root);
		}
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.print(node.data+" ");
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
		}
	}
	
	//查找
	public void search(int data){
		
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 8, 7, 4, 9, 3, 1, 6, 7, 5 };
		BTree bTree = new BTree();
		bTree.buildTree(arr);
		bTree.inOrder();
		System.out.println();
		bTree.preOrder();//2187436579
		System.out.println();
		bTree.postOrder();
		System.out.println();
		bTree.layerOrder();
	}

	private static class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
