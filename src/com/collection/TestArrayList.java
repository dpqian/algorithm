package com.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
	
	
	public static void main(String[] args){
		MyArrayList<Integer> list = new MyArrayList<>();
		for (int i = 0; i < 10; i ++) {
			list.add(i);
		}
		System.out.println(list.get(9));
		
		list.set(3, 333);
		System.out.println(list.get(3));
		
		list.remove(3);
		System.out.println(list.get(3));
		
		System.out.println(list.size());
		
		List list2 = new LinkedList<>();
	}
}
