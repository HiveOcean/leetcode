/*
	https://leetcode.com/problems/increasing-triplet-subsequence/
	334. Increasing Triplet Subsequence (medium)
	
	Given an integer array nums, return true if there exists a triple of indices 
	(i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such 
	indices exists, return false.

	Example 1:
		Input: nums = [1,2,3,4,5]
		Output: true
		Explanation: Any triplet where i < j < k is valid.

	Example 2:
		Input: nums = [5,4,3,2,1]
		Output: false
		Explanation: No triplet exists.

	Example 3:
		Input: nums = [2,1,5,0,4,6]
		Output: true
		Explanation: The triplet (3, 4, 5) is valid because 
					 nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
		 
	Constraints:
		1 <= nums.length <= 5 * 10^5
		-2^31 <= nums[i] <= 2^31 - 1

	Follow up: 
		Could you implement a solution that runs in O(n) time complexity and O(1) 
		space complexity?
	
	Related topics:
		Array Greedy algorithm
	
	https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
	
	1.  set small=MAX_VALUE and big=MAX_VALUE
	2.  Noted the smallest value
	3.  Noted a value which is bigger than the smallest but smaller than the big
	4.  Now we should have the smallest and big value in place 
	5.	Any elements which is > smallest and < big, bingo, it is the triplet subseq.
*/
import java.util.*;

public class IncreasingTripletSubsequence_LC0334 {
    public boolean increasingTriplet(int[] nums) {
		// start with two largest values, as soon as we find a number bigger than 
		// both, while both have been updated, return true.
         int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
	public static void main(String[] args) {
		IncreasingTripletSubsequence_LC0334 triplet = new IncreasingTripletSubsequence_LC0334();
		
		int[][] nums = {
				{1,2,3,4,5},
				{5,4,3,2,1},
				{2,1,5,0,4,6},
				{5,4,3,2,1,9,8},
				{2,1,0,5,4,6},
				{2,2,2,2,2}};
		
		for (int[] num: nums) {
			System.out.println(Arrays.toString(num) +  " has increasing triplet subsequence? " +
				triplet.increasingTriplet(num));
		}
	}
}
