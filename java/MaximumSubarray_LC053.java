/*
	https://leetcode.com/problems/maximum-subarray/
	Maximum Subarray - LeetCode #53 Easy
	
	Given an integer array nums, find the contiguous subarray (containing at least 
	one number) which has the largest sum and return its sum.

	Follow up: If you have figured out the O(n) solution, try coding another solution 
	using the divide and conquer approach, which is more subtle.

	Example 1:
		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
	
	Example 2:
		Input: nums = [1]
		Output: 1
	
	Example 3:
		Input: nums = [0]
		Output: 0
	
	Example 4:
		Input: nums = [-1]
		Output: -1
	
	Example 5:
		Input: nums = [-2147483647]
		Output: -2147483647
	 
	Constraints:
		1 <= nums.length <= 2 * 10e4
		-2e31 <= nums[i] <= 2e31 - 1

*/
/*	Method 1:
	find all the combination of subarrays and compare to find the maxSum  of subarray
	e.g [-2,1,-3,4,-1,2,1,-5,4]
	subarrays:	[-2],[-2,1],[-2,1,-3],[-2,1,-3,4],[-2,1,-3,4,-1],[-2,1,-3,4,-1,2],[-2,1,-3,4,-1,2,1],[-2,1,-3,4,-1,2,1,-5],[-2,1,-3,4,-1,2,1,-5,4]
				[1],[1,-3],[1,-3,4],[1,-3,4,-1],[1,-3,4,-1,2],[1,-3,4,-1,2,1],[1,-3,4,-1,2,1,-5],[1,-3,4,-1,2,1,-5,4],
				[-3],[-3,4],[-3,4,-1],[-3,4,-1,2],[-3,4,-1,2,1],[-3,4,-1,2,1,-5],[-3,4,-1,2,1,-5,4], etc..
	
	This has the worst time complexity O(n^2)

	Method 2:
	1. Set the maxSum be array[0] in [-2,1,-3,4,-1,2,1,-5,4], maxSum = -2
	2. when index goes to the next one, it finds the maximum of current maxSum and maxSum + array[index]
	   i.e max(maxSum + array[index], array[index])  which is max(maxSum till index + array[index], array[index])
	   index = 1	max((-2 + 1), 1)	=> currentSum = 1, maxSum = 1
	   index = 2    max((1 + -3), -3)	=> currentSum = -2, maxSum = 1
	   index = 3	max((-2 + 4), 4)	=> currentSum = 4, maxSum = 4
	   index = 4	max((4 + -1), -1)	=> currentSum = 3, maxSum = 4
	   index = 5	max((3 + 2) , 2)	=> currentSum = 5, maxSum = 5
	   index = 6	max((5 + 1), 1)		=> currentSum = 6, maxSum = 6<-- it is the maxSum we are looking for
	   index = 7	max((6 + -5), -5)	=> currentSum = 1, maxSum = 6
	   index = 8	mac((1 + 4), 4)		=> currentSum = 5, maxSum = 6
	   
	Kadane’s Algorithm:
		Initialize:
			max_so_far = INT_MIN
			max_ending_here = 0

		Loop for each element of the array
		  (a) max_ending_here = max_ending_here + a[i]
		  (b) if(max_so_far < max_ending_here)
					max_so_far = max_ending_here
		  (c) if(max_ending_here < 0)
					max_ending_here = 0
		return max_so_far
		
		
	https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	Time Complexity: O(n)
*/
public class MaximumSubarray_LC053 {
	public static void main(String[] args) {
		int[][] testNums = {{-2,1,-3,4,-1,2,1,-5,4},
							{1},
							{0},
							{-1},
							{-2147483647},
							{3,5,2,-15,10,-3,4,7,1}};

		for (int i = 0; i < testNums.length; i++) {
			System.out.print("\nInput array [ ");
			for (int k: testNums[i])
				System.out.print(k + " ");
			
			System.out.print("] with maxSubArray sum " + maxSubArray(testNums[i]));
		}	
	}
	public static int maxSubArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		
		int maxSum ,currentSum = nums[0];
		maxSum = currentSum;
		for (int j = 1; j < nums.length; j++) {
			currentSum = Math.max((currentSum + nums[j]), nums[j]);
			maxSum = Math.max(currentSum, maxSum);
		}
        return maxSum;
    }
}