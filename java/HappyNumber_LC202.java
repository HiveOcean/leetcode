/*
	https://leetcode.com/problems/happy-number/
	Happy Number - LeetCode #202
	
	Write an algorithm to determine if a number n is "happy".

	A happy number is a number defined by the following process: Starting with any 
	positive integer, replace the number by the sum of the squares of its digits, 
	and repeat the process until the number equals 1 (where it will stay), or it 
	loops endlessly in a cycle which does not include 1. Those numbers for which 
	this process ends in 1 are happy numbers.

	Return True if n is a happy number, and False if not.

	Example: 
		Input: 19
		Output: true
		Explanation: 
			1e2 + 9e2 = 82
			8e2 + 2e2 = 68
			6e2 + 8e2 = 100
			1e2 + 0e2 + 0e2 = 1
	

*/

public class HappyNumber_LC202 {
	public static void main(String[] args) {
		int[] nums = {19, 43};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " is a Happy Number? " + isHappy(nums[i]));
		}
	}
    public static boolean isHappy(int n) {
		int fast = n;
		int slow = n;

		do  {
			slow = processNum(slow);
			fast = processNum(processNum(fast));
		} while ( slow != fast );

		return  (slow == 1 );
    }
	public static int processNum(int n){
		int squareSum = 0;
		while ( n != 0 ) {
			squareSum += (n % 10) * (n % 10);
			n = n / 10;
		}
		return squareSum;
	}
}