"""
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array
of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.


Solution:
From disscussion.
Note: Assume that to find the longest common prefix means if it does exist,
      it will be the prefix of ALL elements in the array.
      Hence, find the min and max in the array will cover every elements
      in between. e.g ['1','11','1112','12'], min is '1' and max is '12',
      every elements in between must have prefix'1'
      ['1','11','1112','1114'], min is '1', max is '113'

      ["dog","racecar","car"], min is 'car', max is 'racecar'
      No matter what we can just use min and max to compare to find
      prefix.  If prefix exist, the min must be substring of max.
      we do character by character comparison and terminate when no
      more match find. 
      
      In the case of no prefix, it will return s1(:0) whichh is ''
      

"""

class LongestCommonPrefix_LC0014:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs: return ''

        s1 = min(strs)
        s2 = max(strs)

        print(f"Min: {s1}  Max: {s2}")
        for i, c in enumerate(s1):
            if c != s2[i]:
                return s1[:i]
        return s1


myTest = LongestCommonPrefix_LC0014()

str1 = ["flower","flow","flight"]

str2 = ["dog","racecar","car"]
print("Test2: ", myTest.longestCommonPrefix(str2))

str3 = ["abc", "abc", "abc"]
print("Test3: ", myTest.longestCommonPrefix(str3))

str4 = ['11','111','1112','1114']
print("Test4: ", myTest.longestCommonPrefix(str4))
