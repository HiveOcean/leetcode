/*
	https://leetcode.com/problems/decompress-run-length-encoded-list/
	1313. Decompress Run-Length Encoded List
	
	We are given a list nums of integers representing a list compressed with 
	run-length encoding.

	Consider each adjacent pair of elements [freq, val] = [nums[2*i], 
	nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements 
	with value val concatenated in a sublist. Concatenate all the sublists 
	from left to right to generate the decompressed list.

	Return the decompressed list.

	Example 1:
		Input: nums = [1,2,3,4]
		Output: [2,4,4,4]
		Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate 
		the array [2].
		The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
		At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
	
	Example 2:
		Input: nums = [1,1,2,3]
		Output: [1,3,3]
	 

	Constraints:
		2 <= nums.length <= 100
		nums.length % 2 == 0
		1 <= nums[i] <= 100

*/
import java.util.*;

public class DecompressRunLengthEncodedList_LC1313 {
    public int[] decompressRLElist(int[] nums) {
        //int freq, val;
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < nums.length / 2; i++) {
			// freq = nums[2*i];
			// val = nums[2*i+1];
			for (int j =0; j < nums[2*i]; j++)
				ans.add(nums[2*i + 1]);
		}
		return ans.stream().mapToInt(i -> i).toArray();
		
    }
	public static void main(String[] args) {
		DecompressRunLengthEncodedList_LC1313 drlel = new DecompressRunLengthEncodedList_LC1313();
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {1,1,2,3};
		
		System.out.println(Arrays.toString(nums1) + " decompress to " +
					Arrays.toString(drlel.decompressRLElist(nums1)));
		
		System.out.println(Arrays.toString(nums2) + " decompress to " +
					Arrays.toString(drlel.decompressRLElist(nums2)));
		
	}
}