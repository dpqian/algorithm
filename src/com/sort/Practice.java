package com.sort;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

import javax.naming.ldap.SortControl;

public class Practice {

	public static void quickSort(int[] arr,int low,int high){
		if(low>=high)
			return;
		int base = arr[low];
		int left = low;
		int right = high;
		while(low<high){
			while(low<high && arr[high] > base)
				high--;
			if(low < high)
				arr[low++] = arr[high];
			while(low < high && arr[low] < base)
				low++;
			if(low < high)
				arr[high--] = arr[low];
		}
		arr[low] = base;
		quickSort(arr, left, low-1);
		quickSort(arr, low+1, right);
	}
	
	public static void mergeSort(int[] arr){
		int[] temp = new int[arr.length];
		mergeSort(arr,0,arr.length-1,temp);
	}
	
	public static void mergeSort(int[] arr,int left,int right ,int[] temp){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(arr,left,mid,temp);
			mergeSort(arr,mid+1,right,temp);
			merge(arr, left, mid, right, temp);
		}
	}
	
	public static void merge(int[] arr,int left,int mid ,int right,int[] temp){
		int i = left;
		int j = mid + 1;
		int index = 0;
		while(i <= mid && j <= right){
			if(arr[i] < arr[j]){
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
			}
		}
		while(i<=mid)
			temp[index++] = arr[i++];
		while(j<=right)
			temp[index++] = arr[j++];
		
		index = 0;
		while(left<=right)
			arr[left++] = temp[index++];
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = { 9, 5, 3, 6, 2, 1, 8, 4, 7 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
