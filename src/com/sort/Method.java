package com.sort;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Method {

	/**
	 * ð������,��С����
	 */
	public static int[] bubbleSort(int[] arr) {
		int len = arr.length;
		boolean sorted = true;

		for (int i = 0; i < len - 1; i++) {
			sorted = true;
			System.out.println(i);

			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}

			if (sorted == true)
				break;
		}
		return arr;
	}

	/**
	 * ѡ�����򣬴�С����
	 */
	public static int[] chooseSort(int[] arr) {

		int len = arr.length;
		int temp = 0;
		int min = 0;

		for (int i = 0; i < len; i++) {
			min = arr[i];
			temp = i;
			for (int j = i + 1; j < len; j++) {

				if (arr[j] < min) {
					temp = j;
					min = arr[j];
				}
			}

			arr[temp] = arr[i];
			arr[i] = min;
		}

		return arr;
	}

	/**
	 * �������򣬴�С����
	 */
	public static int[] insertSort(int[] arr) {

		int len = arr.length;

		for (int i = 1; i < len; i++) {

			int temp = arr[i];
			while (i >= 1 && arr[i - 1] > temp) {
				arr[i] = arr[i - 1];
				i--;
			}

			arr[i] = temp;
		}

		return arr;

	}

	/**
	 * ��������
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static void quickSort(int[] arr, int left, int right) {

		if (left >= right)
			return;
		int i = left;
		int j = right;
		int index = arr[i];

		while (i < j) {
			while (i < j && arr[j] >= index)
				j--;
			if (i < j)
				arr[i++] = arr[j];
			while (i < j && arr[i] <= index)
				i++;
			if (i < j)
				arr[j--] = arr[i];
		}

		arr[i] = index;
		quickSort(arr, left, i - 1);
		quickSort(arr, i + 1, right);
	}

}
