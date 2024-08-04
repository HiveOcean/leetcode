/*
	https://leetcode.com/problems/split-a-string-in-balanced-strings/
	1221. Split a String in Balanced Strings
	
	Balanced strings are those that have an equal quantity of 'L' and 
	'R' characters.

	Given a balanced string s, split it in the maximum amount of balanced 
	strings.

	Return the maximum amount of split balanced strings.


	Example 1:
		Input: s = "RLRRLLRLRL"
		Output: 4
		Explanation: s can be split into "RL", "RRLL", "RL", "RL", each 
					 substring contains same number of 'L' and 'R'.
		
	Example 2:
		Input: s = "RLLLLRRRLR"
		Output: 3
		Explanation: s can be split into "RL", "LLLRRR", "LR", each 
					 substring contains same number of 'L' and 'R'.
	
	Example 3:
		Input: s = "LLLLRRRR"
		Output: 1
		Explanation: s can be split into "LLLLRRRR".
		
	Example 4:
		Input: s = "RLRRRLLRLL"
		Output: 2
		Explanation: s can be split into "RL", "RRRLLRLL", since each 
					 substring contains an equal number of 'L' and 'R'
		 

	Constraints:
		1 <= s.length <= 1000
		s[i] is either 'L' or 'R'.
		s is a balanced string.

*/

import java.util.*;

public class SplitStringInBalancedStrings_LC1221 {
    public int balancedStringSplit(String s) {
        Stack<Character> balStack = new Stack<>();
		int count = 0;
		balStack.push(s.charAt(0));
		
		//for (Character c: s.toCharArray()) 
		for (int i = 1; i < s.length(); i++) {
			if (balStack.empty())
				balStack.push(s.charAt(i));
			else if (balStack.peek() != s.charAt(i))
				balStack.pop();
			else
				balStack.push(s.charAt(i));
			
			if (balStack.empty())
				count++;
			
		}
		
		return count;
    }
	// Greedy Algorithm -- better solution
	// Greedily split the string, and with the counting
	// L +1
	// R -1
	public int balancedStringSplit2(String s) {
		int res = 0, cnt = 0;
		for (int i = 0; i < s.length(); ++i) {
			cnt += s.charAt(i) == 'L' ? 1 : -1;
			if (cnt == 0) ++res;
		}
		return res;             
	}    
	public static void main(String[] args) {
		SplitStringInBalancedStrings_LC1221 balStr = new SplitStringInBalancedStrings_LC1221();
		
		String input1 = "RLRRLLRLRL";
		String input2 = "RLLLLRRRLR";
		String input3 = "LLLLRRRR";
		String input4 = "RLRRRLLRLL";
		
		System.out.println(input1 + " with max balanced strings " 
							+ balStr.balancedStringSplit(input1));
		System.out.println(input2 + " with max balanced strings " 
							+ balStr.balancedStringSplit(input2));
		System.out.println(input3 + " with max balanced strings " 
							+ balStr.balancedStringSplit(input3));
		System.out.println(input4 + " with max balanced strings " 
							+ balStr.balancedStringSplit(input4));
	}
}