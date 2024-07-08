/*
	https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
	https://goodtecher.com/leetcode-159-longest-substring-with-at-most-two-distinct-characters/
	
	159. Longest Substring with At Most Two Distinct Characters
	
	Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

	Example 1:
		Input: "eceba"
		Output: 3
		Explanation: tis "ece" which its length is 3.
		
	Example 2:
		Input: "ccaabbb"
		Output: 5
		Explanation: tis "aabbb" which its length is 5.

	Ref:
		https://github.com/grandyang/leetcode/issues/159
		https://goodtecher.com/leetcode-159-longest-substring-with-at-most-two-distinct-characters/
		https://www.baeldung.com/cs/sliding-window-algorithm
		
*/
import java.util.*;

public class LongestSubStringWithAtMostTwoDistinctCharacters_LC0159 {
	// Method 1: 
	public int lengthOfLongestSubstringTwoDistinct1(String s) {
		
		if (s.length() == 0) return 0;
		ArrayList<Character> distinctCnt = new ArrayList<Character>();
		
		int left = 0, right = 0, maxLength = 0;
		
		for (int i = 0; i < s.length(); i++)  {
			//System.out.println("L: " + left + " R: " + right + " i: " + i + " " +s.charAt(i));
			if (!distinctCnt.contains(s.charAt(i)) && distinctCnt.size() < 2) {
				distinctCnt.add(s.charAt(i));
				right++;
			} else if (distinctCnt.contains(s.charAt(i))) {
				right++;
			} else {// the third character
				maxLength = Math.max(maxLength, right - left);
				distinctCnt.clear();
				// take the prev character as the first distinct character
				// and find the index of this prev character looking backward
				int prev = right - 1;
				while (s.charAt(right - 1) == s.charAt(prev)) {
					prev--;
				}
				left = prev + 1;
				i = prev;
				right = left;				
			}
			
		}
		maxLength = Math.max(maxLength, right - left);
		return maxLength;
	}
	public static void main(String[] args) {
		LongestSubStringWithAtMostTwoDistinctCharacters_LC0159 longestSubStr = 
			new LongestSubStringWithAtMostTwoDistinctCharacters_LC0159();
			
		String input1 = "eceba";
		String input2 = "ccaabbb";
		String input3 = "abcdefgh";
		String input4 = "";
		System.out.println(input1 + " longest substr with most two distinct char: " +
			longestSubStr.lengthOfLongestSubstringTwoDistinct1(input1));
		
		System.out.println(input2 + " longest substr with most two distinct char: " +
			longestSubStr.lengthOfLongestSubstringTwoDistinct1(input2));
			
		System.out.println(input3 + " longest substr with most two distinct char: " +
			longestSubStr.lengthOfLongestSubstringTwoDistinct1(input3));
			
		System.out.println(input4 + " longest substr with most two distinct char: " +
			longestSubStr.lengthOfLongestSubstringTwoDistinct1(input4));
	}
}

