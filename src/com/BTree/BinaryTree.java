package com.BTree;

public class BinaryTree {
	Node root;
	
	public BinaryTree(){
		root = null;
	}
	
	//查找
	public int get(int key){
		Node node = root;
		while(node!=null){
			if(key == node.key){
				return node.value;
			} else if(key<node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return -1;
	}
	
	//插入
	public void insert(int key,int value){
		Node newNode = new Node(key, value);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent;
		while(true){
			parent = current;
			if(key<current.key){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			}else {
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(9, 99);
		tree.insert(2, 22);
		tree.insert(5, 55);
		tree.insert(1, 11);
		tree.insert(3, 33);
		tree.insert(7, 77);
		tree.insert(8, 88);
		
		System.out.println(tree.get(5));
	}

}

class Node{
	int key;
	int value;
	Node left;
	Node right;
	public Node(int key,int value){
		this.key = key;
		this.value = value;
	}
}