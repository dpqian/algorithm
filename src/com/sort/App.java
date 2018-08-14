package com.sort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		
		int[] arr={2,1,4,3,6,5,2,1,5,7,6,4,7,9,3,46};
		
		//arr=Method.bubbleSort(arr);
		//arr=Method.chooseSort(arr);
		Method.quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
