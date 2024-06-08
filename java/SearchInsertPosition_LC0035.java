/*
	https://leetcode.com/problems/search-insert-position/
	35. Search Insert Position (Easy)
	
	Given a sorted array of distinct integers and a target value, 
	return the index if the target is found. If not, return the 
	index where it would be if it were inserted in order.

	You must write an algorithm with O(log n) runtime complexity.


	Example 1:
		Input: nums = [1,3,5,6], target = 5
		Output: 2

	Example 2:
		Input: nums = [1,3,5,6], target = 2
		Output: 1

	Example 3:
		Input: nums = [1,3,5,6], target = 7
		Output: 4

	Example 4:
		Input: nums = [1,3,5,6], target = 0
		Output: 0

	Example 5:
		Input: nums = [1], target = 0
		Output: 0
	 

	Constraints:
	1 <= nums.length <= 10^4
	-10^4 <= nums[i] <= 10^4
	nums contains distinct values sorted in ascending order.
	-10^4 <= target <= 10^4

	Related Topics:
		Array, Binary Search
*/
import java.util.*;

public class SearchInsertPosition_LC0035 {
    public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1,mid;
		
		while (left <= right) {
			mid = (left + right) / 2;
			
			if (nums[mid] < target) 
				left = mid + 1;
			else if (nums[mid] > target) 
				right = mid - 1;
			else
				return mid;
		}
		return left ;
 
    }
	public static void main(String[] args) {
		SearchInsertPosition_LC0035 insertPos = new SearchInsertPosition_LC0035();
		
		int[] nums1 = {1,3,5,6};
		int target1 = 5;
		System.out.println(target1 + " is at " + insertPos.searchInsert(nums1,target1));
		
		int[] nums2 = {1,3,5,6};
		int target2 = 2;
		System.out.println(target2 + " is at " + insertPos.searchInsert(nums2,target2));


		int[] nums3 = {1,3,5,6};
		int target3 = 7;
		System.out.println(target3 + " is at " + insertPos.searchInsert(nums3,target3));

		int[] nums4 = {1,3,5,6};
		int target4 = 0;
		System.out.println(target4 + " is at " + insertPos.searchInsert(nums4,target4));

	}
}
	
	
	