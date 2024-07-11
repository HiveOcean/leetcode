/*
	https://leetcode.com/accounts/login/?next=/problems/generalized-abbreviation/ (blocked)
	https://yuncoong.gitbooks.io/leetcode/content/320.html
	
	Generalized Abbreviation - LeetCode #320

	Write a function to generate the generalized abbreviations of a word.
	Given a string of characters of length less than 10. We need to print all 
	the alpha-numeric abbreviation of the string.

	The alpha-numeric abbreviation is in the form of characters mixed with the 
	digits which is equal to the number of skipped characters of a selected 
	substring. So, whenever a substring of characters is skipped, you have to 
	replace it with the digit denoting the number of characters in the substring. 
	There may be any number of skipped substrings of a string. No two substrings 
	should be adjacent to each other. Hence, no two digits are adjacent in the 
	result. For a clearer idea, see the example.
	
	Example:
		Input: 	"word"
		Output:	["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", 
				"1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
		
		Input: 	"ANKS"
		Output: ANKS (nothing is replaced)
				ANK1 (S is replaced) 
				AN1S (K is replaced)
				AN2  (KS is replaced)
				A1KS (N is replaced)
				A1K1 (N and S are replaced)
				A2S (NK is replaced)
				A3 (NKS is replaced)
				1NKS (A is replaced)
				1NK1 (A and S are replaced)
				1N1S (A and N is replaced)
				1N2 (A and KS are replaced)
				2KS (AN is replaced)
				2K1 (AN and S is replaced)
				3S (ANK is replaced)
				4 (ANKS is replaced)
		
		Input: 	"ABC"
		Output: ["ABC", "AB1", "A1C", "A2", "1BC", "1B1", "2C", "3"]	
		Note: 	11C is not valid because no two digits should be adjacent, 
				2C is the correct one because AB is a substring, not A and B 
				individually
				
		Input:	"GFG"
		Output:	["GFG", "GF1", "G1G", "G2", "1FG", "1F1", "2G", "3"]

	Solution reference:
	https://www.geeksforgeeks.org/alphanumeric-abbreviations-of-a-string/
	The idea is to start with empty string. At every step, we have two choices.
		1 Consider character as it is.
		2 Add character to count. If there is no count, then use 1.
		
								 ""
							/			\
		A				1				   A
					  /		 \			/	  \
		B			2		 1B		  A1	  AB
				  /	  \		/	\	  / \	  / \
		C	     3	  2C   1B1  1BC	 A2 A1C	 AB1 ABC

	You can see how each character can either add up to the result as a 
	character or as a digit. This further gives rise to 2^n abbreviations at 
	the end where n is the length of string.
	
*/
import java.util.*;

public class GeneralizedAbbreviation_LC320 {
	public static void main(String[] args) {
		String[] input = {"word","ABC","GFG","ANKS"};
		GeneralizedAbbreviation_LC320 ga = new GeneralizedAbbreviation_LC320();
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("\"" + input[i] + "\" with alphanumeric Abbreviations: \n\t[ ");
			for (String s : ga.generateAbbreviations(input[i]))
				System.out.print(s + " ");
			
			System.out.println("]");
		}
	
	}
	public List<String> generateAbbreviations(String word) {
		
		List<String> answers = new ArrayList<>();
		if (word.length() == 0) return answers;
		
		String alphAbbrWord = "";
		boolean[] used = new boolean[word.length()];
		
		backtrack(word, alphAbbrWord, used, answers);
		
		return answers;
	}
	private void backtrack(String word, String alphAbbr, boolean[] used, List<String> ans) {
		
	}	
}