package com.sort;

import java.util.Arrays;

public class HeapSort {
	public static void adjustHeap(int[] arr,int start,int end){
		int temp = arr[start];
		int current = start;
		int left = current*2+1;
		for(;left<=end;current = left,left=2*left+1){
			//判断右节点是否比左节点大
			if(left<end&&arr[left+1]>arr[left])
				left++;
			//判断子节点是否比父节点大
			if(arr[left] > temp){
				arr[current] = arr[left];
				arr[left] = temp;
				//current = left;
 			} else {
 				break;
 			}
		}
	}
	
	public static void heapSort(int[] arr){
		int len = arr.length;
		int temp;
		//构建大顶堆
		for(int i = len/2-1; i>=0; i--){
			adjustHeap(arr, i, len - 1);
		}
		
		//排序
		for(int i = len - 1; i >= 0; i--){
			//交换堆顶和堆底
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			//每次交换后从堆顶开始调整
			adjustHeap(arr, 0, i-1);
		}
		
	}
	public static void adjustHeapDesc(int[] arr, int start,int end){
		int temp = arr[start];
		int left = 2*start+1;
		int current = start;
		for(;left<=end;current = left,left = 2*left+1){
			if(left<end && arr[left+1]<arr[left])
				left++;
			if(arr[left] < temp){
				arr[current] = arr[left];
				arr[left] = temp;
			} else {
				break;
			}
		}
	}
	public static void heapSortDesc(int[] arr){
		int len =arr.length;
		int temp;
		//构建小顶堆
		for(int i = len/2-1; i>=0; i--){
			adjustHeapDesc(arr,i,len-1);
		}
		//排序
		for(int i = len-1; i>=0; i--){
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] =temp;
			adjustHeapDesc(arr, 0, i-1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,2,3,8,4,6,1,7,9};
		heapSortDesc(arr);
		System.out.println(Arrays.toString(arr));
	}

}
