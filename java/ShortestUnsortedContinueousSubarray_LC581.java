/*
	https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
	581. Shortest Unsorted Continuous Subarray
	
	Given an integer array nums, you need to find one continuous subarray that if 
	you only sort this subarray in ascending order, then the whole array will be 
	sorted in ascending order.

	Return the shortest such subarray and output its length.

	Example 1:
	Input: nums = [2,6,4,8,10,9,15]
	Output: 5
	Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
				whole array sorted in ascending order.
	Example 2:
	Input: nums = [1,2,3,4]
	Output: 0
	
	Example 3:
	Input: nums = [1]
	Output: 0
	 
	Constraints:

	1 <= nums.length <= 10e4
	-10e5 <= nums[i] <= 10e5

*/
import java.util.Arrays;

public class ShortestUnsortedContinueousSubarray_LC581 {
	public static void main(String[] args) {
		int[] input1 = {2,6,4,8,10,9,15};
		int output;
		
		output = shortestUnsortedContinueousSubarray1(input1);
		System.out.println("\nMethod 1 : " + output);
		
		output = shortestUnsortedContinueousSubarray2(input1);
		System.out.println("\nMethod 2 : " + output);
	}
	public static int shortestUnsortedContinueousSubarray2(int[] array) {
	/*	Method 2	O(n)
		Without using the extra Space!  
		Find the mismatch without using sorted array to do comparison.
		Using two loop to find the min and max of the unsorted elements.
		Then loop again to find the position of the min in the input array.
		and loop backforwar to find the position of the max in the input array.
		with the min element position and max element position, we return the length.
	*/
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = false;
		
		// find min among the unsorted elements
		for (int i = 1; i < array.length; i++) {		
			if (array[i - 1] > array[i])
				flag = true;
			if (flag)
				min = Math.min(min, array[i]);
		}
		
		flag = false;
		// find max among all the unsorted elements
		for (int j = array.length - 1; j > 0; j--) {		
			if (array[j] < array[j - 1])
				flag = true;
			if (flag)
				max = Math.max(max, array[j - 1]);
		}
		
		// find the index of where the min element should be in the array 
		for (int i = 0; i < array.length; i++) {
			if ( array[i] > min) {
				min = i;
				break;
			}
		}
		// find the index of where the max element should be in the array 
		for (int j = array.length - 1; j >= 0; j--) {
			if ( array[j] < max) {
				max = j;
				break;
			}
		}
		return max - min + 1;
	}
	public static int shortestUnsortedContinueousSubarray1(int[] array) {
	/*	Method 1	O(nlogn)
		Clone the input array and sorted it. Loop through the input array and
		compare with the sorted one.  As long as we see the elements from these
		two array is different, this could be the start index of the unsorted subarray.
		And find the final mismatch (end index), so we know the length of the unsorted subarray
		by subtract the start and end index.
	*/
		int[] sortedArray = array.clone();
		Arrays.sort(sortedArray);
		for (int j: sortedArray)
			System.out.print(" " + j);
		int startIndex = -1, endIndex=0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != sortedArray[i]) {
				if (startIndex == -1)
					startIndex = i;
				
				endIndex = i;
			}
		}
		System.out.println("\nStart and End are: " + startIndex + " " + endIndex);
		if (startIndex != -1)
			return endIndex - startIndex + 1;
		else
			return 0;
	}
}