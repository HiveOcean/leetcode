"""
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and
false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of
a different word or phrase, typically using all the original letters
exactly once.

 
Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5 * 10**4
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters?
How would you adapt your solution to such a case?



"""

class ValidAnagram_LC242:
    def isAnagram(self, s: str, t: str) -> bool:
        array1 = [0] * 26
        array2 = [0] * 26
        
        for letter1 in s:
            pos1 = ord(letter1) - ord('a')
            array1[pos1] = array1[pos1] + 1
        for letter2 in t:
            pos2 = ord(letter2) - ord('a')
            array2[pos2] = array2[pos2] + 1
        
        return array2 == array1


myTest = ValidAnagram_LC242()

s1 = "anagram"
t1 = "nagaram"
print(s1, " and ", t1, " is anagram? ", myTest.isAnagram(s1, t1))

s2 = "rat"
t2 = "car"
print(s2, " and ", t2, " is anagram? ", myTest.isAnagram(s2, t2))
