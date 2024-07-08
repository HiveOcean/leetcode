/*
	https://leetcode.com/problems/maximum-product-subarray/
	Maximum Product Subarray - LeetCode #152 Medium (reference LC # 053 Maximum Subarray easy)
	
	Given an integer array nums, find the contiguous subarray within an array 
	(containing at least one number) which has the largest product.

	Example 1:
		Input: [2,3,-2,4]
		Output: 6
		Explanation: [2,3] has the largest product 6.

	Example 2:
		Input: [-2,0,-1]
		Output: 0
		Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

public class MaximumProductSubarray_LC152 {
	public static void main(String[] args) {
		int[][] testData = {{2,3,-2,4},{-2,0,-1},{2,3,0,-4,-6}};
		
		for (int i = 0; i < testData.length; i++) {
			System.out.print("\nInput array [ ");
			for (int k: testData[i])
				System.out.print(k + " ");
			
			System.out.print("] with max product SubArray  " + maxProduct(testData[i]));
		}	
	}
	public static int maxProduct(int[] nums) {
		/* in addition to LC053, if there are two negative numbers, product of them 
		   could be a bigger than product of positive numbers.  Take this in consideration.
		   https://www.youtube.com/watch?v=1s0r7Ixir80 by Nick White
		*/
		if (nums.length == 1) return nums[0];
		
		int currentMax, currentMin, maxProduct = nums[0];
		currentMax = currentMin = nums[0]; 
		
		
		for (int i = 1; i < nums.length; i++) {
			int temp = currentMax;
			// if currentMax = 4, num[i]=-2, currentMin = -9, max(4 * -2, -2 * -9)
			currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);
			currentMin = Math.min(Math.max(temp * nums[i], currentMin * nums[i]), nums[i]);
			
			maxProduct = Math.max(currentMax, maxProduct);
		}
        return maxProduct;
    }
}