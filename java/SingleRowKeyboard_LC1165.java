/*
	https://leetcode.com/problems/single-row-keyboard/
	1165. Single-Row Keyboard
	
	There is a special keyboard with all keys in a single row.

	Given a string 'keyboard' of length 26 indicating the layout of the keyboard (indexed 
	from 0 to 25), initially your finger is at index 0. To type a character, you have to 
	move your finger to the index of the desired character. The time taken to move your 
	finger from index i to index j is |i - j|.
	
	
	You want to type a string word. Write a function to calculate how much time it takes to 
	type it with one finger.

	Example 1:
		Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
		Output: 4
		Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
		Total time = 2 + 1 + 1 = 4. 

	Example 2:
		Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
		Output: 73

	Constraints:
		keyboard.length == 26
		keyboard contains each English lowercase letter exactly once in some order.
		1 <= word.length <= 10^4
		word[i] is an English lowercase letter.
		
*/

import java.util.*;

public class SingleRowKeyboard_LC1165 {
	
	public int calculateTime(String keyboard, String word) {
		int sum = 0, steps = 0;
		for (int j = 0; j < word.length(); j++) {
			char current = word.charAt(j);
			sum += Math.abs(steps - keyboard.indexOf(current));
			steps = keyboard.indexOf(current);
		}
		return sum;
	}
	public static void main(String[] args) {
		SingleRowKeyboard_LC1165 srk = new SingleRowKeyboard_LC1165();
		
		String keyboard1 = "abcdefghijklmnopqrstuvwxyz";
		String word1 = "cba";
		int ans1 = srk.calculateTime(keyboard1, word1);
		System.out.println(word1 + " need travel time: " + ans1);
		
		String keyboard2 = "pqrstuvwxyzabcdefghijklmno";
		String word2 = "leetcode";
		int ans2 = srk.calculateTime(keyboard2, word2);
		System.out.println(word2 + " need travel time: " + ans2);
	}
}