package com.array;

import java.util.Arrays;

public class RightShift {

	public static int[] rightShift(int[] arr,int k){
		int len = arr.length;
		k = k%len;
		reverse(arr, 0, len-k-1);
		reverse(arr, len-k, len-1);
		reverse(arr, 0, len-1);
		
		return arr;
	}
	
	public static void reverse(int[] arr,int begin,int end){
		for(;begin<end;begin++,end--){
			int temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(rightShift(arr, 10)));

	}

}
