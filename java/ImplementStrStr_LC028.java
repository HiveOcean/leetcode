/*
	https://leetcode.com/problems/implement-strstr/
	Implement strStr() - LeetCode #28 Easy
	
	Implement strStr().

	Return the index of the first occurrence of needle in haystack, or -1 if needle 
	is not part of haystack.

	Clarification:

	What should we return when needle is an empty string? This is a great question 
	to ask during an interview.

	For the purpose of this problem, we will return 0 when needle is an empty string. 
	This is consistent to C's strstr() and Java's indexOf().	 

	Example 1:
		Input: haystack = "hello", needle = "ll"
		Output: 2
	
	Example 2:
		Input: haystack = "aaaaa", needle = "bba"
		Output: -1
		
	Example 3:
		Input: haystack = "", needle = ""
		Output: 0
	 
	Constraints:
		0 <= haystack.length, needle.length <= 5 * 104
		haystack and needle consist of only lower-case English characters.

*/

public class ImplementStrStr_LC028 {
	public static void main(String[] args) {
		String[] haystacks = {"hello", "aaaaa", ""};
		String[] needles = {"ll", "bba", ""};
		
		for (int i = 0; i < haystacks.length; i++) {
			System.out.println(strStr(haystacks[i], needles[i]));
		}
	
	}
	public static int strStr(String haystack, String needle) {
		
		if (needle.length() == 0  || haystack.length() == 0) return 0;
		
		int index = -1, len = needle.length();
		
		for (int i = 0; i < haystack.length(); i++) {
			if ( haystack.charAt(i) == needle.charAt(0) ) {
				if ( haystack.substring(i, i + len).equals(needle))
					return i;
			}
		}
		
        return index;
    }
}