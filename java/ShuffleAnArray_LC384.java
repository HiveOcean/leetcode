/*
	https://leetcode.com/problems/shuffle-an-array/
	Shuffle an Array - LeetCode #384
	
	Given an integer array nums, design an algorithm to randomly shuffle the 
	array.

	Implement the Solution class:
		* Solution(int[] nums) Initializes the object with the integer array 
		  nums.
		* int[] reset() Resets the array to its original configuration and 
		  returns it.
		* int[] shuffle() Returns a random shuffling of the array.
		 

	Example 1:
		Input:
			["Solution", "shuffle", "reset", "shuffle"]
			[[[1, 2, 3]], [], [], []]
		Output:
			[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

		Explanation:
			Solution solution = new Solution([1, 2, 3]);
			solution.shuffle();    // Shuffle the array [1,2,3] and return its 
								   // result. Any permutation of [1,2,3] must be 
								   // equally likely to be returned. 
								   // Example: return [3, 1, 2]
								   
			solution.reset();      // Resets the array back to its original 
								   // configuration [1,2,3]. Return [1, 2, 3]
								   
			solution.shuffle();    // Returns the random shuffling of array 
								   // [1,2,3]. Example: return [1, 3, 2]
	 

	Constraints:
		* 1 <= nums.length <= 200
		* -10^6 <= nums[i] <= 10^6
		* All the elements of nums are unique.
		* At most 5 * 10^4 calls will be made to reset and shuffle.

	Solution reference:
	- use Fisher Yates Shuffle algorithm
	https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
	
*/
import java.util.*;

public class ShuffleAnArray_LC384 {
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
	int[] array;
	int[] original;
	
   // public Solution(int[] nums) {
	public ShuffleAnArray_LC384(int[] nums) {
        array = nums;
		original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
		original = original.clone();
		return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
		Random r = new Random();
		//System.out.println("Array Length: " + array.length);
		int swapIndex, temp;
		
		for (int i = array.length - 1; i > 0 ; i--) {
			swapIndex = r.nextInt(i+1);
			temp = array[i];
			array[i] = array[swapIndex];
			array[swapIndex] = temp;
		}
        return array;
    }
	public static void main(String[] args) {
		int[][] input = {{1,2,3}, {-2,-10,9,15}};
		
		ShuffleAnArray_LC384 arrayQ = new ShuffleAnArray_LC384(input[1]);
		
		System.out.println("\nShuffle: ");
		int[] output = arrayQ.shuffle();
		for (int i : output)
			System.out.print(i + " ");
		
		System.out.println("\nReset: ");
		output = arrayQ.reset();
		for (int i : output)
			System.out.print(i + " ");
		
		System.out.println("\nShuffle: ");
		output = arrayQ.shuffle();
		for (int i : output)
			System.out.print(i + " ");
	}
}

