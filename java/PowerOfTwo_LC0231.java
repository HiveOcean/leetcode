/*
	https://leetcode.com/problems/power-of-two/
	231. Power of Two (easy)

	Given an integer n, return true if it is a power of two. Otherwise, return false.

	An integer n is a power of two, if there exists an integer x such that n == 2x.

	Example 1:
		Input: n = 1
		Output: true
		Explanation: 2^0 = 1

	Example 2:
		Input: n = 16
		Output: true
		Explanation: 2^4 = 16
	
	Example 3:
		Input: n = 3
		Output: false
	
	Example 4:
		Input: n = 4
		Output: true
	
	Example 5:
		Input: n = 5
		Output: false
	 
	Constraints:
	-231 <= n <= 231 - 1	 

	Follow up: Could you solve it without loops/recursion?

	Related topics:
		Math, Bit Manipulation, Recursion

	Solution:
	https://leetcode.com/problems/power-of-two/discuss/63966/4-different-ways-to-solve-Iterative-Recursive-Bit-operation-Math
	
	Method 3: Bitwise O(1)
		If n is the power of two:
		n = 2 ^ 0 = 1 = 0b0000...00000001, and (n - 1) = 0 = 0b0000...0000.
		n = 2 ^ 1 = 2 = 0b0000...00000010, and (n - 1) = 1 = 0b0000...0001.
		n = 2 ^ 2 = 4 = 0b0000...00000100, and (n - 1) = 3 = 0b0000...0011.
		n = 2 ^ 3 = 8 = 0b0000...00001000, and (n - 1) = 7 = 0b0000...0111.
		we have n & (n-1) == 0b0000...0000 == 0

		Otherwise, n & (n-1) != 0.

		For example, n =14 = 0b0000...1110, and (n - 1) = 13 = 0b0000...1101.
*/

public class PowerOfTwo_LC0231 {
	// Method 1 - loop, iterative  O(log n)
    public boolean isPowerOfTwo1(int n) {
		
		if ( n <= 0 )
			return false;
		
		while (n % 2 == 0) {
			n = n / 2;	
		}
		return (n == 1 ? true : false);

    }
	// 	Method 2 - without using a loop
	public static boolean isPowerOfTwo2(int n) {
		double a = Math.log10(n)/Math.log10(2);
		return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
			//return Math.log10(n)/Math.log10(2) % 1 == 0;
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
	// Method 3: recursive  O(log n)
	public static boolean isPowerOfTwo3(int n) {
		return n > 0 && (n == 1 || (n%2 == 0 && isPowerOfTwo3(n/2)));
	}
	
	// Method 4: Bitwise operation
	public static boolean isPowerOfTwo4(int n) {
		return n > 0 && ((n & (n-1)) == 0);
	}
		
	public static void main(String[] args) {
		PowerOfTwo_LC0231 po2 = new PowerOfTwo_LC0231();
		
		if (Math.pow(-2,3) % 2 == 0)
			System.out.println(Math.pow(-2,3) + " ****");
		int[] inputs= {1, 16, 3, 4, 5, -8, 0, -4};
		
		System.out.println("\nMethod 2:  iterative");
		for (int i: inputs) {
			System.out.println(i + " is power of two? " + po2.isPowerOfTwo1(i));
		}
		System.out.println("\nMethod 2:  Math");
		for (int i: inputs) {
			System.out.println(i + " is power of two? " + po2.isPowerOfTwo2(i));
		}
		System.out.println("\nMethod 3: Recursive");
		for (int i: inputs) {
			System.out.println(i + " is power of two? " + po2.isPowerOfTwo3(i));
		}
		System.out.println("\nMethod 4: Bitwise");
		for (int i: inputs) {
			System.out.println(i + " is power of two? " + po2.isPowerOfTwo4(i));
		}
	}
}