/*
	https://leetcode.com/problems/palindrome-number/
	Determine whether an integer is a palindrome. An integer is a palindrome 
	when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

Example 1:

	Input: x = 121
	Output: true

Example 2:

	Input: x = -121
	Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. 
Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Example 4:

Input: x = -101
Output: false
 
Constraints:

-231 <= x <= 231 - 1
https://www.geeksforgeeks.org/check-number-palindrome-not-without-using-extra-space/
*/
import java.util.*;
import java.util.Scanner;

public class PalindromeNumber_LC009 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the numeric value to check palindrome: ");
		int num = input.nextInt();
		
		if (isPalindrome(num)) 
			System.out.println("Your input " + num + " is palindrome.");
		else
			System.out.println("Your input " + num + " is NOT palindrome.");
	}
	public static boolean isPalindrome(int num) {
		// in each loop, take the right most and left most digit and compare
		// then strink the num to remove the right most and left most digit
		int divisor = 1;
		
		while ( num / divisor >= 10 ) {
			divisor *= 10;
		}
		
		while (num != 0) {
			int left = num / divisor;
			int right = num  % 10;
			
			if (left != right)
				return false;
			
			num = (num - left * divisor) / 10;
			divisor = divisor / 100;
			//System.out.println("Before removing: left " + left +  " right " + right);
			//System.out.println("New num: " + num + " new divisor " + divisor);
		}
		return true;
	}

}

