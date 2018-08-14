package com.search;

public class BinarySearch {
	public static int binarySearch(int[] arr,int num){
		int low = 0;
		int high = arr.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(arr[mid]==num)
				return mid;
			if(arr[mid]>num)
				high = mid-1;
			if(arr[mid]<num)
				low=mid+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(arr, 1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
