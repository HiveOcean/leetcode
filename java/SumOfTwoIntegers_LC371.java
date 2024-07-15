/*
	https://leetcode.com/problems/sum-of-two-integers/
	Sum of Two Integers - LeetCode #371
	
	Calculate the sum of two integers a and b, but you are not allowed to use the 
	operator + and -.

	Example 1:
		Input: a = 1, b = 2
		Output: 3

	Example 2:
		Input: a = -2, b = 3
		Output: 1
	
	Solution references:
	Use Bitwise operator
	https://www.geeksforgeeks.org/bitwise-operators-in-java/
	https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
	
*/

public class SumOfTwoIntegers_LC371 {
	
	public static void main(String[] args) {
		SumOfTwoIntegers_LC371 sum = new SumOfTwoIntegers_LC371();
		
		int[][] input = {{1,2},{-2,3},{10,99}};
		
		for (int i = 0; i < input.length; i++) {
			
			System.out.print("Sum of " + input[i][0] + " and " + input[i][1] + " is: ");
			System.out.println(sum.getSum(input[i][0],input[i][1]));
		}
		
	}
    public int getSum(int a, int b) {
		while (b != 0)  
        { 
            // carry now contains common 
            // set bits of x and y 
            int carry = a & b; 
  
            // Sum of bits of x and  
            // y where at least one  
            // of the bits is not set 
            a = a ^ b; 
  
            // Carry is shifted by  
            // one so that adding it  
            // to x gives the required sum 
            b = carry << 1; 
        } 
        return a; 
		  /*
		  // calculates a+b(+c) 
		   int sum=a^b^c,c2;
		   c= ((c&a)|(a&b)|(c&b))<<1;
		   while (c) {
			 c2=(c&sum)<<1;
			 sum^=c;
			c=c2;
		   }
		   printf("%d\n",sum);
		*/
    }
	
}