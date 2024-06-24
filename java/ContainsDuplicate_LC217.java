/*
	https://leetcode.com/problems/contains-duplicate/
	Contains Duplicate - LeetCode #217
	
	Given an array of integers, find if the array contains any duplicates.

	Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

	Example 1:
		Input: [1,2,3,1]
		Output: true
	
	Example 2:
		Input: [1,2,3,4]
		Output: false

	Example 3:
		Input: [1,1,1,3,3,4,3,2,4,2]
		Output: true
	
	

*/
import java.util.*;

public class ContainsDuplicate_LC217 {
	public static void main(String[] args) {
		int[][] data = {{1,2,3,1},{1,2,3,4},{1,1,1,3,3,4,3,2,4,2}};
		
		for (int i = 0; i < data.length; i++) {
			System.out.print("[ ");
			for (int k : data[i])
				System.out.print(k + " ");
			System.out.println("] contains duplicate? " + containsDuplicate(data[i]));
		}
	}
    public static boolean containsDuplicate(int[] nums) {
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < nums.length; i++) {
			if ( list.contains(nums[i]) ) {
				return true;
			} else {
				list.add(nums[i]);
			}
		}
        return false;
    }
}