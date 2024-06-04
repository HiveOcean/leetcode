/*
	https://leetcode.com/problems/valid-parentheses/
	Valid Parenthese - LeetCode # 20 Easy
	
	Given a string s containing just the characters '(', ')', '{', '}', '[' and 
	']', determine if the input string is valid.

	An input string is valid if:

	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	 
	Example 1:
		Input: s = "()"
		Output: true
	
	Example 2:
		Input: s = "()[]{}"
		Output: true
	
	Example 3:
		Input: s = "(]"
		Output: false
	
	Example 4:
		Input: s = "([)]"
		Output: false
	
	Example 5:
		Input: s = "{[]}"
		Output: true

	Constraints:

	1 <= s.length <= 104
	s consists of parentheses only '()[]{}'.

*/
import java.util.*;

public class ValidParentheses_LC020 {
	public static void main(String[] args) {
		String[] testcases = {"()", "()[]{}","(]","([)]","{[]}"};
		boolean result;
		
		for (int i = 0; i < testcases.length; i++) {
			result = isValid(testcases[i]);
			
			System.out.println("Input: " + testcases[i] + " validation is " + result);
			 
		}
	}
	 public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				char k = (Character) stack.pop();
				if ( k == '(' && c == ')') {
					continue;
				} else if ( k == '{' && c == '}') {
					continue;
				} else if ( k == '[' && c == ']') {
					continue;
				} else
					return false;
			}
		}
        return true;
    }
}