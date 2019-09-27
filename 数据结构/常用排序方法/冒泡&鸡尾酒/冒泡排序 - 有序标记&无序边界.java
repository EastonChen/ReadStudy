package com;

import java.util.*;

public class sort {

	public static void bubbleSort(int array[]) {
		// 记录最后一次交换的位置
		int lastExchangeIndex = 0;

		// 无序数列的边界，每次比较只需要比到这里为止
		int sortBorder = array.length - 1;

		for (int i = 0; i < array.length - 1; i++) {
			// 有序标记每一轮的初始值都是true
			boolean isSorted = true;
			for (int j = 0; j < sortBorder; j++) {
				int tmp = 0;
				if (array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					// 因为有元素交换，所以不是有序的，标记为false
					isSorted = false;
					// 更新为最后一次交换元素的位置
					lastExchangeIndex = j;
				}
			}
			sortBorder = lastExchangeIndex;
			if (isSorted) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{3,4,2,1,5,6,7,8};

		long startTime=System.nanoTime();   //获取开始时间

		bubbleSort(array);

		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		System.out.println(Arrays.toString(array));
	}
}