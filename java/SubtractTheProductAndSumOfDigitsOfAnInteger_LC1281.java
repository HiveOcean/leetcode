/*
	https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
	1281. Subtract the Product and Sum of Digits of an Integer
	
	Given an integer number n, return the difference between the product of its 
	digits and the sum of its digits.

	Example 1:
		Input: n = 234
		Output: 15 
		Explanation: 
			Product of digits = 2 * 3 * 4 = 24 
			Sum of digits = 2 + 3 + 4 = 9 
			Result = 24 - 9 = 15

	Example 2:
		Input: n = 4421
		Output: 21
		Explanation: 
			Product of digits = 4 * 4 * 2 * 1 = 32 
			Sum of digits = 4 + 4 + 2 + 1 = 11 
			Result = 32 - 11 = 21
	 

	Constraints:
		1 <= n <= 10^5

*/
public class SubtractTheProductAndSumOfDigitsOfAnInteger_LC1281 {
    public int subtractProductAndSum(int n) {
        int diff = 0, sum = 0, product = 1;
		
		while ( n / 10 != 0) {		
			sum += n % 10;
			product *= n % 10;
			n /= 10;
		}
		sum += n;
		product *= n;
		
		return product - sum;
    }
	public static void main(String[] args) {
		SubtractTheProductAndSumOfDigitsOfAnInteger_LC1281 diff = new SubtractTheProductAndSumOfDigitsOfAnInteger_LC1281();
		int input1 = 234;
		int input2 = 4421;
		int input3 = 3;
		
		System.out.println(input1 + 
			" the difference between the product and sum of its digits is "  +
			diff.subtractProductAndSum(input1));
			
		System.out.println(input2 + 
			" the difference between the product and sum of its digits is "  +
			diff.subtractProductAndSum(input2));
		
		System.out.println(input3 + 
			" the difference between the product and sum of its digits is "  +
			diff.subtractProductAndSum(input3));
	}
}