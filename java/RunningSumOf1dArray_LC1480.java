/*	
	https://leetcode.com/problems/running-sum-of-1d-array/
	1480.  Running Sum of 1d Array
	
	Given an array nums. We define a running sum of an array as 
	runningSum[i] = sum(nums[0]…nums[i]).

	Return the running sum of nums.

	Example 1:
		Input: nums = [1,2,3,4]
		Output: [1,3,6,10]
		Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

	Example 2:
		Input: nums = [1,1,1,1,1]
		Output: [1,2,3,4,5]
		Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

	Example 3:
		Input: nums = [3,1,2,10,1]
		Output: [3,4,6,16,17]
	 
	Constraints:
		1 <= nums.length <= 1000
		-10^6 <= nums[i] <= 10^6
	
	Related Topics:
		Array, Prefix Sum
*/ 
import java.util.Arrays;

public class RunningSumOf1dArray_LC1480 {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
		ans[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ans[i] = nums[i] + ans[i-1];
		}
		return ans;
    }
	public static void main(String[] args) {
		RunningSumOf1dArray_LC1480 rs1darray = new RunningSumOf1dArray_LC1480();
		
		int[] input1 = {1,2,3,4};
		int[] input2 = {1,1,1,1,1};
		int[] input3 = {3,1,2,10,1};
		
		System.out.println(Arrays.toString(input1) + " with running sum: " + 
			Arrays.toString(rs1darray.runningSum(input1)));
		System.out.println(Arrays.toString(input2) + " with running sum: " + 
			Arrays.toString(rs1darray.runningSum(input2)));
		System.out.println(Arrays.toString(input3) + " with running sum: " + 
			Arrays.toString(rs1darray.runningSum(input3)));
	}
}