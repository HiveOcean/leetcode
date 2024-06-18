/*
	https://leetcode.com/problems/missing-ranges/
	https://www.goodtecher.com/leetcode-163-missing-ranges/
	163. Missing Ranges
	
	Given a sorted integer array nums, where the range of elements are in the 
	inclusive range [lower, upper], return its missing ranges.
	
	A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

	Return the smallest sorted list of ranges that cover every missing number 
	exactly. That is, no element of nums is in any of the ranges, and each
	missing number is in one of the ranges.

	Each range [a,b] in the list should be output as:
		"a->b" if a != b
		"a" if a == b
		
	Example 1:
		Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
		Output: ["2", "4->49", "51->74", "76->99"]
		Explanation: The ranges are:
			[2,2] --> "2"
			[4,49] --> "4->49"
			[51,74] --> "51->74"
			[76,99] --> "76->99"
			
	Example 2:
		Input: nums = [], lower = 1, upper = 1
		Output: ["1"]
		Explanation: The only missing range is [1,1], which becomes "1".

	Example 3:
		Input: nums = [], lower = -3, upper = -1
		Output: ["-3->-1"]
		Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
		
	Example 4:
		Input: nums = [-1], lower = -1, upper = -1
		Output: []
		Explanation: There are no missing ranges since there are no missing numbers.
		
	Example 5:
		Input: nums = [-1], lower = -2, upper = -1
		Output: ["-2"]

	Constraints:
		-10^9 <= lower <= upper <= 10^9
		0 <= nums.length <= 100
		lower <= nums[i] <= upper
		All the values of nums are unique.

*/
import java.util.*;

public class FindMissingRanges_LC0163 {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		
		if (nums.length == 0) {
			result.add(composeRange(lower, upper));
			return result;
		}
		if (nums[0] > lower) {
			result.add(composeRange(lower, nums[0] - 1));
		}
		if (nums.length > 1) {
			for (int i = 0; i < nums.length - 1; i++) {
				
				if ( nums[i + 1] - nums[i] == 1) 
					continue;
				else {
					result.add(composeRange(nums[i] + 1, nums[i+1]-1));
				}
			}	
		}
		if (nums[nums.length - 1] < upper) {
				result.add(composeRange(nums[nums.length - 1] + 1,upper));
		}
		return result;
	}
	private String composeRange(int start, int end) {
		
		if (start == end) 
			return Integer.toString(start);
		else {
			String s = start + "->" + end;
			return s;
		}
	}
	public static void main(String[] args) {
		FindMissingRanges_LC0163 ranges = new FindMissingRanges_LC0163();
		
		int[] nums1 = {0,1,3,50,75};
		List<String> ans1 = ranges.findMissingRanges(nums1, 0, 99);
		System.out.println(Arrays.toString(ans1.toArray()));
		
		int[] nums2 = {};
		List<String> ans2 = ranges.findMissingRanges(nums2, 1, 1);
		System.out.println(Arrays.toString(ans2.toArray()));
		
		int[] nums3 = {};
		List<String> ans3 = ranges.findMissingRanges(nums3, -3, -1);
		System.out.println(Arrays.toString(ans3.toArray()));
		
		int[] nums4 = {-1};
		List<String> ans4 = ranges.findMissingRanges(nums4, -1, -1);
		System.out.println(Arrays.toString(ans4.toArray()));
		
		int[] nums5 = {-1};
		List<String> ans5 = ranges.findMissingRanges(nums5, -2, -1);
		System.out.println(Arrays.toString(ans5.toArray()));
	}
}