/*
	https://leetcode.com/problems/factorial-trailing-zeroes/
	Factorial Trailing Zeroes - LeetCode #172 Easy
	
	Given an integer n, return the number of trailing zeroes in n!.

	Follow up: Could you write a solution that works in logarithmic time complexity?

	Example 1:
		Input: n = 3
		Output: 0
		Explanation: 3! = 6, no trailing zero.
	
	Example 2:
		Input: n = 5
		Output: 1
		Explanation: 5! = 120, one trailing zero.
	
	Example 3:
		Input: n = 0
		Output: 0	 

	Constraints:
		1 <= n <= 10e4

	//https://www.youtube.com/watch?v=nnmS7PEnvy8 "CS Ninja"
	count number of 5 in the factorial:
	each 10 is 5 * 2
	each 100 is 5 * 2 * 5 * 2
	5! = 1 * 2 * 3 * 4 * 5 = 120
	8! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 = 1 * 2 * 3 * 2 * 2 * 5 * 2 * 6 * 7 * 2 * 2 * 2
	
	10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 = 362800
	    = 1 * 2 * 3 * 2 * (2 * 5) * 2 * 3 * 7 * 2 * 2 * 2 * 9 * (2 * 5)
		have eight 2s and two 5s
		with this two 5s, we know there will have trailing zeros of 00
		
	25! = 1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20*21*22*23*24*25
	Get all the numbers which is mulitple of 5:
		5 * 10 * 15 * 20 * 25
	  (1*5)*(2*5)*(3*5)*(4*5)*(5*5)
	  we will have 6 trailing zeroes as there is six 5s.
	  
	This will take O(log base 5 of n)
		
*/

public class FactorialTrailingZeroes_LC172 {
	public static void main(String[] args) {
		System.out.println("5! has trailing zeroes 0f: " + trailingZeroes(5));
		System.out.println("3! has trailing zeroes 0f: " + trailingZeroes(3));
		System.out.println("25! has trailing zeroes 0f: " + trailingZeroes(25));
		System.out.println("104! has trailing zeroes 0f: " + trailingZeroes(104));
	}
    public static int trailingZeroes(int n) {
		int count = 0;
		
		while (n > 0) {
			n /= 5;
			count += n;
		}
        return count;
    }
}