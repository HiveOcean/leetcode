/*
	https://leetcode.com/problems/remove-vowels-from-a-string/
	1119. Remove Vowels from a String
	
	Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the 
	new string.

	Example 1:

	Input: s = "leetcodeisacommunityforcoders"
	Output: "ltcdscmmntyfrcdrs"
	Example 2:

	Input: s = "aeiou"
	Output: ""
	
	Constraints:
		1 <= s.length <= 1000
		s consists of only lowercase English letters.

*/
import java.util.*;

public class RemoveVowelsFromAString_LC1119 {
	public String removeVowels(String s) {
		StringBuilder noVowelStr = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			//System.out.print(s.charAt(i) + " ");
			if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u') {
				noVowelStr.append(s.charAt(i));
			}
		}
		return noVowelStr.toString();
	}
	// Better solution:
	public String removeVowels2(String s) {
		return s.replaceAll("[a,e,i,o,u]*", "");
	}
	public static void main(String[] args) {
		RemoveVowelsFromAString_LC1119 rvfs = new RemoveVowelsFromAString_LC1119();
		
		String input1 = "leetcodeisacommunityforcoders";
		System.out.println(input1 + " removed all vowels will be: " + rvfs.removeVowels(input1));
		System.out.println(input1 + " removed all vowels will be: " + rvfs.removeVowels2(input1));
		
		String input2 = "aeiou";
		System.out.println(input2 + " removed all vowels will be: " + rvfs.removeVowels(input2));
		System.out.println(input2 + " removed all vowels will be: " + rvfs.removeVowels2(input2));
		
	}
}