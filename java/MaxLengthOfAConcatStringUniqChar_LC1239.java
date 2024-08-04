/*
	https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
	Maximum Length of a Concatenated String with unique characters 
	LeetCode #1239
	
	Given an array of strings arr. String s is a concatenation of a sub-sequence 
	of arr which have unique characters.

	Return the maximum possible length of s.

	Example 1:
		Input: arr = ["un","iq","ue"]
		Output: 4
		Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
					Maximum length is 4.
			
	Example 2:
		Input: arr = ["cha","r","act","ers"]
		Output: 6
		Explanation: Possible solutions are "chaers" and "acters".
			
	Example 3:
		Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
		Output: 26
			 
	Constraints:
		*	1 <= arr.length <= 16
		*	1 <= arr[i].length <= 26
		*	arr[i] contains only lower case English letters.

	Solution Reference:
	https://www.geeksforgeeks.org/maximize-length-of-the-string-by-concatenating-characters-from-an-array-of-strings/
	Approach: The idea is to use Recursion. 
		1. Iterate from left to right and consider every string as a possible 
		   starting substring.
		2. Initialize a HashSet to store the distinct characters encountered so 
		   far.
		3. Once a string is selected as starting substring, check for every 
		   remaining string, if it only contains characters which have not 
		   occurred before. Append this string as a substring to the current 
		   string being generated.
		4. After performing the above steps, print the maximum length of a 
		   string that has been generated.
		   
	Method 2: Using Depth First Search
	https://www.youtube.com/watch?v=pD3cHFNyW2I
				[ue, iq, un]
					
					"" (1)
					|
			 -------------------
			/		|			\
		  ue (2)   iq (3)		un (5)
					|		  	/ \
				  ique (4)	 unue  uniq (7) 
							  (6)	 \
									unique(8)

*/

import java.util.*;

public class MaxLengthOfAConcatStringUniqChar_LC1239 {
	public static void main(String[] args) {
		MaxLengthOfAConcatStringUniqChar_LC1239 maxLen = new MaxLengthOfAConcatStringUniqChar_LC1239();
		
		List<List<String>> input = new ArrayList<>();
		input.add(new ArrayList<>(Arrays.asList("un","iq","ue")));
		input.add(new ArrayList<>(Arrays.asList("cha","r","act","ers")));
		input.add(new ArrayList<>(Arrays.asList("abc","r","act","def")));
		input.add(new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
		
		// Method 1:
		for (int i = 0; i < input.size(); i++) {
			System.out.print("[ ");
			for (String s: input.get(i))
				System.out.print(s + " ");
			System.out.print("] max length of concatenated string with unique characters is: " );
			System.out.println(	maxLen.maxLength(input.get(i)));
		}
	}
	// Method 1:
    public int maxLength(List<String> arr) {
		int[] result = new int[1];	// to hold as the reference of the max string len 
		
		maxUnique(arr, 0, "", result);  // 0 is the index of the string array starts to do str concatentate
		
        return result[0];
    }
	private void maxUnique(List<String> arr, int index, String current, int[] result) {
		// Base case1: when the index shows the list has completed visited and
		// the current concatenated string is > the existing one
		if (index == arr.size() && uniqueCharCount(current) > result[0]) {
			result[0] = current.length();
			System.out.println("max update: " + current + " idx: " + index + " len: " + result[0]);
			return;
		}
		// Base case2: stop as reach the end of string array and the current one is not the max length
		if (index == arr.size()) {
			System.out.println("end string array " + current + " idx: " + index);
			return;
		}
		System.out.println("*" + current + "* idx: " + index);
		// Continue on recurrsive
		// 1. taking the string in the index position and not adding it to current string
		maxUnique(arr, index + 1, current, result);
		// 2. taking the string in the index position and adding it to the current string
		maxUnique(arr, index + 1, current + arr.get(index), result);
		
	}
	private int uniqueCharCount(String s) {
		int[] counts = new int[26];
		for (char c: s.toCharArray()) {
			if ( counts[c - 'a']++ > 0 ) {	// char seen in the string before
				return -1;
			}
		}
		return s.length();	// found no duplicate char in the string 
	}
}