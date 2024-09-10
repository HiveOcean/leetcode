"""
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced
to get t.

All occurrences of a character must be replaced with another character
while preserving the order of characters. No two characters may map to
the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true

Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

 Solution:
	 * 1- Consider a mapping table that maps each char from the first string to one and only char in the second string.
	 * 2- Consider a mappedBefore table that record each char from the second string that is already related to a char from the first string.
	 * 3- Read characters of the first string one by one.
	 * 4- If the read char from the first string is in the mapping table get its mapping.
	 * 5- Read the related char from the second string.
	 * 6- If the mapping and the read char from the second string are not the same return false.
	 * 7- Else If the read char from the first string does not exist in the mapping table,
	 *    1- read the related char from the second string,
	 *    2- If the char exist in the mappedBefore table, return false.
	 *    3- Else, add the read char from the first table and the read char from the second table to the mapping table.
	 * 8- Go to 3- and continue.
	 * 9 - Return true.


https://www.youtube.com/watch?v=7yF-U1hLEqQ
in example 1: the two maps should be
mapST = {'e':'a', 'g':'d'}
mapTS = {'a':'e', 'd':'g'}
in example 2: the two maps should be
mapST = {'f':'b', 'o':'a', 'o':'r'} -> false as both a and r cannot map to o
mapTS = {'b':'f', 'a':'o', 'r':'o'}
"""

class IsomorphicStrings_LC205:
    def isIsomorphic(self, s: str, t: str) -> bool:

        mapST, mapTS = {}, {}
        
        for c1, c2 in zip(s, t):
            #print(c1, " ", c2)
            if ((c1 in mapST and mapST[c1] != c2) or
                (c2 in mapTS and mapTS[c2] != c1)):
                return False
            mapST[c1] = c2
            mapTS[c2] = c1

        return True


myTest = IsomorphicStrings_LC205()
s1, t1 = "egg", "add"
print("Is ", s1, " and " , t1, " isomorphic? ", myTest.isIsomorphic(s1, t1))


s2, t2 = "foo", "bar"
print("Is ", s2, " and " , t2, " isomorphic? ", myTest.isIsomorphic(s2, t2))


s3, t3 = "paper", "title"
print("Is ", s3, " and " , t3, " isomorphic? ", myTest.isIsomorphic(s3, t3))
