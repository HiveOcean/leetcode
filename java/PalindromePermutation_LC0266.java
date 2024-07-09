/*
	https://leetcode.com/problems/palindrome-permutation/
	https://goodtecher.com/leetcode-266-palindrome-permutation/
	266. Palindrome Permutation
	
	Given a string s, return true if a permutation of the string could form a 
	palindrome.

	Example 1:
		Input: s = "code"
		Output: false
		
	Example 2:
		Input: s = "aab"
		Output: true
		
	Example 3:
		Input: s = "carerac"
		Output: true
		
	Constraints:
		1 <= s.length <= 5000
		s consists of only lowercase English letters.
	
	Hint:
		1. Consider the palindromes of odd vs even length. What difference do 
		   you notice?
		2. Count the frequency of each character.
		3. If each character occurs even number of times, then it must be a 
		   palindrome. How about character which occurs odd number of times?

*/

import java.util.*;

public class PalindromePermutation_LC0266 {
	public boolean findPermutePalindrome(String s) {
		HashMap<Character,Integer> hashmap = new HashMap<>();
		
		for (Character c: s.toCharArray()) {
			if (hashmap.containsKey(c))
				hashmap.remove(c);
			else
				hashmap.put(c,1);
		}
		if (hashmap.size() > 1)	
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		PalindromePermutation_LC0266 palindrome = new PalindromePermutation_LC0266();
		
		String s1 = "code";
		System.out.println(s1 + " is palindrome pemutation: " + palindrome.findPermutePalindrome(s1));
		String s2 = "aab";
		System.out.println(s1 + " is palindrome pemutation: " + palindrome.findPermutePalindrome(s2));
		String s3 = "carerac";
		System.out.println(s1 + " is palindrome pemutation: " + palindrome.findPermutePalindrome(s3));
		
	}
}		