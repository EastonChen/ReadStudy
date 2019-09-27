package com;

import java.util.*;

public class sort {

	public static void quickSort(int[] array, int startIndex, int endIndex) {
		// 递归结束条件：startIndex大于或等于endIndex
		if (startIndex >= endIndex) {
			return;
		}
		// 基准元素位置改变
		randPivot(array, startIndex, endIndex);

		int pivotIndex = partition(array, startIndex, endIndex);
		// 根据基准元素，分成两部分进行递归排序
		quickSort(array, startIndex, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, endIndex);
	}

	/**
	 * 分治（双边循环法）
	 * @param array			待交换的数组
	 * @param startIndex	起始下标
	 * @param endIndex		结束下标
	 */
	private static int partition(int[] array, int startIndex, int endIndex) {
		// 基准元素
		int pivot = array[startIndex];
		int left = startIndex;
		int right = endIndex;

		while (left != right) {
			// 控制right指针比较并左移
			while (left<right && array[right] > pivot) {
				right--;
			}
			// 控制left指针比较并右移
			while (left<right && array[left] <= pivot) {
				left++;
			}
			// 交换left和right指针所指向的元素
			if (left<right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
		}

		// pivot和指针重合点交换
		array[startIndex] = array[left];
		array[left] = pivot;

		return left;
	}

	/**
	 * 随机基准元素放在首位
	 * @param array 		数组
	 * @param startIndex	取值范围开始
	 * @param endIndex		取值范围结束
	 */
	private static void randPivot(int[] array, int startIndex, int endIndex) {
		int rand = (int) (startIndex + Math.random() * (endIndex - startIndex + 1));
		int tmp = array[startIndex];
		array[startIndex] = array[rand];
		array[rand] = tmp;
	}

	public static void main(String[] args) {
		int[] array = new int[]{4,4,6,5,3,2,8,1};

		long startTime=System.nanoTime();   //获取开始时间

		quickSort(array, 0, array.length-1);

		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		System.out.println(Arrays.toString(array));
	}
}