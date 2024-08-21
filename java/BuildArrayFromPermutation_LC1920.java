/*
	https://leetcode.com/problems/build-array-from-permutation/
	1920. Build Array from Permutation

	Given a zero-based permutation nums (0-indexed), build an array ans of the same 
	length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.

	A zero-based permutation nums is an array of distinct integers from 0 to 
	nums.length - 1 (inclusive).

	Example 1:
		Input: nums = [0,2,1,5,3,4]
		Output: [0,1,2,4,5,3]
		Explanation: The array ans is built as follows: 
		ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
			= [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
			= [0,1,2,4,5,3]
	
	Example 2:
		Input: nums = [5,0,1,2,3,4]
		Output: [4,5,0,1,2,3]
		Explanation: The array ans is built as follows:
		ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
			= [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
			= [4,5,0,1,2,3]
	 
	Constraints:
		1 <= nums.length <= 1000
		0 <= nums[i] < nums.length
		The elements in nums are distinct.
	 
	Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?

	Tag:
		Array, Simulation
		
	Solution and explaination:
	The intuition behind doing the problem in constant space is that we must process the 
	original array 
	1.  in-place,
	2.  in a way that allows us to move the correct value (nums[nums[i]) to it's correct 
	    place (i)
	3.	while also keeping the original value, (nums[i]), in-place, in some way so that 
	    we can use it when needed later.

	We must keep nums[i] intact because if, for example, a later position in the array, 
	say j, has a value nums[j] = i, but we've overwrote the value at i (nums[i]) with 
	nums[nums[i]] already, then we're out of luck.

	To accomplish this task, we're going to use the fact that if we have a number of the 
	form a = qb + r, where b and r are not multiples of q and r < q, then we can extract 
	b and r with the following:

	1. 	b = a // q (where // is integer division) - we know that qb when divided by q will 
		give us b, however we still would need to get rid of the r // q. From our requirements 
		though, r < q, so r // q will always be 0, thus b = (qb//q) + (r//q) = b + 0 = b
	2.	r = a % q - we know that qb is a multiple of q, thus is divided by it cleanly and we 
	    know that r < q, so r is not a multiple of q, therefore the remainder when dividing 
		a = qb + r by q is just r
		
	We need to find a way to transform every element of nums into the form a = qb + r.

	At every i, nums[nums[i]] is going to be our b and the original value, nums[i] is our r. 
	Now we just need a q that satisfies the r < q, for all the possible r values (all nums[i]). 
	Luckily, we have such a q already, as our array values are indices into the same array. 
	q = len(nums) is always guaranteed to be greater than all nums[i] because each index 
	is always within the bounds of the array, from 0 to len(nums) - 1.
	
	//You have to transform each array element using a = r + bq formula. where q > r and b is not divisible by q. This is a trick used to do in-place array manupulation.
	//r holds the prev num and bq holds the answer.
	def buildArray(nums: List[int]) -> List[int]:
		q = len(nums)
		  
		# turn the array into a=qb+r
		for i in range(len(nums)):
			r = nums[i]
			
			# retrieve correct value from potentially already processed element
			# i.e. get r from something maybe already in the form a = qb + r
			# if it isnt already processed (doesnt have qb yet), that's ok b/c
			# r < q, so r % q will return the same value
			b = nums[nums[i]] % q
			
			# put it all together
			nums[i] = q*b + r
			
		# extract just the final b values
		for i in range(len(nums)):
			nums[i] = nums[i] // q
		  
		return nums
*/
import java.util.*;
public class BuildArrayFromPermutation_LC1920 {
	public int[] buildArray(int[] nums) {
		
		
        int n = nums.length;
		for(int i = 0; i < n; i++){
            // this is done to keep both old and new value together. 
            // going by the example of [5,0,1,2,3,4]
            // after this nums[0] will be 5 + 6*(4%6) = 5 + 24 = 29;
            // now for next index calulation we might need the original value of num[0] which can be obtain by num[0]%6 = 29%6 = 5;
            // if we want to get just he new value of num[0], we can get it by num[0]/6 = 29/6 = 4
            nums[i] = nums[i] + n*(nums[nums[i]] % n);
        }
		for(int i = 0;  i < n; i++){
            nums[i] = nums[i]/n;
        }
		return nums;
    }
	public static void main(String[] args) {
		BuildArrayFromPermutation_LC1920 bap = new BuildArrayFromPermutation_LC1920();
		int[] input1 = {0,2,1,5,3,4};
		
		for (int j: bap.buildArray(input1))
			System.out.print(j + " ");
		
		System.out.println();
		int[] input2 = {5,0,1,2,3,4};
		
		for (int j: bap.buildArray(input2))
			System.out.print(j + " ");
		
		
	}
}