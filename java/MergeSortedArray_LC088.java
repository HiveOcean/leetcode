/*
	https://leetcode.com/problems/merge-sorted-array/
	Merge Sorted Array - LeetCode #88 Easy
	
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as 
	one sorted array.

	Note:

	* The number of elements initialized in nums1 and nums2 are m and n respectively.
	* You may assume that nums1 has enough space (size that is equal to m + n) to 
	  hold additional elements from nums2.
	
	Example:
		Input:
		nums1 = [1,2,3,0,0,0], m = 3
		nums2 = [2,5,6],       n = 3

		Output: [1,2,2,3,5,6]

*/

public class MergeSortedArray_LC088 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3, n = 3;
		
		merge(nums1, m, nums2, n);
		for (int i : nums1)
			System.out.print(" " + i);
	}
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = nums1.length - 1;
		m -= 1;
		n -=1;
		while (i >= 0) {
			if ( n <= -1) {
				while ( m >= 0 ) {
					nums1[i] = nums1[m];
					m--;
				}
			}
			if ( m <= -1) {
				while ( n >= 0 ) {
					nums1[i] = nums2[n];
					n--;
				}
			}
			if ( m >=0 && nums1[m] >= nums2[n] ) {
				nums1[i] = nums1[m];
				m--;
			} else if ( n >= 0 && nums1[m] < nums2[n] ) {
				nums1[i] = nums2[n];
				n--;
			} 
			i--;
		}
    }
}