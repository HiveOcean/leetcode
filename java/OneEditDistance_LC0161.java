/*
	https://www.goodtecher.com/leetcode-161-one-edit-distance/
	https://leetcode.com/problems/one-edit-distance/
	
	161. One Edit Distance
	
	Given two strings s and t, return true if they are both one edit 
	distance apart, otherwise return false.

	A string s is said to be one distance apart from a string t if you can:

		- Insert exactly one character into s to get t.
		- Delete exactly one character from s to get t.
		- Replace exactly one character of s with a different character to 
		  get t.

	Example 1:
		Input: s = "ab", t = "acb"
		Output: true
		Explanation: We can insert 'c' into s to get t.
		
	Example 2:
		Input: s = "", t = ""
		Output: false
		Explanation: We cannot get t from s by only one step.
		
	Example 3:
		Input: s = "a", t = ""
		Output: true
		
	Example 4:
		Input: s = "", t = "A"
		Output: true
		
	Constraints:
		0 <= s.length <= 104
		0 <= t.length <= 104
		s and t consist of lower-case letters, upper-case letters and/or digits.


*/
import java.util.*;

public class OneEditDistance_LC0161 {
	boolean isOneEditDistance(String s, String t) {
		
		if ( s.equals(t) )return false;
		
		// if either string has length gap > 1
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		// put s into hashmap
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) 
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			else 
				map.put(s.charAt(i),1);
			
		}
		//System.out.println(map.size() + " " + map.toString());
		int t_len = t.length();
		for (Character c : t.toCharArray()) {
			if (map.containsKey(c)) {
				if ( map.get(c) > 1 )
					map.put(c, map.get(c) - 1);
				else
					map.remove(c);
				
				t_len--;
			}
		}
		// The first value in key,Value map:  map.entrySet().stream().findFirst().get().getValue()
		
		// case insert
		if (t_len == 1 && map.isEmpty())
			return true;
		else if ( t_len == 0 && map.size() == 1 )  // case delete
			return true;
		else if (t_len == 1 && map.size() == 1)
			return true;
		
		return false;
		
	}
	public static void main(String[] args) {
		OneEditDistance_LC0161 oneEdit = new OneEditDistance_LC0161();
		
		String s1 = "ab", t1 = "acb";	//insert
		String s2 = "", t2 = "";		
		String s3 = "a", t3 = "";		// delete
		String s4 = "", t4 = "A";		// insert
		String s5 = "aa", t5 = "qaa";	// insert
		String s6 = "aaa", t6 = "aa";	// delete
		String s7 = "aaa", t7 = "qaa";	// replace
		String s8 = "aab", t8 = "ade";	// false
		String s9 = "aaaa", t9 = "aa";	// false
		
		System.out.println(s1 + ", " + t1 + " is one edit distance? " + oneEdit.isOneEditDistance(s1, t1));
		System.out.println(s2 + ", " + t2 + " is one edit distance? " + oneEdit.isOneEditDistance(s2, t2));
		System.out.println(s3 + ", " + t3 + " is one edit distance? " + oneEdit.isOneEditDistance(s3, t3));
		System.out.println(s4 + ", " + t4 + " is one edit distance? " + oneEdit.isOneEditDistance(s4, t4));
		System.out.println(s5 + ", " + t5 + " is one edit distance? " + oneEdit.isOneEditDistance(s5, t5));
		System.out.println(s6 + ", " + t6 + " is one edit distance? " + oneEdit.isOneEditDistance(s6, t6));
		System.out.println(s7 + ", " + t7 + " is one edit distance? " + oneEdit.isOneEditDistance(s7, t7));
		System.out.println(s8 + ", " + t8 + " is one edit distance? " + oneEdit.isOneEditDistance(s8, t8));
		System.out.println(s9 + ", " + t9 + " is one edit distance? " + oneEdit.isOneEditDistance(s9, t9));
		
	
	}
}