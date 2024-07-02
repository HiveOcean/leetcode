/*
	https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	Letter Combinations of a Phone Number - LeetCode #017
	
	Given a string containing digits from 2-9 inclusive, return all possible letter 
	combinations that the number could represent. Return the answer in any order.

	A mapping of digit to letters (just like on the telephone buttons) is given 
	below. Note that 1 does not map to any letters.
	
		(1)		(2abc)	(3def)
		(4ghi)	(5jkl)	(6mno)
		(7pqrs)	(8tuv)	(9wxyz)
		(*+)	(0)		(#)

	Example 1:
		Input: digits = "23"
		Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

	Example 2:
		Input: digits = ""
		Output: []

	Example 3:
		Input: digits = "2"
		Output: ["a","b","c"]
		 

	Constraints:
		0 <= digits.length <= 4
		digits[i] is a digit in the range ['2', '9'].
		
	Reference solution:
	Method 1: Backtracking
	https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
	
	Backtracking is an algorithm for finding all solutions by exploring all potential 
	candidates. If the solution candidate turns to be not a solution (or at least not 
	the last one), backtracking algorithm discards it by making some changes on the 
	previous step, i.e. backtracks and then try again.

	Here is a backtrack function backtrack(combination, next_digits) which takes as 
	arguments an ongoing letter combination and the next digits to check.

	* If there is no more digits to check that means that the current combination is 
	  done.
	* If there are still digits to check :
		- Iterate over the letters mapping the next available digit.
			* Append the current letter to the current combination 
				combination = combination + letter.
			* Proceed to check next digits : 
				backtrack(combination + letter, next_digits[1:]).
				
						    "23"
				
							 2
					  /		 |		  \
					/		 |		   \
				  /			 |			\
				 a			 b 			 c
				 |			 |			 |
				 3			 3			 3
			  /  |	\	  /	 |	\	  /	 |	\
			 /	 | 	 \ 	 /	 | 	 \ 	 / 	 | 	 \
			 d 	 e 	 f 	 d 	 e 	 f 	 d 	 e 	 f
			 |	 |	 |	 |	 |	 |	 |	 |	 |
			ad	ae	af	bd	be	bf	cd	ce	cf 
			
			output = ["ad","ae","af","bd","be","bf","cd","ce","cf"]
			
	Complexity Analysis

	* Time complexity : O(3^N × 4^M) where N is the number of digits in the input that 
	  maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the 
	  input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in 
	  the input.

	* Space complexity : O(3^N × 4^M) since one has to keep 3^N × 4^M solutions.
  
	Method 2:
		https://www.youtube.com/watch?v=imD5XeNaJXA by Nick White
		Use a queue for permutation.
		The time complexity and space complexity are the same as above.
*/
import java.util.*;

class LetterCombinationsOfPhoneNumber_LC017 {
	
	List<String> outputList = new LinkedList<>();
	String[] char_map = new String[10];
	
	LetterCombinationsOfPhoneNumber_LC017() {
		char_map[0] = "0";
		char_map[1] = "1";
		char_map[2] = "abc";
		char_map[3] = "def";
		char_map[4] = "ghi";
		char_map[5] = "jkl";
		char_map[6] = "mno";
		char_map[7] = "pqrs";
		char_map[8] = "tuv";
		char_map[9] = "wxyz";
	}
	public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber_LC017 phoneNum = new LetterCombinationsOfPhoneNumber_LC017();
		
		//List<String> outputList = new LinkedList<>();
		phoneNum.outputList.add("");
		String[] data = {"23","","2"};
		
		for (String s: data) {
			System.out.println("\nInput \"" + s + "\" with letter combinations: ");
			phoneNum.outputList = phoneNum.letterCombinations2(s);
			System.out.print("\t");
			for (String str : phoneNum.outputList)
				System.out.print(str + " ");
			phoneNum.outputList.clear();
		}
	}
    public  List<String> letterCombinations(String digits) {
		
		if ( digits.length() == 0 ) return outputList;
		
		backtrack("", digits);
		
		return outputList;
    }
	public void backtrack(String combination, String next_digits) {
		if (next_digits.length() == 0) {
			// if there is no more digits to check, the combination is done
			outputList.add(combination);
		} else {
			// if there are still digits to check
			// iterate over all the letters which map the next available digit
			String digit = next_digits.substring(0,1);
			String letters = char_map[Integer.parseInt(digit)];
			
			for ( int i = 0; i < letters.length(); i++) {
				String letter = char_map[Integer.parseInt(digit)].substring(i, i + 1);
				backtrack(combination + letter, next_digits.substring(1));
			}
			
		}
	}
	/*
	public  List<String> letterCombinations2(String digits) {
		// Method 2: Use the LinkedList outputList as a queue
		LinkedList<String> outputList = new LinkedList<>();
		if ( digits.length() == 0 ) return outputList;
		
		outputList.add("");
		
		for ( int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			
			while (outputList.peek().length() == i) {
				String permutation = outputList.remove(); // pop from the queue
				// add new value into the queue, add the char to the existing permutation
				for (char c: char_map[index].toCharArray()) {
					outputList.add(permutation + c);
				}
			}
		}
		return outputList;	
    } 
	*/
	public  List<String> letterCombinations2(String digits) {
		// Method 2: Use the LinkedList outputList as a queue + details step by step
		LinkedList<String> ans = new LinkedList<>();
		if ( digits.length() == 0 ) return ans;
		
		ans.add("");
		
		for ( int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			System.out.println("i = " + i);
			while (ans.peek().length() == i) {
				String permutation = ans.remove(); // pop from the queue
				System.out.println("Pop queue: " + permutation);
				// add new value into the queue, add the char to the existing permutation
				for (char c: char_map[index].toCharArray()) {
					System.out.println("pop queue + char " + permutation + c);
					ans.add(permutation + c);
				}
			}
		}
		return ans;	
    }
}