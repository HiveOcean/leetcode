/*
	https://leetcode.com/problems/4sum/
	Four Sum - LeetCode #018
	
	Given an array nums of n integers and an integer target, are there elements 
	a, b, c, and d in nums such that a + b + c + d = target? Find all unique 
	quadruplets in the array which gives the sum of target.

	Notice that the solution set must not contain duplicate quadruplets.

	Example 1:
		Input: nums = [1,0,-1,0,-2,2], target = 0
		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		
	Example 2:
		Input: nums = [], target = 0
		Output: []
		 
	Constraints:
		0 <= nums.length <= 200
		-10^9 <= nums[i] <= 10^9
		-10^9 <= target <= 10^9

*/
import java.util.*;

public class FourSum_LC018 {
	public static void main(String[] args) {
		FourSum_LC018 fs = new FourSum_LC018();
		int[][] input = {{1,0,-1,0,-2,2},{},{2,7,11,15,-5,0,-1,-1,0}};
		int[] target = {0,0,9};
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("[ ");
			for (int k: input[i])
				System.out.print(k + " ");
			System.out.print("] target: " + target[i] + " output: [ "); 
			
			ans = fs.fourSum(input[i],target[i]);
			for (int j = 0; j < ans.size(); j++) {
				System.out.print("[ ");
				for (int n: ans.get(j))
					System.out.print(n + " ");
				System.out.print("] ");
			}
			System.out.println("]");
			ans.clear();
		}				 
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new LinkedList<>();
		int size = nums.length;
		if (nums == null || size <4) {
			return output;
		}
		Arrays.sort(nums);
		
		for (int j = 0; j < nums.length - 3; j++) {
			if (  j > 0 && nums[j] != nums[j - 1]) {  
				for (int i = j + 1; i < nums.length - 2; i++) {
					// skip the duplicates
					// or "if ( i == 0 || ( i > 0 && nums[i] == nums[i - 1])) {continue;} "
					if (  i > j + 1 && nums[i] != nums[i - 1]) {  
						int low = i + 1;
						int high = nums.length - 1;
						int sum = target - nums[i] - nums[j];
						
						while ( low < high ) {
							if (nums[low] + nums[high] == sum) {
								output.add(Arrays.asList(nums[j], nums[i], nums[low],nums[high]));
								
								// skip duplicates elements
								while (low < high && nums[low] == nums[low+1]) low++;
								while (low < high && nums[high] == nums[high-1]) high--;
								
								low++;
								high--;
							} else if ( nums[low] + nums[high] > sum ) {
								high--;
							} else {
								low++;
							}
						}
					}
				}
			}			
		}	
		return output;
    }
	
}