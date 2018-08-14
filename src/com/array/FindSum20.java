package com.array;

public class FindSum20 {
	
	public  static void findSum(int[] arr,int sum){
		int begin=0;
		int end=arr.length-1;
		
		while(begin<end){
			if(arr[begin]+arr[end]<sum)
				begin++;
			else if(arr[begin]+arr[end]>20)
				end--;
			else{
				System.out.println(arr[begin]+"+"+arr[end]);
				begin++;
				end--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr={1,2,3,4,6,7,14,17};
		FindSum20.findSum(arr, 20);
	}

}
