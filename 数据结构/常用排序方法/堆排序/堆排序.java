package com;

import java.util.*;

public class sort {

	/**
	 * “下沉” 调整
	 * @param array 		待调整的堆
	 * @param parentIndex 	要 “下沉” 的父节点
	 * @param length		堆的有效大小
	 */
	public static void downAdjust(int[] array, int parentIndex, int length) {
		// tmp保存父节点值，用于最后的赋值
		int tmp = array[parentIndex];
		int childIndex = 2 * parentIndex + 1;
		while (childIndex < length) {
			// 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
			if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
				childIndex++;
			}
			// 如果父节点大于任何一个孩子的值，则直接跳出
			if (tmp >= array[childIndex])
				break;
			// 无须真正交换，单项赋值即可
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = 2 * childIndex + 1;
		}
		array[parentIndex] = tmp;
	}

	/**
	 * 堆排序（升序）
	 * @param array 待调整的堆
	 */
	public static void heapSort(int[] array) {
		// 把无序数组构建成最大堆
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			downAdjust(array, i, array.length);
		}
		// 循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
		for (int i = array.length - 1; i > 0; i--) {
			// 最后一个元素和第一个元素进行交换
			int tmp = array[i];
			array[i] = array[0];
			array[0] = tmp;
			// “下沉” 调整最大堆
			downAdjust(array, 0, i);
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};

		long startTime=System.nanoTime();   //获取开始时间

		heapSort(array);

		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		System.out.println(Arrays.toString(array));
	}
}