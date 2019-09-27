package com;

import java.util.*;

public class sort {

	public static void cocktailSort(int array[]) {

		// 记录最后一次交换的位置
		int rightExchangeIndex = 0;
		int leftExchangeIndex = 0;

		// 无序数列的边界，每次比较只需要比到这里为止
		int rightBorder = array.length - 1;
		int leftBorder = 0;

		int tmp = 0;

		for (int i = 0; i < array.length/2; i++) {
			// 有序标记每一轮的初始值都是true
			boolean isSorted = true;
			// 奇数轮，从左向右比较和交换
			for (int j = i; j < rightBorder; j++) {
				if (array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					// 因为有元素交换，所以不是有序的，标记为false
					isSorted = false;
					// 更新为最后一次交换元素的位置
					rightExchangeIndex = j;
				}
			}
			rightBorder = rightExchangeIndex;
			if (isSorted) {
				break;
			}

			// 在偶数轮之前，将isSorted重新标记为true
			isSorted = true;

			// 偶数轮，从右向左较和交换
			for (int j = rightBorder; j > leftBorder; j--) {
				if (array[j] < array[j-1]) {
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
					// 因为有元素交换，所以不是有序的，标记为false
					isSorted = false;
					// 更新为最后一次交换元素的位置
					leftExchangeIndex = j;
				}
			}
			leftBorder = leftExchangeIndex;
			if (isSorted) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{5,8,6,3,9,2,1,7};

		long startTime=System.nanoTime();   //获取开始时间

		cocktailSort(array);

		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		System.out.println(Arrays.toString(array));
	}
}