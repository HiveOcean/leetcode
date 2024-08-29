"""
169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 10**4
-10**9 <= nums[i] <= 10**9

Follow-up: Could you solve the problem in linear time and in O(1) space?

"""

class MajorityElement_LC0169:
    def majorityElement(self, nums: list[int]) -> int:
        nums_dict = {}
        half = len(nums) /2

        for num in nums:
            #print(num, end=' ')
            if num in nums_dict.keys():
                nums_dict[num] += 1
            else:
                nums_dict[num] = 1
            if nums_dict[num] > half:
                print ('FOUND')
                return num

        return max(nums_dict, key=nums_dict.get)


myTest = MajorityElement_LC0169()

nums1 = [3,2,3]
print(nums1, " majority element is ", myTest.majorityElement(nums1))
nums2 = [2,2,1,1,1,2,2]
print(nums2, " majority element is ", myTest.majorityElement(nums2))
