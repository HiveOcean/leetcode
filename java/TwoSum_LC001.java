/*
	https://leetcode.com/problems/two-sum/
	Two Sum - LeetCode #1 Easy

	Given an array of integers nums and an integer target, return indices of the two 
	numbers such that they add up to target.

	You may assume that each input would have exactly one solution, and you may not 
	use the same element twice.

	You can return the answer in any order. 
	(i.e [1,2,3,4,5,6,7,8,9,10] & 10 , cannot return [4,4] which is two 5 added together)

	Example 1:
		Input: nums = [2,7,11,15], target = 9
		Output: [0,1]
		Output: Because nums[0] + nums[1] == 9, we return [0, 1].
	Example 2:
		Input: nums = [3,2,4], target = 6
		Output: [1,2]
	Example 3:
		Input: nums = [3,3], target = 6
		Output: [0,1]

	Constraints:
		2 <= nums.length <= 10e5
		-10e9 <= nums[i] <= 10e9
		-10e9 <= target <= 10e9
		Only one valid answer exists.

*/
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TwoSum_LC001 {
	public static void main(String[] args) {
		int[][] testData = {{2,11,15,7}, {3,2,4}, {3,3},{0,0}};
		int[] targetData = {9, 6, 6, 0};
		
		for (int i = 0; i < targetData.length; i++) {
			
			int[] output = twoSum(testData[i], targetData[i]);
			
			// Display all output
			if (output.length > 0) {
				System.out.print("\nAt indexes: ");
			
				for (int j: output) {
					System.out.print(j + " ");
				}
				System.out.println("Added up for: " + testData[i][output[0]] + " + "
					+ testData[i][output[1]] + " = " + targetData[i]);
				System.out.println();
			}
		}
	}
	public static int[] twoSum(int[] nums, int target) {
		
			//Method 1  O(n)
			//https://www.youtube.com/watch?v=BoHO04xVeU0 by Nick White
			//Solution:
			Map<Integer, Integer> num_map = new HashMap<>();
			
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				
				if (num_map.containsKey(complement)) {
					return new int[]{num_map.get(complement),i};
				}
				num_map.put(nums[i],i);
			}
			// if not match, throw exception
			throw new IllegalArgumentException("no match found");
			
		/*
		// Method 1.1
		// First loop to put array into map
		// Second loop to find the index of element which sum up to the target
		int[] ans = {-1, -1};
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],i);
		}	
		for (int k = 0; k < nums.length; k++) {
			int complement = target - nums[k];
			if (map.containsKey(complement)) {
				if (k != map.get(target - nums[k])) {
					ans[0] = k;
					ans[1] = map.get(complement);
					return ans;
				}
			}
		}
        return ans;
		*/
    }
	/* Method 2 use bruted force  O(ne2)
	public static int[] twoSum(int[] nums, int target) {		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int complement = target - nums[i];
				
				if (num[j] == complement) {
					return new int[](i,j);
				}
			}
		}
		// if not match, throw exception
		throw new IllegalArgumentException("no match found");
	}
	*/
}