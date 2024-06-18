/*
	https://leetcode.com/problems/reverse-bits/
	Reverse Bits - LeetCode #190 Easy
	(It is about bit manipulation)
	
	Reverse bits of a given 32 bits unsigned integer.

	Note:

	* Note that in some languages such as Java, there is no unsigned integer type. 
	  In this case, both input and output will be given as a signed integer type. 
	  They should not affect your implementation, as the integer's internal binary 
	  representation is the same, whether it is signed or unsigned.
	* In Java, the compiler represents the signed integers using 2's complement 
	  notation. Therefore, in Example 2 above, the input represents the signed 
	  integer -3 and the output represents the signed integer -1073741825.
	  
	Follow up:
		If this function is called many times, how would you optimize it?

	Example 1:
		Input: n = 00000010100101000001111010011100
		Output:    964176192 (00111001011110000010100101000000)
		Explanation: The input binary string 00000010100101000001111010011100 
					 represents the unsigned integer 43261596, so return 964176192 
					 which its binary representation is 
					 00111001011110000010100101000000.

	Example 2:  (the input binary string's integer value exceed Integer.MAX_VALUE)
		Input: n = 11111111111111111111111111111101
		Output:   3221225471 (10111111111111111111111111111111)
		Explanation: The input binary string 11111111111111111111111111111101 
					 represents the unsigned integer 4294967293, so return 
					 3221225471 which its binary representation is 
					 10111111111111111111111111111111.

	Constraints:
		The input must be a binary string of length 32

	Reference:
	https://www.youtube.com/watch?v=vy288ZcbWRc CSNinja channel
	
	unsigned integer 10 in binary is 00001010 as 8 bits for integer, 
	reversed it will be 01010000 with unsigned integer value 80
	
	n 	= [0,0,0,0,1,0,1,0]
	ans	= [0,0,0,0,0,0,0,0]
	
	Step 1:
		n 	= 				[0,0,0,0,1,0,1,0]
		ans	= 				[0,0,0,0,0,0,0,0]
		ans = ans | (n&1)   [0,0,0,0,0,0,0,0]	// for the right most postion only
										   ^
	Step 2:
		n >>= 1 			[0,0,0,0,0,1,0,1]	// shift 1 position to the right
										   ^	// after the shift, a 0 will filled to the left most position
		ans <<= 1			[0,0,0,0,0,0,0,0]	// shift 1 position to the left
										 ^ ^
		ans = ans | (n&1)   [0,0,0,0,0,0,0,1]
										   ^
	continue on Step 2
		n >>= 1 			[0,0,0,0,0,0,1,0]	// shift 1 position to the right
										   ^
		ans <<= 1			[0,0,0,0,0,0,1,0]	// shift 1 position to the left
									   ^ ^ ^
		ans = ans | (n&1)   [0,0,0,0,0,0,1,0]
										   ^
		n >>= 1 			[0,0,0,0,0,0,0,1]	// shift 1 position to the right
										   ^		
		ans <<= 1			[0,0,0,0,0,1,0,0]   // until all 32 character shifted
									 ^ ^ ^ ^    
		ans = ans | (n&1)   [0,0,0,0,0,1,0,1]
										   ^		
		:
		// until all 8 character shifted, in this example, we use 8 bits.
		// in the problem, we use 32 bits.
		:
		ans = [0,1,0,1,0,0,0,0]
		
		Pseudocode:
		reverse_bits(n):
			ans = 0;
			for i from 1 to 32:
				ans <<= 1
				ans = ans | (n&1);
				n >>=1;
			return ans;
			
*/

public class ReverseBits_LC190 {
	public static void main(String[] args) {
		String s1 = "00000010100101000001111010011100";
		String s3 = "00000000000000000000000001111011";
		//123 is 1111011
		//String s2 = "11111111111111111111111111111101";
		// how to handle a signed integer.
		/*
		String s = "1111111111111111111111111111111111111111111111111111111110000101";
		long l = parseLong(s, 2);
		System.out.println(s +" => " + l);

		String s2 = s.substring(1);  // remove the sign bit
		long l2 = parseLong(s2, 2);
		System.out.println(s2 +" => " + l2);
		*/
		
		int num1 = Integer.parseInt(s1,2);
		//int num2 = Integer.parseInt(s2,2);
		int num3 = Integer.parseInt(s3,2);
		
		System.out.println(s1 + " output: " + reverseBits(num1));
		//System.out.println(s2 + " output: " + reverseBits(num2));
		System.out.println(s3 + " output: " + reverseBits(num3));
	}
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        System.out.println(n);
		int ans = 0;
		for (int i = 0; i <32; i++) {
			ans <<= 1;
			ans = ans | (n&1);
			n >>=1;
		}
		return ans;
		
    }
}