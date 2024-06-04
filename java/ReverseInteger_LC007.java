/*
	https://leetcode.com/problems/reverse-integer/
	Reverse Integer - Leetcode 007 Easy
	
	Given a 32-bit signed integer, reverse digits of an integer.

	Note:
	Assume we are dealing with an environment that could only store integers 
	within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
	of this problem, assume that your function returns 0 when the reversed 
	integer overflows.

	Example 1:
		Input: x = 123
		Output: 321
	
	Example 2:
		Input: x = -123
		Output: -321
	
	Example 3:
		Input: x = 120
		Output: 21
	
	Example 4:
		Input: x = 0
		Output: 0
	 
	Example 5:
		Input: x = 1534236469
		Output: 0
		
	Constraints:
	-2e31 <= x <= 2e31 - 1
	Java, the integer(long) is also 32 bits, but ranges from 
	-2,147,483,648 to +2,147,483,647
	
	
*/

public class ReverseInteger_LC007 {
	public static void main(String[] args) {
		int[]  testCase = {123, -123, 120, 0, 1534236469, -2103847412};
		//int[]  testCase = {123, -123, 120, 0};
		int output, caseNum;
		
		for (int i = 0; i < testCase.length; i++) {
			output = reverse(testCase[i]);
			caseNum = i + 1;
			System.out.println("Test case " + caseNum + ": " + testCase[i] + " reversed to " + output);
		}
	}
	public static int reverse(int x) {
		
		int pop, reversed = 0;
		int checkedMax_Value = Integer.MAX_VALUE / 10;
		int checkedMin_Value = Integer.MIN_VALUE / 10;
		while ( x != 0) {
			pop = x % 10;
			x = x/10;
			reversed = reversed * 10 + pop;
			
			// Its because you are multiplying by reversed by 10 before you add pop to it. 
			// by dividing by 10, you are checking against what the value will be before 
			// you multiply and running into an overflow of the value of reversed.
			// in the case of reversed == checkedMax_Value or == checkedMin_Value
			// the last digit of MAX_VALUE is 7 and the last digit of MIN_VALUE is -8
			if ( reversed > checkedMax_Value || (reversed == checkedMax_Value && pop > 7))
				return 0;
			if ( reversed < checkedMin_Value || (reversed == checkedMin_Value && pop < -8))
				return 0;
		}	
        return reversed;
    }
}