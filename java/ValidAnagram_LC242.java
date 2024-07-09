/*
	https://leetcode.com/problems/valid-anagram/
	Valid Anagram - LeetCode #242 Easy
	
	Given two strings s and t , write a function to determine if t is an 
	anagram of s.

	Example 1:
	Input: s = "anagram", t = "nagaram"
	Output: true
	
	Example 2:
	Input: s = "rat", t = "car"
	Output: false
	
	Note:
	You may assume the string contains only lowercase alphabets.

	Follow up:
	What if the inputs contain unicode characters? How would you adapt your 
	solution to such case?
	
	Test cases:
	anagram = nag a ram
	below = elbow
	study = dusty
	night = thing
	act = cat
	dessert = stressed
	bad credit = debit card
	gainly = laying
	conversation = voice rants on
	eleven plus two = twelve plus one
	they see = the eyes
	funeral = real fun
	meteor = remote
	the classroom = schoolmaster
	meal for one = for me alone
	sweep the floor = too few helpers
	older and wiser = I learned words
	video game = give a demo
	coins kept = in pockets
	young lad = an old guy

*/

public class ValidAnagram_LC242 {
	public static void main(String[] args) {
		//String s1 = "anagram";
		//String s2 = "nagaram";
		String s1 = "reote";
		String s2 = "moatre";
		
		System.out.println("Two strings are anagram: " + isAnagram(s1, s2));
	}
	 public static boolean isAnagram(String s, String t) {
		int[] letters = new int[26];
		
		if (s.length() != t.length())
			 return false;
		
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
			letters[t.charAt(i) - 'a']--;
		}
		
		for (int i: letters) {
			if (i != 0)
				return false;
		}
		return true;
    }
}