package com.array;

import java.util.Arrays;

public class MyArray {
	
	/**
	 * 找出数组中第二大的数
	 */
	public static int getSecondMax(int[] arr) {
		int max = arr[0];
		int secondMax = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			} else if (arr[i] > secondMax) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	}
	
	/**
	 * 求最大子数组之和
	 * 方法一,O(n^3)
	 * @param args
	 */
	public static int getMaxSubArray1(int[] arr){
		int len =arr.length;
		int maxSum=arr[0],thisSum=0;
		
		for(int i=0;i<len;i++){
			for(int j=i;j<len;j++){
				thisSum=0;
				for(int k=i;k<=j;k++)
					thisSum+=arr[k];
				if(thisSum>maxSum)
					maxSum=thisSum;
			}
		}
		return maxSum;
	}
	
	/**
	 * 求最大子数组之和
	 * 方法二,O(n^2)
	 * @param arr
	 * @return
	 */
	public static int getMaxSubArray2(int[] arr){
		int maxSum=arr[0];
		int thisSum=0;
		int len =arr.length;
		
		for(int i =0;i<len;i++){
			thisSum=0;
			for(int j=i;j<len;j++){
				thisSum+=arr[j];
				if(thisSum>maxSum)
					maxSum=thisSum;
			}
		}
		return maxSum;
	}
	
	/**
	 * 求最大子数组之和
	 * 方法三,O(n)
	 * @param arr
	 * @return
	 */
	public static int getMaxSubArray3(int[] arr){
		int[] All = new int[arr.length];
		int[] End = new int[arr.length];
		All[0]=End[0]=arr[0];
		
		for(int i=1;i<arr.length;i++){
			End[i]=max(End[i-1]+arr[i], arr[i]);
			All[i]=max(End[i], All[i-1]);
		}
		
		return All[arr.length-1];
	}
	
	/**
	 * 求最大子数组之和,并找出起始点
	 * 方法三,O(n)
	 * @param arr
	 * @return
	 */
	public static int[] getMaxSubArray4(int[] arr){
		int len = arr.length;
		int maxSum=Integer.MIN_VALUE;
		int membSum=0;
		int begin=0,end=0;
		int membStart=0;
		int[] result = new int[3];
		
		for(int i =0;i<len;i++){
			if(membSum<0){
				membStart=i;
				membSum=arr[i];
			}else{
				membSum+=arr[i];
			}
			if(membSum>maxSum){
				maxSum=membSum;
				begin=membStart;
				end=i;
			}
		}
		result[0]=maxSum;
		result[1]=begin;
		result[2]=end;
		return result;
	}
	
	public static int max(int a,int b){
		return a>b?a:b;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,-2,4,8,-4,7,-1,-5};
		//System.out.println(MyArray.getMaxSubArray4(arr));
		System.out.println(Arrays.toString(getMaxSubArray4(arr)));
		
	}

}
