package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.omg.CORBA.PRIVATE_MEMBER;

public class FindMostElem {

	public static int[] findMostElem(int[] arr) {
		
		int[] result = new int[2];
		Map map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], (int) map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		int max = 1;
		int key = arr[0];

		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if ((int) entry.getValue() > max) {
				max = (int) entry.getValue();
				key = (int) entry.getKey();
			}

		}
		
		result[0]=key;
		result[1]=max;
		return result;
	}
	
	public static int[] test(int[] arr){
		Map map = new HashMap<>();
		for(int i =0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], (int)map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}
			
		}
		
		int[] result=new int[2];
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry)iterator.next();
			int key = (int)entry.getKey();
			int value = (int)entry.getValue();
			if(value>result[1]){
				result[0] = key;
				result[1] = value;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,4,4,2,3,4,5,3,4,5,5};
		System.out.println(Arrays.toString(FindMostElem.test(arr)));
	}

}
