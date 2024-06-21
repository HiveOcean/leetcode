/*
	https://leetcode.com/problems/count-primes/
	Count Primes - LeetCode #204
	
	Count the number of prime numbers less than a non-negative number, n.

	Example 1:
		Input: n = 10
		Output: 4
		Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
	
	Example 2:
		Input: n = 0
		Output: 0
	
	Example 3:
		Input: n = 1
		Output: 0
	 
	Constraints:
		0 <= n <= 5 * 10e6

*/
import java.util.Scanner;

public class CountPrimes_LC204 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Find all the prime numbers < n, enter n: ");
		int n = input.nextInt();
		
		System.out.println("\nThere are " + countPrimes(n) + " prime numbers.");
	}
    public static int countPrimes(int n) {
		// reference to Daniel Liang text book p.897
		// time complexity is O(n Sqrt(n) / logn )
		if ( n <= 1 ) return 0;
		
		int count = 0;
		int number = 2;
		int squareRoot = 1;
		java.util.List<Integer> list = new java.util.ArrayList<>();  // a list to hold prime numbers 
		
		while ( number < n) {
			boolean isPrime = true;
			
			if (squareRoot * squareRoot < number ) 
				squareRoot++;
			
			for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
				if (number % list.get(k) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				count++;
				list.add(number);
			}
			number++;
		}	
        return count;
    }
}