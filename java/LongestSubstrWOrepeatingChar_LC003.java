/*
	https://leetcode.com/problems/longest-substring-without-repeating-characters/
	Longest Substring Without Repeating Characters - LeetCode 003
	
	Given a string s, find the length of the longest substring without repeating 
	characters.

	Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
	
	Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
	
	Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
			Notice that the answer must be a substring, "pwke" is a subsequence and 
			not a substring.
	
	Example 4:
		Input: s = ""
		Output: 0
	 
	Constraints:
		0 <= s.length <= 5 * 104
		s consists of English letters, digits, symbols and spaces.

*/

import java.util.*;

public class LongestSubstrWOrepeatingChar_LC003 {
	public static void main(String[] args) {
		String[] data = {"abcabcbb", "bbbbb", "pwwkew", "","defhgi"};
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + " with longest unique char substring: " + 
				lengthOfLongestSubstring(data[i]));
		}
	}
    public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> hm = new HashMap<>();
		int longestSubstrLen = 0, substrLen = 0;
		
		if (s.length() == 0) return longestSubstrLen;
		
		for (int i = 0; i < s.length(); i++) {
			if ( hm.containsKey(s.charAt(i)) ) {	// repeating char found
				longestSubstrLen = Math.max(longestSubstrLen, hm.size());
				hm.clear();
				hm.put(s.charAt(i), 1);	
			} else {
				hm.put(s.charAt(i), 1);
			}
		}
		longestSubstrLen = Math.max(longestSubstrLen, hm.size());
        return longestSubstrLen;
    }
}