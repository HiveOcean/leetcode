/*
	https://leetcode.com/problems/shortest-word-distance/
	https://goodtecher.com/leetcode-243-shortest-word-distance/
	243. Shortest Word Distance
	
	Given an array of strings wordsDict and two different strings that already 
	exist in the array word1 and word2, return the shortest distance between 
	these two words in the list.

	Example 1:
		Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
		Output: 3
	
	Example 2:
		Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
		Output: 1
		
	Constraints:
		1 <= wordsDict.length <= 3 * 10^4
		1 <= wordsDict[i].length <= 10
		wordsDict[i] consists of lowercase English letters.
		word1 and word2 are in wordsDict.
		word1 != word2
	
	Explanation
	Compare the distance between word1 and word2 indices.
	
*/
import java.util.*;

public class ShortestWordDistance_LC0243 {

	public int shortestDistance(String[] words, String word1, String word2) {
		Stack<Integer> stack = new Stack<>();
		String currentWordInStack = "";
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < words.length; i++) {
			
			if ( words[i].equals(word1) ) {
				if (stack.empty()) {			
					currentWordInStack = word1;
					stack.push(Integer.valueOf(i));
				} else if (words[i].equals(currentWordInStack)) {
					stack.push(Integer.valueOf(i));
				} else {
					min = Math.min(min, i - stack.pop());
					stack.empty();
					stack.push(Integer.valueOf(i));
					currentWordInStack = word1;
				}
				
			}
			if ( words[i].equals(word2) ) {
				if (stack.empty()) {			
					currentWordInStack = word2;
					stack.push(Integer.valueOf(i));
				} else if (words[i].equals(currentWordInStack)) {
					stack.push(Integer.valueOf(i));
				} else {
					min = Math.min(min, i - stack.pop());
					stack.empty();
					stack.push(Integer.valueOf(i));
					currentWordInStack = word2;
				}
			}
			
		}
		
		return min;
	
	}

	public static void main(String[] args) {
		ShortestWordDistance_LC0243 swd = new ShortestWordDistance_LC0243();
		
		String[] wordsDict1 = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(swd.shortestDistance(wordsDict1, "coding","practice"));
		
		
		String[] wordsDict2 = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(swd.shortestDistance(wordsDict2, "makes","coding"));
		
		String[] wordsDict3 = {"abc","one","def","two","three","four","one","seven",
								"eight","nine","ten","three","one"};
		System.out.println(swd.shortestDistance(wordsDict3, "one", "three"));
		

		String[] wordsDict4 = {"one","one","def","two","three","wto","one","one","seven",
								"eight","nine","ten","three","three","two","one"};
		System.out.println(swd.shortestDistance(wordsDict4, "one", "three"));		
	}
}