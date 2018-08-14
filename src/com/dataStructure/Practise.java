package com.dataStructure;

import java.util.Arrays;

public class Practise {
	
	public static int[] insertSort(int[] arr){
		int len =arr.length;
		for(int i=1;i<len;i++){
			int temp =arr[i];
			int j = i;
			while(j>0&&arr[j-1]>temp){
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
			
		return arr;
	}
	
	public static int[] bubbleSort(int[] arr){
		boolean sorted =true;
		for(int i=0;i<arr.length;i++){
			sorted = true;
			System.out.println("µÚ"+i+"´Î");
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]=temp;
					sorted=false;
				}
			}
			if(sorted ==true)
				return arr;
		}
		return arr;
	}
	
	public static void quickSort(int[] arr,int left,int right){
		
		if(left>=right)
			return;
		
		int i =left;
		int j=right;
		int index =arr[i];
		
		
		while(i<j){
			while(i<j&&arr[j]>=index)
				j--;
			if(i<j)
				arr[i++]=arr[j];
			while(i<j&&arr[i]<=index)
				i++;
			if(i>j)
			arr[j--]=arr[i];
		}
		arr[i]=index;
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}

	public static void main(String[] args) {
		int[] a ={9,2,3,1,4,8,7,6};
		Practise.quickSort(a,0,a.length-1);
		//System.out.println(Arrays.toString(Practise.quickSort(a)));
		System.out.println(Arrays.toString(a));
		int i=0;int j =7;
		int c=(i+j)/2;
		System.out.println(c);
	}

}
