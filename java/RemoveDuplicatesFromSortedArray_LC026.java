/*
	https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	Given a sorted array nums, remove the duplicates in-place such that each element 
	appears only once and returns the new length.

	Do not allocate extra space for another array, you must do this by modifying the 
	input array in-place with O(1) extra memory.

	Clarification:

	Confused why the returned value is an integer but your answer is an array?

	Note that the input array is passed in by reference, which means a modification 
	to the input array will be known to the caller as well.

	Internally you can think of this:

	// nums is passed in by reference. (i.e., without making a copy)
	int len = removeDuplicates(nums);

	// any modification to nums in your function would be known by the caller.
	// using the length returned by your function, it prints the first len elements.
	for (int i = 0; i < len; i++) {
		print(nums[i]);
	}
	 

	Example 1:
		Input: nums = [1,1,2]
		Output: 2, nums = [1,2]
		Explanation: Your function should return length = 2, with the first two elements 
		of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the 
		returned length.
	
	Example 2:
		Input: nums = [0,0,1,1,1,2,2,3,3,4]
		Output: 5, nums = [0,1,2,3,4]
		Explanation: Your function should return length = 5, with the first five elements 
		of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what 
		values are set beyond the returned length.
	 
	Constraints:
		0 <= nums.length <= 3 * 10e4
		-10e4 <= nums[i] <= 10e4
		nums is sorted in ascending order.
*/

public class RemoveDuplicatesFromSortedArray_LC026 {
	public static void main(String[] args) {
		int[][] arrays = {{1,1,2},
						 {4,6,6,6},
						 {-3,0,0,5,5,9,11,11,14,14},
						 {1,2,4,7,9,25},
						 {0,0,1,1,1,2,2,3,3,4}};
		
		for (int i = 0; i < arrays.length; i++) {
			int len = rmDuplicates(arrays[i]);
			
			for (int j = 0; j < len; j++)
				System.out.print(arrays[i][j] + " ");
			
			System.out.println();
		}
	}
	public static int rmDuplicates(int[] array) {
		if (array.length == 0) return 0;
		
		int len = 1;
		// pointer point to next insert position
		// current is the next nonduplicate position
		int current = 0, pointer = current + 1, next = current + 1;
		
		while (current < array.length - 1) {
			while (next < array.length && array[current] == array[next]) {
				next++;
			}
			if (next < array.length) {  // for same values at the tail e.g. {4,6,6,6}, next will be 4
				array[pointer++] = array[next];
				len++;
				current = next;		// skip all the duplicates and start from next nonduplicate element
				next = current + 1;
			} else
				break;
		}
		
		return len;
		
	}
}