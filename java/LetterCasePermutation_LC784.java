/*
	https://leetcode.com/problems/letter-case-permutation/
	Letter Case Permutation - LeetCode #784

	Given a string S, we can transform every letter individually to be lowercase 
	or uppercase to create another string.

	Return a list of all possible strings we could create. You can return the 
	output in any order.

	Example 1:
		Input: S = "a1b2"
		Output: ["a1b2","a1B2","A1b2","A1B2"]
		
	Example 2:
		Input: S = "3z4"
		Output: ["3z4","3Z4"]
		
	Example 3:
		Input: S = "12345"
		Output: ["12345"]
		
	Example 4:
		Input: S = "0"
		Output: ["0"]
		 
	Constraints:
		S will be a string with length between 1 and 12.
		S will consist only of letters or digits.

	Reference Solution:
	https://www.youtube.com/watch?v=LJifc-ehvBM
	
		looping through letter by letter
		at index 0						a1b2
										 |
						--------------------------------------------
						|										|
	    index 1	  	  a1b2									  A1b2
						|										|
		index 2   	  a1b2									  Alb2
						|										|
					------------						--------------
					|			|						|			  |	
		index 3	  alb2		  a1B2					  Alb2		    A1B2
		
*/
import java.util.*;

public class LetterCasePermutation_LC784 {
	
	public static void main(String[] args) {
		LetterCasePermutation_LC784 lcp = new LetterCasePermutation_LC784();
		
		List<String> answers = new ArrayList<>();
		
		String[] str_array = {"a","ab","a1b2", "3z4", "12345", "0"};
		
		for (int i = 0; i < str_array.length; i++){
			System.out.print("\"" + str_array[i] + "\" with letter case Pemutation: [ ");
			answers = lcp.letterCasePermutation(str_array[i]);
			for (String s: answers)
				System.out.print("\"" + s + "\" ");
			System.out.println("]");
		}
	}
    public List<String> letterCasePermutation(String S) {
        List<String> answers = new ArrayList<>();
		
		backtrack(answers, S, 0, "");
		return answers;
    }
	private void backtrack(List<String> answers, String s, int index, String current) {
		if (current.length() >= s.length()) {
			answers.add(current);
			return;
		}
		if (Character.isLetter(s.charAt(index))){
			current += s.charAt(index);
			backtrack(answers, s, index + 1, current);
			current = current.substring(0, current.length() - 1);
			if ( s.charAt(index) >= 97 )
				current += (char)(s.charAt(index) - 32);
			else
				current += (char)(s.charAt(index) + 32);
			
			backtrack(answers, s, index + 1, current);
		} else {
			current += s.charAt(index);
			backtrack(answers, s, index + 1, current);
		}
	}
}