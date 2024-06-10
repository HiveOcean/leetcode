/*
	https://leetcode.com/problems/longest-common-prefix/
	Longest Common Prefix - LeetCode #14 Easy
	
	Write a function to find the longest common prefix string amongst an array of strings.

	If there is no common prefix, return an empty string "".
	 
	Example 1:
		Input: strs = ["flower","flow","flight"]
		Output: "fl"
		
	Example 2:
		Input: strs = ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.
	 
	Constraints:
		0 <= strs.length <= 200
		0 <= strs[i].length <= 200
		strs[i] consists of only lower-case English letters.
	

*/

public class LongestCommonPrefix_LC014 {
	public static void main(String[] args) {
		String[][] strs = {{"flower","flow","flight"},
						{"dog","racecar","car"},
						{"in","into","insert"},
						{"heterosexual","heterodox","heterogeneous"},
						{"extravagant","","excavate"},
						{"myprefixwhatever","myprefixwhatsoever","myprefixdoesntmatter"}};
		
		for (int k = 0; k < strs.length; k++) {
			System.out.print("\nThe common prefix of array: [");
			for (String s: strs[k])
				System.out.print(" " + s);
			System.out.println(" ] is: " + longestCommonPrefix(strs[k]));
		}
	}
	public static String longestCommonPrefix(String[] strs) {
				
		if (strs.length == 0) return "";
		if (strs.length == 1) return strs[0];
		
		String commonPrefix = strs[0];
		int j = 0;
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() == 0)
				return "";
			j = 0;			
			while ( j < strs[i].length() && j < commonPrefix.length() && strs[i].charAt(j) == commonPrefix.charAt(j)) {
				j++;
			}
			if (j == 0) return "";
		}
		 
		return commonPrefix.substring(0,j);
    }
}