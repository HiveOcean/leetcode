/*
	https://leetcode.com/problems/reverse-string/
	Reverse String - LeetCode #344
	
	Write a function that reverses a string. The input string is given as an 
	array of characters char[].

	Do not allocate extra space for another array, you must do this by modifying 
	the input array in-place with O(1) extra memory.

	You may assume all the characters consist of printable ascii characters.
	 
	Example 1:
		Input: ["h","e","l","l","o"]
		Output: ["o","l","l","e","h"]

	Example 2:
		Input: ["H","a","n","n","a","h"]
		Output: ["h","a","n","n","a","H"]

*/

public class ReverseString_LC344 {
	public static void main(String[] args) {
		char[][] data = {{'h','e','l','l','o'},{'H','a','n','n','a','h'}};
		
		for (int i = 0; i < data.length; i++) {
			System.out.print("[ " );
			for (char c: data[i])
				System.out.print(c + " ");
			System.out.print("] reversed is: [ " );
			reverseString(data[i]);
			for (char c: data[i])
				System.out.print(c + " ");
			System.out.println("]" );
		}
	}
    public static void reverseString(char[] s) {
        int left = 0;
		int right = s.length - 1;
		char temp;
		
		while (left < right) {
			temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
    }
}
