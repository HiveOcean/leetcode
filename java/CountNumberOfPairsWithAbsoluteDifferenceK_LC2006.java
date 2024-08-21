/*
	https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
	2006. Count Number of Pairs With Absolute Difference K
	
	Given an integer array nums and an integer k, return the number of pairs (i, j) 
	where i < j such that |nums[i] - nums[j]| == k.

	The value of |x| is defined as:

		x if x >= 0.
		-x if x < 0.
		 

	Example 1:
		Input: nums = [1,2,2,1], k = 1
		Output: 4
		Explanation: The pairs with an absolute difference of 1 are:
		- [1,2,2,1]     (nums[0],nums[1])
		- [1,2,2,1]     (nums[0],nums[2])
		- [1,2,2,1]     (nums[1],nums[3])
		- [1,2,2,1]     (nums[2],nums[3])
	
	Example 2:
		Input: nums = [1,3], k = 3
		Output: 0
		Explanation: There are no pairs with an absolute difference of 3.
		
	Example 3:
		Input: nums = [3,2,1,5,4], k = 2
		Output: 3
		Explanation: The pairs with an absolute difference of 2 are:
		- [3,2,1,5,4]     (nums[0],nums[2])
		- [3,2,1,5,4]     (nums[0],nums[3])
		- [3,2,1,5,4]     (nums[1],nums[4])
		 

	Constraints:
		1 <= nums.length <= 200
		1 <= nums[i] <= 100
		1 <= k <= 99
		
*/

public class CountNumberOfPairsWithAbsoluteDifferenceK_LC2006 {
    public int countKDifference(int[] nums, int k) {
        
    }
	public static void main(String[] args) {
		CountNumberOfPairsWithAbsoluteDifferenceK_LC2006 pairs = new CountNumberOfPairsWithAbsoluteDifferenceK_LC2006();
		
		int[] nums1 = {1,2,2,1};
		int k1 = 1;
		int[] nums2 = {1,3};
		int k2 = 3;
		int[] nums3 = {3,2,1,5,4};
		int k3 = 2
		
	}
}		