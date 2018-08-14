package com.dataStructure;

public class Stack_Min_O1 {
	private MyStack<Integer> elem;
	private MyStack<Integer> min;
	
	public Stack_Min_O1(){
		elem = new MyStack<Integer>();
		min = new MyStack<Integer>();
	}
	public void push(int data){
		elem.push(data);
		if(min.isEmpty())
			min.push(data);
		else{
			if(data<min.peek())
				min.push(data);
		}
	}
	
	public int pop(){
		int data = elem.pop();
		if(data==min.peek())
			min.pop();
		return data;
	}
	
	public int getMin(){
		return min.peek();
	}
	public static void main(String[] args) {
		Stack_Min_O1 s = new Stack_Min_O1();
		for(int i = 0 ;i<10;i++)
			s.push(i);
		System.out.println(s.getMin());
		s.push(-1);
		s.push(-2);
		System.out.println(s.getMin());
	}

}
