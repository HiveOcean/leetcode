/*
	https://leetcode.com/problems/power-of-three/
	Power of Three - LeetCode #326
	
	Given an integer n, return true if it is a power of three. Otherwise, 
	return false.

	An integer n is a power of three, if there exists an integer x such 
	that n == 3x.

	Example 1:
		Input: n = 27
		Output: true

	Example 2:
		Input: n = 0
		Output: false

	Example 3:
		Input: n = 9
		Output: true

	Example 4:
		Input: n = 45
		Output: false
	 
	Constraints:
		-2e31 <= n <= 2e31 - 1
	 

	Follow up: 
		Could you do it without using any loop / recursion?

*/

public class PowerOfThree_LC326 {
	public static void main(String[] args){
		int[] nums = {-27 ,27,0, 7, 9, 45};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " is power of three: " + isPowerOfThree(nums[i]));
		}
		System.out.println("\nMethod two - without using loop: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " is power of three: " + isPowerOfThree2(nums[i]));
		}
	}
	
	// Method 1 - using a loop
    public static boolean isPowerOfThree(int n) {
		if (n == 0) return false;
		while (n % 3 == 0) {
			n /= 3;
			//System.out.println(" n: " + n);
		}
		if ( Math.abs(n) == 1) 
			return true;
		else
			return false;
    }
	
	// 	Method 2 - without using a loop
	public static boolean isPowerOfThree2(int n) {
			return Math.log10(n)/Math.log10(3) % 1 == 0;
	}
	/* 	https://www.youtube.com/watch?v=RH9ZKMsmEpA
		n = 3ei (n is 3 power of i where i is an integer)
		log(base3) n = log(base3) 3ei
					= i log(base3)3  where log(base3)3 is 1
				i = log(base3) n
				  = log (base10)n / log(base10)3
				  
		public boolean isPowerOfThree(int n) {
			return Math.log10(n)/Math.log10(3) % 1 == 0;
		}
	
	*/
}