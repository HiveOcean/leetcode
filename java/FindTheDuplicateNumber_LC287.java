/*
	https://leetcode.com/problems/find-the-duplicate-number/
	Find the Duplicate Number - LeetCode #287
	
	Given an array of integers nums containing n + 1 integers where each integer 
	is in the range [1, n] inclusive.

	There is only one duplicate number in nums, return this duplicate number.

	Follow-ups:
	1	How can we prove that at least one duplicate number must exist in nums? 
	2	Can you solve the problem without modifying the array nums?
	3	Can you solve the problem using only constant, O(1) extra space?
	4	Can you solve the problem with runtime complexity less than O(n2)?
		 
	Example 1:
		Input: nums = [1,3,4,2,2]
		Output: 2
		
	Example 2:
		Input: nums = [3,1,3,4,2]
		Output: 3
		
	Example 3:
		Input: nums = [1,1]
		Output: 1
		
	Example 4:
		Input: nums = [1,1,2]
		Output: 1 

	Constraints:
	-	2 <= n <= 3 * 10^4
	-	nums.length == n + 1
	-	1 <= nums[i] <= n
	-	All the integers in nums appear only once except for precisely one integer 
		which appears two or more times.

*/

public class FindTheDuplicateNumber_LC287 {
	public static void main(String[] args) {
		FindTheDuplicateNumber_LC287 duplicateNumber = new FindTheDuplicateNumber_LC287();
		int[][] input = {{1,3,4,2,2},{3,1,3,4,2},{1,1},{1,1,2}};
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("[ ");
			for (int k: input[i])
				System.out.print(k + " ");
			System.out.println("] with duplicate number: " + 
				duplicateNumber.findDuplicate(input[i]));
		}
	}
    public int findDuplicate(int[] nums) {
		// sum of array element - sum of array index = duplicate number
		if (nums.length == 0) return 0;
		
		int dup = 0; 
		for (int i = 0; i < nums.length; i++) {
			dup += nums[i] - i;
		}
        return dup;
    }
}