/*
	Medium #442 Find All Duplicates In an Array
	
	Given an array of integers, 1 <= a[i] <= n (n = size of array), 
	some elements appear twice and others appear once.
	
	Find all the elements that appear twice in this array.
	Could you do it without extra space and in O(n) runtime?
	
	Example:
		Input: [4,3,2,7,8,2,3,1]
		Output: [2,3]
		Input: [3,3,2,5,1]
		Output: [3]
		Input: [7,6,3,4,2,1,5]
		Output: []
		Input: [8,7,2,1,1,2,7,8]
		Output: [1,2,7,8]
		
	Solution: (from Youtube Nick White Channel)
	- Since n is the size of the array, it must be the biggest value in array.
	- Hence n - 1 is the last index of the array.  And all other elements in the
	  array must fall into 0 to last index of the array.
	- read the array and the array[i] - 1 must fall into a slot in the array
	- flip this array[i - 1] into a negative number.  When you read another element
	  in the array which fall into this index of array, you find it negative value,
	  means it appeared once already (means now it is the duplicate value), now 
	  add this to the ans[].
*/
import java.util.*;

public class FindDuplicatesInArray_LC442
{
	public static void main(String[] args) {
		int[][] array = {{4,3,2,7,8,2,3,1},
				   {3,3,2,5,1},
				   {7,6,3,4,2,1,5},
				   {8,7,2,1,1,2,7,8}};
		List<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < array.length; i++) {
			ans = findDupInArray(array[i]);
			
			System.out.print("[ ");
			for (int k: ans) {
				
				System.out.print(k + " ");
			}
			System.out.println("]");
		}	   
	}
	public static List<Integer> findDupInArray(int[] array) {
		List<Integer> ans = new ArrayList<>();
		int idx;
		for (int i = 0; i < array.length; i++) {
			idx = Math.abs(array[i]) - 1;
			if ( array[idx] > 0) {
				array[idx] = -array[idx];
			} else {
				ans.add(Math.abs(array[i]));
			}
		}
		return ans;
	}
}
