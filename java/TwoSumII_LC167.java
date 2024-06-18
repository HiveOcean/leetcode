/*
	https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
	Two Sum II - LeetCode #167
	
	Given an array of integers that is already sorted in ascending order, find two 
	numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they add 
	up to the target, where index1 must be less than index2.

	Note:
		- Your returned answers (both index1 and index2) are not zero-based.
		- You may assume that each input would have exactly one solution and you may 
		  not use the same element twice.
	 

	Example 1:
		Input: numbers = [2,7,11,15], target = 9
		Output: [1,2]
		Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	
	Example 2:
		Input: numbers = [2,3,4], target = 6
		Output: [1,3]
	
	Example 3:
		Input: numbers = [-1,0], target = -1
		Output: [1,2]
	 

	Constraints:
		* 2 <= nums.length <= 3 * 10^4
		* -1000 <= nums[i] <= 1000
		* nums is sorted in increasing order.
		* -1000 <= target <= 1000
	
	
	For twoSum function:

	- Set the low pointer lo to start, and high pointer hi to the last index.
	- While low pointer is smaller than high:
		- If the sum of nums[lo] and nums[hi] is less than target, increment lo.
			- Also increment lo if the value is the same as for lo - 1.
		- If the sum is greater than target, decrement hi.
			- Also decrement hi if the value is the same as for hi + 1.
		- Otherwise, we found a pair:
			- Add it to the result res.
			- Decrement hi and increment lo.
	- Return the result res.
*/
import java.util.*;

public class TwoSumII_LC167 {
	public static void main(String[] args) {
		TwoSumII_LC167 ts = new TwoSumII_LC167();
		int[][] input = {{2,7,11,15},{2,3,4},{-1,0}};
		int[] target = {9,6,-1};
		
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("[ ");
			for (int k: input[i])
				System.out.print(k + " ");
			System.out.print("] add up target: " + target[i] + " output: [ "); 
			
			int[] ans = ts.twoSum(input[i],target[i]);
			for (int j: ans) 
				System.out.print(j + " ");
			System.out.println("]");
		}	
	}
    public int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		int left = 0, right = numbers.length - 1;
		
		while (left < right) {
			if (target < numbers[left] + numbers[right]) {
				right--;
			} else if (target > numbers[left] + numbers[right]) {
				left++;
			} else {
				ans[0] = left + 1;
				ans[1] = right + 1;
				break;
			}
		}
        return ans;
    }
}