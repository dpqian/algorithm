package com.BTree;

public class T {
	
	static class Node{
		int key;
		int value;
		Node left;
		Node right;
		
		public Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}
	
	Node root;
	
	public T(){
		this.root =null;
	}
	
	public void insert(int key,int value){
		Node newNode = new Node(key, value);
		
		if(root == null){
			root = newNode;
		} else {
			Node parent = root;
			Node current = root;
			while(true){
				parent = current;
				if(key < current.key){
					current = current.left;
					if(current == null){
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	public int get(int key){
		
		Node current = root;
		while(current != null){
			if(key == current.key){
				return current.value;
			} else if(key < current.key) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return -1;
	}
	
	public static void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.println(localRoot.value);
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public static void main(String[] args){
		T tree = new T();
		tree.insert(9, 99);
		tree.insert(2, 22);
		tree.insert(5, 55);
		tree.insert(1, 11);
		tree.insert(3, 33);
		tree.insert(7, 77);
		tree.insert(8, 88);
		
		//preOrder(tree.root);
		System.out.println(tree.get(7));
	}
}
