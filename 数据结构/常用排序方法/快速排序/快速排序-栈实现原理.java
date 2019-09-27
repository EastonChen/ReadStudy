package com;

import java.util.*;

public class sort {

	public static void quickSort(int[] array, int startIndex, int endIndex) {
		// 用集合栈来代替递归的函数栈
		Stack<Map<String, Integer>> quickSortStack = new Stack<>();
		// 整个数列的起止下标，以哈希形式入栈
		Map rootParam = new HashMap();
		rootParam.put("startIndex", startIndex);
		rootParam.put("endIndex", endIndex);
		quickSortStack.push(rootParam);

		// 循环结束条件：栈为空时
		while (!quickSortStack.isEmpty()) {
			// 栈顶元素出栈，得到起止下标
			Map<String, Integer> param = quickSortStack.pop();
			// 得到基准元素位置
			int pivotIndex = partition(array, param.get("startIndex"), param.get("endIndex"));
			// 根据基准元素分成两部分，把每一部分的起止下标入栈
			if (param.get("startIndex") < pivotIndex - 1) {
				Map<String, Integer> leftParam = new HashMap<>();
				leftParam.put("startIndex", param.get("startIndex"));
				leftParam.put("endIndex", pivotIndex - 1);
				quickSortStack.push(leftParam);
			}
			if (pivotIndex + 1 < param.get("endIndex")) {
				Map<String, Integer> rightParam = new HashMap<>();
				rightParam.put("startIndex", pivotIndex + 1);
				rightParam.put("endIndex", param.get("endIndex"));
				quickSortStack.push(rightParam);
			}
		}

	}

	/**
	 * 分治（单边循环法）
	 * @param array			待交换的数组
	 * @param startIndex	起始下标
	 * @param endIndex		结束下标
	 */
	private static int partition(int[] array, int startIndex, int endIndex) {
		// 基准元素
		int pivot = array[startIndex];
		int mark = startIndex;

		for (int i = startIndex + 1; i <= endIndex ; i++) {
			if (array[i] < pivot){
				mark++;
				int tmp = array[mark];
				array[mark] = array[i];
				array[i] = tmp;
			}
		}

		// pivot和指针重合点交换
		array[startIndex] = array[mark];
		array[mark] = pivot;

		return mark;
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