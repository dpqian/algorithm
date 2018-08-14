package com.collection;

import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for(int i =0;i<10;i++){
			list.add(i);
		}
		
		list.add(5,666);
		
		List list2 = new LinkedList<>();
		list2.add(111);
		list2.add(222);
		list2.add(333);
		
		list.addAll(10, list2);
		Object[] array = list.toArray();
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println();
		System.out.println(list.indexOf(121312));
		
		System.out.println(list.contains(111));
		
		//删除
		System.out.println(list.remove(111));
		array = list.toArray();
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}

}
