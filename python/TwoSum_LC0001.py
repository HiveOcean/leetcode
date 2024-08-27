"""
1. Two Sum

Given an array of integers nums and an integer target, return indices of
the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may
not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2)
time complexity?

"""

class TwoSum_LC001:
    def twoSum(self, nums: list[int], target: int) -> list[int]:

        for idx, num in enumerate(nums):
            value = target - num
            if value in nums and nums.index(value) != idx:
                second_idx = nums.index(value)
                print(idx, second_idx)
                return [idx, second_idx]

        return []


myTest = TwoSum_LC001()


nums1, t1 = [2,7,11,15], 9
print(f"The indexs are: {list(myTest.twoSum(nums1, t1))}")

nums2, t2 = [3,2,4], 6
print(f"The indexs are: {list(myTest.twoSum(nums2, t2))}")
           
nums3, t3 = [3,3], 6
print(f"The indexs are: {list(myTest.twoSum(nums3, t3))}")

nums4, t4 = [2,3,4,5], 20
print(f"The indexs are: {list(myTest.twoSum(nums4, t4))}")
