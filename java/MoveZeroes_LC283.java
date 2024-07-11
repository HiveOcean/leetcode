/*
	https://leetcode.com/problems/move-zeroes/
	Move Zeroes - LeetCode #283 Easy
	
	Given an array nums, write a function to move all 0's to the end of it 
	while maintaining the relative order of the non-zero elements.

	Example:
		Input: [0,1,0,3,12]
		Output: [1,3,12,0,0]
	
	Note:
		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.
*/

public class MoveZeroes_LC283 {
	public static void main(String[] args) {
		//int[] nums = {0,1,0,3,12};
		//int[] nums = {2,1,4,5,6};
		int[] nums = {0,1,0,0,0};
		moveZeroes(nums);
		
		System.out.println();
		for (int i: nums)
			System.out.print(" " + i);
		
		System.out.println();
	}
	public static void moveZeroes(int[] nums) {
		
        int next;
		
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == 0) {
				next = i + 1;
				while ( nums[next] == 0 && next < nums.length -1){
					next++;
				}
				nums[i] = nums[next];
				nums[next] = 0;
			}
			//for (int k: nums)
			//System.out.print("*" + k);
		}
		
		/* https://www.youtube.com/watch?v=vP8-eaIo3is better solution
		int index = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			
			if (temp != 0) {
				nums[index] = temp;
				index++;
			}
		}
		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
		/*
    }
}