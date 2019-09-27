package com;

import java.util.*;

public class sort {

	public static void bubbleSort(int array[]) {

		for (int i = 0; i < array.length - 1; i++) {
			// 有序标记每一轮的初始值都是true
			boolean isSorted = true;
			for (int j = 0; j < array.length - i - 1; j++) {
				int tmp = 0;
				if (array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					// 因为有元素交换，所以不是有序的，标记为false
					isSorted = false;
				}
			}
			if (isSorted) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{5,8,6,3,9,2,1,7};

		long startTime=System.nanoTime();   //获取开始时间

		bubbleSort(array);

		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		System.out.println(Arrays.toString(array));
	}
}