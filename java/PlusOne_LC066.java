/*
	https://leetcode.com/problems/plus-one/
	Plus One - LeetCode #66 Easy
	
	Given a non-empty array of decimal digits representing a non-negative integer, 
	increment one to the integer.

	The digits are stored such that the most significant digit is at the head of 
	the list, and each element in the array contains a single digit.

	You may assume the integer does not contain any leading zero, except the 
	number 0 itself.

	Example 1:
		Input: digits = [1,2,3]
		Output: [1,2,4]
		Explanation: The array represents the integer 123.
		
	Example 2:
		Input: digits = [4,3,2,1]
		Output: [4,3,2,2]
		Explanation: The array represents the integer 4321.
		
	Example 3:
		Input: digits = [0]
		Output: [1]
	 
	Constraints:
		1 <= digits.length <= 100
		0 <= digits[i] <= 9

 */
 
 public class PlusOne_LC066 {
	public static void main(String[] args) {
		int[][] testNums = {{1,2,3},
							{1},
							{0},
							{1,9,9},
							{9,9},
							{1,5,9},
							{8,9}};
							
		for (int i = 0; i < testNums.length; i++) {
			System.out.print("\nInput array [ ");
			for (int k: testNums[i])
				System.out.print(k + " ");
			
			System.out.print("] after added 1 is [" );
			
			for ( int k : plusOne(testNums[i]))
				System.out.print(" " + k);
			
			System.out.print(" ]\n");
		}	
	}
	public static int[] plusOne(int[] digits) {
		String s = "";
		int carry = 0, num = 0;
		
		num = digits[digits.length - 1] + 1;
		carry = num / 10;
		s = String.valueOf(num % 10);
		
		for (int i = digits.length - 2; i >= 0; i--) {
			num = digits[i] + carry;
			carry = num / 10;
			s = String.valueOf(num % 10) + s;
		}
		if (carry != 0)
			s = String.valueOf(carry) + s;
		
		int[] a = new int[s.length()];
		for (int j = 0; j < s.length(); j++) {
			a[j] = s.charAt(j) - '0';
		}
		//System.out.println("**final String is " + s);
        return a;
    }
 }