/*
	https://leetcode.com/problems/intersection-of-two-arrays-ii/
	Intersection Of Two Arrays II - LeetCode #350
	
	Given two arrays, write a function to compute their intersection.

	Example 1:
		Input: nums1 = [1,2,2,1], nums2 = [2,2]
		Output: [2,2]
	
	Example 2:
		Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		Output: [4,9]
		
	Note:

	* Each element in the result should appear as many times as it shows in both 
	  arrays.
	* The result can be in any order.
	
	Follow up:
	* What if the given array is already sorted? How would you optimize your 
	  algorithm?
	* What if nums1's size is small compared to nums2's size? Which algorithm 
	  is better?
	* What if elements of nums2 are stored on disk, and the memory is limited 
	  such that you cannot load all elements into the memory at once?
		
		
	Reference: 
	https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
	There are three methods.
	Method1: 
		Union: 
		1.	Initialize union U as empty.
		2.	Copy all elements of first array to U.
		3.	Do following for every element x of second array:
			1. If x is not present in first array, then copy x to U.
		4.	Return U.
		
		Intersection: 
		1.	Initialize intersection I as empty.
		2.	Do following for every element x of first array
			1. If x is present in second array, then copy x to I.
		3.	Return I.
		
		Time complexity of this method is O(mn) for both operations. 
		Here m and n are number of elements in arr1[] and arr2[] respectively.
		
	Method 2 (Use Sorting) 

		1. Sort arr1[] and arr2[]. This step takes O(mLogm + nLogn) time.
		2. Use O(m + n) algorithms to find union and intersection of two sorted arrays.
		
		Where O(m + n) algorithm at 
		https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
		
		Overall time complexity of this method is O(mLogm + nLogn).
		
	Method 3 (Use Sorting and Searching) 
		Union: 
		1. Initialize union U as empty.
		2. Find smaller of m and n and sort the smaller array.
		3. Copy the smaller array to U.
		4. For every element x of larger array, do following
			1. Binary Search x in smaller array. If x is not present, then copy it to U.
		5. Return U. 
		
		Intersection: 
		1. Initialize intersection I as empty.
		2. Find smaller of m and n and sort the smaller array.
		3. For every element x of larger array, do following
			1. Binary Search x in smaller array. If x is present, then copy it to I.
		4. Return I.
		
		Time complexity of this method is min(mLogm + nLogm, mLogn + nLogn) which 
		can also be written as O((m+n)Logm, (m+n)Logn). This approach works much 
		better than the previous approach when difference between sizes of two 
		arrays is significant.

*/
import java.util.*;

public class IntersectionOfTwoArraysII_LC350 {
	public static void main(String[] args) {
		int[][] data = {{1,2,2,1},{2,2},{4,9,5},{9,4,9,8,4}};
		
		// Use Method 2
		int[] common = intersect2(data[0], data[1]);
		int[] common2 = intersect2(data[2], data[3]);
		
		// print out the result
		printOutput(common, data[0],data[1]); 
		printOutput(common2, data[2],data[3]);
	}
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // Method 2, sort the two arrays which takes O(n log(n) + m log(m))
		int pointer1 = 0;
		int pointer2 = 0;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> intersect = new LinkedList<>();
		
		while (pointer1 < nums1.length && pointer2 < nums2.length) {
			if (nums1[pointer1] < nums2[pointer2]) {
				pointer1++;
			} else if (nums2[pointer2] < nums1[pointer1]) {
				pointer2++;
			} else {
				intersect.add(nums1[pointer1++]);
				pointer2++;
			}
		}
		int[] ans = new int[intersect.size()];
		int index = 0;
		
		for (Integer i : intersect) {
			ans[index++] = i;
		}
		
		return ans;

    }
	public static void printOutput(int[] common, int[] data1, int[] data2) {
		System.out.print("Intersect of two arrays: [ ");
		for (int i : data1)
			System.out.print(i + " ");
		System.out.print("] and [ ");
		for (int n : data2)
			System.out.print(n + " ");
		
		System.out.print("] is [ ");
		for (int j: common) {
			System.out.print(j + " ");
		}
		System.out.println("]");
		
	}
}