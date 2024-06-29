/*
	https://leetcode.com/problems/3sum/
	Three Sum - LeetCode #15

	Given an array nums of n integers, are there elements a, b, c in nums such 
	that a + b + c = 0? Find all unique triplets in the array which gives the sum 
	of zero.

	Notice that the solution set must not contain duplicate triplets.

	Example 1:
		Input: nums = [-1,0,1,2,-1,-4]
		Output: [[-1,-1,2],[-1,0,1]]
		
	Example 2:
		Input: nums = []
		Output: []
		
	Example 3:
		Input: nums = [0]
		Output: []
		 
	Constraints:
		0 <= nums.length <= 3000
		-10^5 <= nums[i] <= 10^5
*/
import java.util.*;

public class ThreeSum_LC015 {
	public static void main(String[] args) {
		ThreeSum_LC015 ts = new ThreeSum_LC015();
		int[][] input = {{-1,0,1,2,-1,-4},{},{0}};
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("[ ");
			for (int k: input[i])
				System.out.print(k + " ");
			System.out.print("] triplets that add up to zero: [ "); 
			
			ans = ts.threeSum2(input[i]);
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
	// Method 1:
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
		Set<List<Integer>> ans = new HashSet<List<Integer>>();
		int left = 0, right;
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			left = 0;
			right = nums.length - 1;
			while (left < right) {
				if (i == left) left++;
				if ( i == right) right--;
				if ( (nums[left] + nums[right] + nums[i]) > 0 )
					right--;
				else if ( (nums[left] + nums[right] + nums[i]) < 0 )
					left++;
				else {
					//System.out.println("i: " + i + " left: " + left + " right: " + right);
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(nums[left]);
					arr.add(nums[right]);
					arr.add(nums[i]);
					Collections.sort(arr);
					ans.add(arr);
					left++;
					right--;
				}
			}
		}
		results.addAll(ans);
		return results;
    }
	/* Method 2: https://www.youtube.com/watch?v=qJSPYnS35SE by Nick White
		
	*/
	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> output_arr = new LinkedList<>();
		
		for (int i = 0; i < nums.length - 2; i++) {
			// skip the duplicates
			// or "if ( i == 0 || ( i > 0 && nums[i] == nums[i - 1])) {continue;} "
			if ( i == 0 || ( i > 0 && nums[i] != nums[i - 1])) {  
				int low = i + 1;
				int high = nums.length - 1;
				int sum = 0 - nums[i];
				
				while ( low < high ) {
					if (nums[low] + nums[high] == sum) {
						output_arr.add(Arrays.asList(nums[i], nums[low],nums[high]));
						
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
		return output_arr;
	}
}
