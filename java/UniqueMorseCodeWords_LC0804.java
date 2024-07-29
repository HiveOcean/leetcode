/*
	https://leetcode.com/problems/unique-morse-code-words/
	804. Unique Morse Code Words
	
	International Morse Code defines a standard encoding where each letter is mapped 
	to a series of dots and dashes, as follows:

		'a' maps to ".-",
		'b' maps to "-...",
		'c' maps to "-.-.", and so on.
	
	For convenience, the full table for the 26 letters of the English alphabet is 
	given below:

	[".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
	  a       b       c      d     e     f      g        h      i      j
	 "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
	   k      l      m     n      o      p      q        r      s     t
	 "..-", "...-", ".--", "-..-", "-.--", "--.."]
	  u       v       w      x       y       z
	
	Given an array of strings words where each word can be written as a concatenation 
	of the Morse code of each letter.

	For example, "cab" can be written as "-.-..--...", which is the concatenation 
	of "-.-.", ".-", and "-...". We will call such a concatenation the transformation 
	of a word.
	
	Return the number of different transformations among all words we have.

	Example 1:
		Input: words = ["gin","zen","gig","msg"]
		Output: 2
		Explanation: The transformation of each word is:
			"gin" -> "--...-."
			"zen" -> "--...-."
			"gig" -> "--...--."
			"msg" -> "--...--."
		There are 2 different transformations: "--...-." and "--...--.".

	Example 2:
		Input: words = ["a"]
		Output: 1

	Constraints:
		1 <= words.length <= 100
		1 <= words[i].length <= 12
		words[i] consists of lowercase English letters.
	
	
*/
import java.util.*;

public class UniqueMorseCodeWords_LC0804 {
    public int uniqueMorseRepresentations(String[] words) {
		HashSet<String> uniqueSet = new HashSet<>();
		String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		
		for (String word: words) {
			StringBuilder s = new StringBuilder();
			for (char c: word.toCharArray()) {
				s.append(morseCode[c - 'a']);	
			}
			uniqueSet.add(s.toString());
		}
        return uniqueSet.size();
    }
	public static void main(String[] args) {
		UniqueMorseCodeWords_LC0804 morse = new UniqueMorseCodeWords_LC0804();
		
		String[] words1 = {"gin","zen","gig","msg"};
		String[] words2 = {"a"};
		
		System.out.println(Arrays.toString(words1) + " number of unique transformations: " +
			morse.uniqueMorseRepresentations(words1));
	}
}	