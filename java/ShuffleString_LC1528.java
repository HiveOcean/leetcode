/*
	https://leetcode.com/problems/shuffle-string/
	1528. Shuffle String
	
	Given a string s and an integer array indices of the same length.

	The string s will be shuffled such that the character at the ith position 
	moves to indices[i] in the shuffled string.

	Return the shuffled string.

	Example 1:
				4	5	6	7	0	2	1	3
				c	o	d	e	l	e	e	t
			==>
				l	e	e	t	c	o	d	e 
				0	1	2	3	4	5	6	7
			
		Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
		Output: "leetcode"
		Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
	
	Example 2:
		Input: s = "abc", indices = [0,1,2]
		Output: "abc"
		Explanation: After shuffling, each character remains in its position.
	
	Example 3:
		Input: s = "aiohn", indices = [3,1,4,2,0]
		Output: "nihao"
	
	Example 4:
		Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
		Output: "arigatou"

	Example 5:
		Input: s = "art", indices = [1,0,2]
		Output: "rat"
	 

	Constraints:
		s.length == indices.length == n
		1 <= n <= 100
		s contains only lower-case English letters.
		0 <= indices[i] < n
		All values of indices are unique (i.e. indices is a permutation of the 
		integers from 0 to n - 1).

*/
import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
public class ShuffleString_LC1528 {
    public String restoreString(String s, int[] indices) {
        Character[] ans = new Character[indices.length];
		
		for (int i = 0; i < s.length(); i++) {
			ans[indices[i]] = s.charAt(i);
		}
		
		Stream<Character> charStream = Arrays.stream(ans);
		String str = charStream.map(String::valueOf).collect(Collectors.joining());
		return str;
    }
	public static void main(String[] args) {
		ShuffleString_LC1528 shuffleStr = new ShuffleString_LC1528();
		
		String input1 = "codeleet";
		int[] indices1 = {4,5,6,7,0,2,1,3};
		System.out.println(input1 + " after shuffled: " + shuffleStr.restoreString(input1, indices1));
		
		String input2 = "abc";
		int[] indices2 = {0,1,2};
		System.out.println(input2 + " after shuffled: " + shuffleStr.restoreString(input2, indices2));
		
		String input3 = "aiohn";
		int[] indices3 = {3,1,4,2,0};
		System.out.println(input3 + " after shuffled: " + shuffleStr.restoreString(input3, indices3));
		
		String input4 = "aaiougrt";
		int[] indices4 = {4,0,2,6,7,3,1,5};
		System.out.println(input4 + " after shuffled: " + shuffleStr.restoreString(input4, indices4));
		
		String input5 = "art";
		int[] indices5 = {1,0,2};
		System.out.println(input5 + " after shuffled: " + shuffleStr.restoreString(input5, indices5));
		
		
	}
}