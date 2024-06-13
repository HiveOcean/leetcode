/*
	https://leetcode.com/problems/single-number/
	Single Number - LeetCode #136 Easy
	
	Given a non-empty array of integers nums, every element appears twice 
	except for one. Find that single one.

	** Follow up: Could you implement a solution with a linear runtime complexity 
				and without using extra memory?

	Example 1:
		Input: nums = [2,2,1]
		Output: 1

	Example 2:
		Input: nums = [4,1,2,1,2]
		Output: 4

	Example 3:
		Input: nums = [1]
		Output: 1
	 
	Constraints:
		1 <= nums.length <= 3 * 10e4
		-3 * 10e4 <= nums[i] <= 3 * 10e4
		Each element in the array appears twice except for one element which 
		appears only once.

*/
import java.util.*;

public class SingleNumber_LC136 {
	public static void main(String[] args) {
		int[][] nums = {{2,2,1}, {4,1,2,1,2},{1}};
		
		for (int i = 0; i < nums.length; i++) {
			int ans = singleNumber(nums[i]);
			System.out.println(ans);
		}
		System.out.println("\nUsing bitwise manipulation:");
		for (int i = 0; i < nums.length; i++) {
			int ans = singleNumber3(nums[i]);
			System.out.println(ans);
		}
		System.out.println("\nUsing HashTable :");
		for (int i = 0; i < nums.length; i++) {
			int ans = singleNumber2(nums[i]);
			System.out.println(ans);
		}
	}
	public static int singleNumber(int[] nums) {
		// Method 1
		Map<Integer,Integer> myMap = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (myMap.containsKey(nums[i])) {
				int value = myMap.get(nums[i]);

				myMap.put(nums[i], ++value);
			} else {
				myMap.put(nums[i], 1);
			}
		}
		Set<Map.Entry<Integer, Integer>> entrySet = myMap.entrySet();
		for (Map.Entry<Integer, Integer> entry: entrySet) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
			
        return -1;
		
    }
	public static int singleNumber2(int[] nums) {
		/* Method 2 , also use Hashtable<Integer, Integer>
		   instead of add to the Hashtable, when it same value see again
		   remove it from the hashtable.  So at the end, only the single
		   appearance value in the hashtable.
		*/
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (ht.containsKey(nums[i])) {
				ht.remove(nums[i]);
			} else {
				ht.put(nums[i],1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : ht.entrySet()) {
			return(entry.getKey());
			
		}
		return -1;
	}
	
	public static int singleNumber3(int[] nums) {
		/* Method 3
		   solution by Nick White - much better! without using extra space!
		   using bit manipulation.
		   https://www.youtube.com/watch?v=eXl0HBm2RrA
		   
		   if we take XOR of zero and some bit, it will return that bit 
				a xor 0 = a
		   if we take XOR of two same bits, it will return 0
				a xor a = 0
				
				a xor b xor a = (a xor a) xor b = 0 xor b = b
		*/
		int result = 0;
		
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}
}