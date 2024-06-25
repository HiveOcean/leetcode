/*
	https://leetcode.com/problems/product-of-array-except-self/
	238. Product of Array Except Self
	
	Given an array nums of n integers where n > 1,  return an array output such 
	that output[i] is equal to the product of all the elements of nums except nums[i].

	Example:

	Input:  [1,2,3,4]
	Output: [24,12,8,6]
	Constraint: It's guaranteed that the product of the elements of any prefix or 
	suffix of the array (including the whole array) fits in a 32 bit integer.

	Note: Please solve it without division and in O(n).

	Follow up:
	Could you solve it with constant space complexity? (The output array does not 
	count as extra space for the purpose of space complexity analysis.)
*/

public class ProductOfArrayExceptSelf_LC238 {
	public static void main(String[] args) {
		int[] array1 = {1,2,3,4};
		int[] array2 = {4,5,1,8,2};
		
		System.out.println("\nMethod 1, use two arrays - left product and right product ");
		productOfArrayExceptSelf(array1);
		productOfArrayExceptSelf(array2);
		
		
		System.out.println("\nMethod 2, use single array ");
		productOfArrayExceptSelf2(array1);
		productOfArrayExceptSelf2(array2);
	}
	public static void productOfArrayExceptSelf(int[] array) {
		int[] output = new int[array.length];
		
		/* 
			Method 1 use two arrays.  First array is product of elements to the right.
			Second array is product of elements to the right.
			array1 x array 2 is the output.
		*/
		System.out.println("\nInput array: ");
		for (int a: array)
			System.out.print(" " + a);
		
		System.out.println();
		int[] right_product = new int[array.length];
		right_product[0] = 1;
		int[] left_product = new int[array.length];
		left_product[array.length - 1] = 1;
		
		for (int i = 1; i < array.length; i++)
			right_product[i] = right_product[i - 1] * array[i - 1];
		
		for (int j = array.length - 2; j >= 0; j--) 
			left_product[j] = left_product[j + 1] * array[j + 1];
		
		for (int k = 0; k < array.length; k++) 
			output[k] = right_product[k] * left_product[k];
		
		
		System.out.println("\nOutput: ");
		for (int m: output)
			System.out.print(" " + m);
	}
	public static void productOfArrayExceptSelf2(int[] array) {
		/* Method 2 - use a single output array only */
		int[] output = new int[array.length];
		int lastOfRight = 1;
		
		output[0] = 1;
		for (int i = 1; i < array.length; i++)
			output[i] = output[i - 1] * array[i - 1];
		
		
		for (int j = array.length - 1; j >= 0; j--) {
			output[j] = output[j] * lastOfRight;
			lastOfRight = lastOfRight *  array[j];
		}
		System.out.println("\nOutput: ");
		for (int m: output)
			System.out.print(" " + m);
	}
}