/*
	https://leetcode.com/problems/generate-parentheses/
	Generate Parentheses - LeetCode #22
	
	Given n pairs of parentheses, write a function to generate all combinations 
	of well-formed parentheses.

	Example 1:
		Input: n = 3
		Output: ["((()))","(()())","(())()","()(())","()()()"]

	Example 2:
		Input: n = 1
		Output: ["()"]

	Constraints:
		1 <= n <= 8

	Reference:
	https://leetcode.com/problems/generate-parentheses/solution/
	1. Brute Force
	2. Backtracking
	   Backtracking by Nick White https://www.youtube.com/watch?v=qBbZ3tS0McI 
	
*/
import java.util.*;

public class GenerateParentheses_LC022 {
	public static void main(String[] args) {
		int[] data = {3,1,4,2};
		List<String> output = new ArrayList<>();
		
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " pairs of parentheses: [ ");
			output = generateParenthesis(data[i]);
			for (String s : output)
				System.out.print(s + " ");
			
			System.out.println("]");
			output.clear();
		}
	}
    public static List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
		
		backtrack(output_arr, "", 0, 0, n);
		return output_arr;
    }
	public static void backtrack(List<String> output_arr, String current_str, int open, int close, int max) {
		// current is the current string, open & close are the number of open & close parentheses
		// max is the number of pairs from input
		
		if (current_str.length() == max * 2) {	
			// base case: when length of current string is equal to total number of parentheses, e.g 3 pairs = 6 parentheses.
			// then it is ready to put in the output array.
			output_arr.add(current_str);
			return;
		}
		if ( open < max ) backtrack(output_arr, current_str + "(", open + 1, close, max);
		if ( close < open) backtrack(output_arr, current_str + ")", open, close + 1, max);
	}
}