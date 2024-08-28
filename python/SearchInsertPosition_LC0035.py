"""
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the
index if the target is found. If not, return the index where it would be
if it were inserted in order.

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

Constraints:

1 <= nums.length <= 10**4
-10**4 <= nums[i] <= 10**4
nums contains distinct values sorted in ascending order.
-10**4 <= target <= 10**4

"""

class SearchInsertPosition_LC0035:
    def searchInsert(self, nums: list[int], target: int) -> int:
        l, r = 0, len(nums)-1
        
        while l <= r :                # l <= mid, mid < r
            mid = l+(r-l)//2          # to avoid overflow if (l + r)// 2, l and r are very big
            if nums[mid] >= target:
                r = mid - 1
            else: l = mid + 1
        
        return l
        
        #mid = len(nums) / 2
        #if target == nums[mid]:
        #   return mid
        
        #if target < nums[mid]:
        #    searchInsert(nums[:mid], target)
        #else:
        #   searchInsert(nums[mid:], target)
        

myTest = SearchInsertPosition_LC0035()
nums1, t1 = [1,3,5,6], 5
nums2, t2 = [1,3,5,6], 2
nums3, t3 = [1,3,5,6], 7

print(list(nums1), " with target ", t1, " at index ", myTest.searchInsert(nums1, t1))
print(list(nums2), " with target ", t2, " at index ", myTest.searchInsert(nums2, t2))
print(list(nums3), " with target ", t3, " at index ", myTest.searchInsert(nums3, t3))
