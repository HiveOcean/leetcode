/*
	https://leetcode.com/problems/number-of-good-pairs/
	1512. Number of Good Pairs (Easy)
	
	Given an array of integers nums, return the number of good pairs.

	A pair (i, j) is called good if nums[i] == nums[j] and i < j.	 

	Example 1:
		Input: nums = [1,2,3,1,1,3]
		Output: 4
		Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

	Example 2:
		Input: nums = [1,1,1,1]
		Output: 6
		Explanation: Each pair in the array are good.

	Example 3:
		Input: nums = [1,2,3]
		Output: 0
	 

	Constraints:

		1 <= nums.length <= 100
		1 <= nums[i] <= 100

	Related Topics:
		Array, Hash Table, Math, Counting
	
	Hints:
		Count how many times each number appears. If a number appears n times, 
		then n * (n – 1) // 2 good pairs can be made with this number.
*/
import java.util.*;

public class NumberOfGoodPairs_LC1512 {
    public int numIdenticalPairs(int[] nums) {
        Hashtable<Integer, Integer>  htable = new Hashtable<>();

		for (int i = nums.length - 1; i >= 0; i--) {
			if (htable.containsKey(nums[i])) {
				htable.put(nums[i], htable.get(nums[i]) + 1);
			} else {
				htable.put(nums[i], 1);
			}
		}
		Enumeration<Integer> values = htable.elements();
        int pairs = 0;
        //iterate the values
		while( values.hasMoreElements() ){
			int value = values.nextElement() ;
			pairs += value * (value - 1) / 2 ;
		}
		// Using Map.Entry.
		//for (Map.Entry<Integer, Integer> e : htable.entrySet()) {
		//	int appearances = e.getValue();
		//	pairs += appearances * (appearances - 1 ) / 2;                       
		//}
		return pairs;
    }
	public static void main(String[] args) {
		NumberOfGoodPairs_LC1512 ngp = new NumberOfGoodPairs_LC1512();
		
		int[] input1 = {1,2,3,1,1,3};
		int[] input2 = {1,1,1,1};
		int[] input3 = {1,2,3};
		
		System.out.println(Arrays.toString(input1) + " with pairs: "  + ngp.numIdenticalPairs(input1));
		System.out.println(Arrays.toString(input2) + " with pairs: "  + ngp.numIdenticalPairs(input2));
		System.out.println(Arrays.toString(input3) + " with pairs: "  + ngp.numIdenticalPairs(input3));
	}
}