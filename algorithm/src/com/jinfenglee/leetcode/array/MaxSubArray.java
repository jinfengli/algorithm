package com.jinfenglee.leetcode.array;

/**
 * 数组的最大子数组(连续)
 * 
 * @author LJF
 * @date:2015-01-26 08:33:42
 * @review:2015-03-10 23:44:55
 * 
 */
public class MaxSubArray {
	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(a));
		System.out.println(maxSubArray2(a));
	}
	/**
	 * 两个for(), 效率很低
	 * @param A
	 * @return
	 */
	public static int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				if (sum > max)
					max = sum;
			}
		}
		return max;
	}
	
	/**
	 * O(n)
	 * @param A
	 * @return
	 */
	private static int maxSubArray2(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int sum = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			sum = sum < 0 ? A[i] : A[i] + sum;
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	
	/**
	 * 与上面的那个解题思路是类似的.
	 * @param a
	 * @return
	 */
	private static int maxSubArraySum(int[] a) {

		int maxSum = a[0];
		int temp = 0;

		for (int i = 0; i < a.length; ++i) {
			temp += a[i]; 
			if (temp > maxSum) {
				maxSum = temp; 
			} 
			if (temp < 0) {// 累加小于0,重新赋值为0
				temp = 0; 
			}
		}
		return maxSum;
	}
	
}
