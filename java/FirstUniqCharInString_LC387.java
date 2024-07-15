/*
	https://leetcode.com/problems/first-unique-character-in-a-string/
	First Unique Character in a String - LeetCode #387 Easy
	
	Given a string, find the first non-repeating character in it and return its 
	index. If it doesn't exist, return -1.

	Examples:
		s = "leetcode"
		return 0.

		s = "loveleetcode"
		return 2.
 
	Note: You may assume the string contains only lowercase English letters.
	
*/
import java.util.*;


public class FirstUniqCharInString_LC387 {
	public static void main(String[] args) {
		String s1 = "leetcode";
		String s2 = "loveleetcode";
		String s3 = "abcabcabc";
		String s4 = "abcdefgh";
		
		System.out.println(s1 + " with first unique character at " + firstUniqChar(s1));
		System.out.println(s2 + " with first unique character at " + firstUniqChar(s2));
		System.out.println(s3 + " with first unique character at " + firstUniqChar(s3));
		System.out.println(s4 + " with first unique character at " + firstUniqChar(s4));
	}
    public static int firstUniqChar(String s) {
		LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			if ( !charMap.containsKey(s.charAt(i)) ) {
				charMap.put(s.charAt(i), 1);
			} else {
				int val = charMap.get(s.charAt(i));
				charMap.put(s.charAt(i),++val);
			}
		}
		
		Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
		int j = 0;
		for (Map.Entry<Character, Integer> entry: entrySet) {
			if (entry.getValue() == 1)
				return j;
			j++;
		}
		return -1;
    }
}