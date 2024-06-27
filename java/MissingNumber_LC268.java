/*
	https://leetcode.com/problems/missing-number/
	Missing Number - LeetCode #268 Easy
	
	Given an array nums containing n distinct numbers in the range [0, n], 
	return the only number in the range that is missing from the array.

	Follow up: Could you implement a solution using only O(1) extra space 
	complexity and O(n) runtime complexity?

	Example 1:
		Input: nums = [3,0,1]
		Output: 2
		Explanation: n = 3 since there are 3 numbers, so all numbers are in 
		the range [0,3]. 2 is the missing number in the range since it does 
		not appear in nums.
	
	Example 2:
		Input: nums = [0,1]
		Output: 2
		Explanation: n = 2 since there are 2 numbers, so all numbers are in the 
		range [0,2]. 2 is the missing number in the range since it does not 
		appear in nums.
	
	Example 3:
		Input: nums = [9,6,4,2,3,5,7,0,1]
		Output: 8
		Explanation: n = 9 since there are 9 numbers, so all numbers are in the 
		range [0,9]. 8 is the missing number in the range since it does not 
		appear in nums.
	
	Example 4:
		Input: nums = [0]
		Output: 1
		Explanation: n = 1 since there is 1 number, so all numbers are in the 
		range [0,1]. 1 is the missing number in the range since it does not 
		appear in nums.
	 
	Constraints:
		n == nums.length
		1 <= n <= 10e4
		0 <= nums[i] <= n
		All the numbers of nums are unique.

*/

public class MissingNumber_LC268 {
	public static void main(String[] args) {
		int[][] arrays = {{3,0,1}, {0,1}, {9,6,4,2,3,5,7,0,1}, {0}};	
		
		for (int i = 0; i < arrays.length; i++) {
			System.out.print("[");
			for (int k: arrays[i]) {
				System.out.print(" " + k);
			}
			System.out.println(" ] missing number: " + missingNumber(arrays[i]));
		}
	}
	public static int missingNumber(int[] nums) {
		int n = nums.length, ans = 0;	
		for (int i = 0; i < nums.length ; i++) {
			ans += nums[i] - n--;
		}
        return Math.abs(ans);
    }
}