/*
	https://leetcode.com/problems/sqrtx/
	Sqrt(x) - LeetCode #069
	
	Given a non-negative integer x, compute and return the square root of x.

	Since the return type is an integer, the decimal digits are truncated, and 
	only the integer part of the result is returned.

	Example 1:
		Input: x = 4
		Output: 2
	
	Example 2:
		Input: x = 8
		Output: 2
		Explanation: The square root of 8 is 2.82842..., and since the decimal 
					 part is truncated, 2 is returned.
	 

	Constraints:
		0 <= x <= 2e31 - 1

	Reference:
		https://www.geeksforgeeks.org/square-root-of-an-integer/
		Simple Approach: 
		To find the floor of the square root, try with all-natural numbers starting 
		from 1. Continue incrementing the number until the square of that number is 
		greater than the given number.

		Algorithm:
		1. Create a variable (counter) i and take care of some base cases, i.e when 
		   the given number is 0 or 1.
		2. Run a loop until i*i <= n , where n is the given number. Increment i by 1.
		3. The floor of the square root of the number is i – 1
*/
import java.util.Scanner;

public class SquareRoot_LC069 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number to find the square root of it: ");
		int num = input.nextInt();
		
		int ans = mySqrt(num);
		System.out.println("\nThe square root of " + num + " is " + ans);
	}
    public static int mySqrt(int x) {
		if (x == 0 || x == 1) return x;
		
		int i = 1;
		while ( i * i  <= x) {
			i++;
		}
        return i - 1;
    }
}