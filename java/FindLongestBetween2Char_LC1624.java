/*
https://zxi.mytechroad.com/blog/
https://zxi.mytechroad.com/blog/tag/easy/
 Given a string s, return the length of the longest substring between two equal characters, 
 excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

Example 1:

	Input: s = "aa"
	Output: 0
	Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

	Input: s = "abca"
	Output: 2
	Explanation: The optimal substring here is "bc".
Example 3:

	Input: s = "cbzxy"
	Output: -1
	Explanation: There are no characters that appear twice in s.
Example 4:

	Input: s = "cabbac"
	Output: 4
	Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
Constraints:

	1 <= s.length <= 300
	s contains only lowercase English letters.
	
*/
import java.util.*;
import java.util.Scanner;
public class FindLongestBetween2Char_LC1624 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a string of text: ");
		String s = input.next();
		int maxDistance = -1;
		Boolean matchFound = false;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
				continue;
			} else if ( maxDistance < (s.lastIndexOf(s.charAt(i)) - s.indexOf(s.charAt(i))) ) {
				maxDistance = s.lastIndexOf(s.charAt(i)) - s.indexOf(s.charAt(i)) - 1;
				matchFound = true;
			}
		}
		System.out.println(maxDistance);

	}
}
