/*
	https://leetcode.com/problems/intersection-of-two-arrays/
	Intersection Of Two Arrays - LeetCode #349
	
	Given two arrays, write a function to compute their intersection.

	Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2]

	Example 2:
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [9,4]

	Note:
		* Each element in the result must be unique.
		* The result can be in any order.

*/
import java.util.*;

public class IntersectionOfTwoArrays_LC349 {
	public static void main(String[] args) {
		int[][] data = {{1,2,2,1},{2,2},{4,9,5},{9,4,9,8,4}};
		
		int[] common = intersection(data[0], data[1]);
		int[] common2 = intersection(data[2], data[3]);
		
		System.out.print("Intersect of two arrays: [ ");
		for (int i : data[0])
			System.out.print(i + " ");
		System.out.print("] and [ ");
		for (int n : data[1])
			System.out.print(n + " ");
		
		System.out.print("] is [ ");
		for (int j: common) {
			System.out.print(j + " ");
		}
		System.out.println("]");
		
		System.out.print("Intersect of two arrays: [ ");
		for (int i : data[2])
			System.out.print(i + " ");
		System.out.print("] and [ ");
		for (int n : data[3])
			System.out.print(n + " ");
		
		System.out.print("] is [ ");
		for (int j: common2) {
			System.out.print(j + " ");
		}
		System.out.println("]");
			
	}
    public static int[] intersection(int[] nums1, int[] nums2) {
		// Using hashset that will not add the duplicates.
		
		HashSet<Integer> set1 = new HashSet<>();	
		HashSet<Integer> intersect = new HashSet<>();
		
		for (Integer i : nums1) {
			set1.add(i);		// all unique elements in nums1 in the hashset
		}
		for (Integer k: nums2) {
			if (set1.contains(k))
				intersect.add(k);
		}
		int[] ans = new int[intersect.size()];
		int index = 0;
		
		for (Integer i : intersect) {
			ans[index++] = i;
		}
		
		return ans;
		
    }
}