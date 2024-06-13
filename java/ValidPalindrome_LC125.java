/*
	https://leetcode.com/problems/valid-palindrome/
	Valid Palindrome - LeetCode #125
	
	Given a string, determine if it is a palindrome, considering only alphanumeric 
	characters and ignoring cases.

	Note: For the purpose of this problem, we define empty string as valid palindrome.

	Example 1:
		Input: "A man, a plan, a canal: Panama"
		Output: true

	Example 2:
		Input: "race a car"
		Output: false

	Constraints:
		s consists only of printable ASCII characters.

*/
//import java.util.regex.*;

public class ValidPalindrome_LC125 {
	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		
		System.out.println("String \"" + s1 + "\" is Palindrome: " + isPalindrome(s1));
		System.out.println("String \"" + s2 + "\" is Palindrome: " + isPalindrome(s2));
	}
    public static boolean isPalindrome(String s) {
		if (s.length() == 0) return true;
		 
		String r = "[^A-Za-z0-9]";
		String o = s.replaceAll(r,"");
		int left = 0, right = o.length() -1;
		//System.out.println("*** "+o+" ***");	
		
		while ( left < right) {
			if ( Character.toLowerCase(o.charAt(left)) != Character.toLowerCase(o.charAt(right)) )
				return false;
			
			left++;
			right--;
		}
		
		return true;
    }
}