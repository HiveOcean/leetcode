/*
	https://leetcode.com/problems/kth-largest-element-in-an-array/
	Kth Largest Element in an Array - LeetCoder #215
	
	Find the kth largest element in an unsorted array. Note that it is the kth 
	largest element in the sorted order, not the kth distinct element.

	Example 1:
		Input: [3,2,1,5,6,4] and k = 2
		Output: 5
		
	Example 2:
		Input: [3,2,3,1,2,4,5,5,6] and k = 4
		Output: 4
		
	Note:
		You may assume k is always valid, 1 ≤ k ≤ array's length.
	
	Solution Reference:
	Method 1: myself
	Method 2: Heap 
		https://www.youtube.com/watch?v=htqsw5NQMo4
		- Binary Heap, min Heap / max Heap https://www.geeksforgeeks.org/binary-heap/
		- min Heap implementation use a pirority queue and keep the size to 2
		(https://www.geeksforgeeks.org/priority-queue-class-in-java-2/)
		
		https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
		
*/
import java.util.*;

public class KthLargestElementInArray_LC215 {
	public static void main(String[] args) {
		KthLargestElementInArray_LC215 element = new KthLargestElementInArray_LC215();
		
		int[][] input = {{3,2,1,5,6,4},{3,2,3,1,2,4,5,5,6},{1, 23, 12, 9, 30, 2, 50}};
		int[] kth = {2,4,3};
		
		System.out.println("Method 2: ");
		for (int i = 0; i < input.length; i++ ) {
			System.out.print("[ ");
			for (int j: input[i]) {
				System.out.print(j + " ");
			}
			System.out.println("] " + kth[i] + "th largest element is: " 
				+ element.findKthLargest2(input[i], kth[i]));
		}
		
		System.out.println("Method 1: ");
		for (int i = 0; i < input.length; i++ ) {
			System.out.print("[ ");
			for (int j: input[i]) {
				System.out.print(j + " ");
			}
			System.out.println("] " + kth[i] + "th largest element is: " 
				+ element.findKthLargest1(input[i], kth[i]));
		}
		
	}
    public int findKthLargest1(int[] nums, int k) {
		// Method 1: sort the array. but the array's order has changed!
		Arrays.sort(nums);
			
        return nums[nums.length - k];
    }
	public int findKthLargest2(int[] nums, int k) {
		// Method 2: min heap
		PriorityQueue<Integer> priorityQ = new PriorityQueue<>();
		
		for (int i = 0; i < nums.length; i++) {
			priorityQ.add(nums[i]);
			if ( priorityQ.size() > k )
				priorityQ.poll();
		}
		return priorityQ.peek();
	}
}