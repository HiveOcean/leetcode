/*
	https://leetcode.com/problems/house-robber/
	House Robber - LeetCode #198 
	
	You are a professional robber planning to rob houses along a street. 
	Each house has a certain amount of money stashed, the only constraint 
	stopping you from robbing each of them is that adjacent houses have 
	security system connected and it will automatically contact the police 
	if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money 
	of each house, determine the maximum amount of money you can rob tonight 
	without alerting the police.

	Example 1:
		Input: nums = [1,2,3,1]
		Output: 4
		Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
					Total amount you can rob = 1 + 3 = 4.
	Example 2:
		Input: nums = [2,7,9,3,1]
		Output: 12
		Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob 
					 house 5 (money = 1).
					 Total amount you can rob = 2 + 9 + 1 = 12.	 

	Constraints:
		0 <= nums.length <= 100
		0 <= nums[i] <= 400
	
*/
public class HouseRobber_LC198 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,1};
		int[] nums2 = {2,7,9,3,1};
		
		System.out.print("\n[ ");
		for (int k: nums1)
			System.out.print(k + " ");
		System.out.println("] with grestest money robbed: " + rob(nums1));
		
		System.out.print("\n[ ");
		for (int m: nums2)
			System.out.print(m + " ");
		System.out.println("] with grestest money robbed: " + rob(nums2));
		
	}
    public static int rob(int[] nums) {
		int odd = 0, even = 0;
		
		for (int i = 0; i < nums.length;){
			odd += nums[i];
			i += 2;
		}
		for (int j = 1; j < nums.length;){
			even += nums[j];
			 j += 2;
		}
		return Math.max(odd, even);
    }
}