/*
	https://leetcode.ca/all/186.html
	
	186. Reverse Words in a String II
	ReverseWordsInStringII_LC0186
	Given an input string , reverse the string word by word. 

	Example:
		Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
		Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
	
	Note: 
		A word is defined as a sequence of non-space characters.
		The input string does not contain leading or trailing spaces.
		The words are always separated by a single space.
		
	Follow up: 
		Could you do it in-place without allocating extra space?
	
	Solution:
	1) First flip each word, then the entire string,
	Or 
	2) you can reverse the order, first flip the entire string, and then flip 
	   each word.
*/
import java.util.*;

public class ReverseWordsInStringII_LC0186 {
	public void reverseWords(char[] words) {
		
		if (words.length == 0  || words.length == 1 ) return;
		
		int start = 0, end = 0;
		
		for (int i = 0; i < words.length; i++) {
			if (i == words.length - 1) {// the last word in array
				flipString(words, start, end);
			} else if (words[i] != ' ') {
				end++;
			} else {
				flipString(words, start, end - 1);
				start = i + 1;
				end = i + 1;
			}
		}
		flipString(words, 0, words.length - 1);
	}
	private void flipString(char[] array, int start, int end) {
		while (start < end) {
			char temp = array[end];
			array[end] = array[start];
			array[start] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		ReverseWordsInStringII_LC0186 reversed = new ReverseWordsInStringII_LC0186();
		
		char[] input1 =  {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		
		reversed.reverseWords(input1);
		
		System.out.println(Arrays.toString(input1));
		
	}
}
