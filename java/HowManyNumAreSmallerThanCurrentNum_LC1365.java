/*
	https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
	1365. How Many Numbers Are Smaller Than the Current Number

	Given the array nums, for each nums[i] find out how many numbers in the array are 
	smaller than it. That is, for each nums[i] you have to count the number of valid j's 
	such that j != i and nums[j] < nums[i].

	Return the answer in an array.

	Example 1:
		Input: nums = [8,1,2,2,3]
		Output: [4,0,1,1,3]
		Explanation: 
		For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
		For nums[1]=1 does not exist any smaller number than it.
		For nums[2]=2 there exist one smaller number than it (1). 
		For nums[3]=2 there exist one smaller number than it (1). 
		For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
	+
	Example 2:
		Input: nums = [6,5,4,8]
		Output: [2,1,0,3]
		
	Example 3:
		Input: nums = [7,7,7,7]
		Output: [0,0,0,0]
	 
	Constraints:
		2 <= nums.length <= 500
		0 <= nums[i] <= 100
		
	Solution:
	https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/524996/JAVA-beats-100-O(n)
	https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/641884/Java-O(n)-1ms-less-memory-than-100-explained
	This solution maps the numbers in the array to a counter.
	Since the numbers are between 0 and 100 I create an array of length 101 and iterate over 
	the original array and put each number in the corresponding index in the bucket array. 
	If the original array contains the number 1, number 1 goes to index 1 in the new array.

	Since the nums array may contain duplicates, in the bucket array I store a counter for 
	each of the numbers, not the number itself. So if the number 1 occurs 3 times in the nums 
	array, in index 1 of the bucket array we store the value 3.

		4 5 1 3 5 4 4 1 4 5 1 4
		becomes
		0 3 0 1 5 3

		(0 zeros, 3 ones, 0 twos, 1 three, 5 fours and 3 fives)

	After the bucket array has been populated, I iterate it again from index 1 to index 100 
	and to each of the values I add the previous value. A similar example with a smaller array:

		0 3 0 1 5 3
		becomes
		0 3 3 4 9 12

		(0 numbers are <= 0, 3 numbers are are <= 1, 3 numbers are are <= 2, 4 numbers are 
		are <= 3 and so on.)

	That way each position contains how many numbers are smaller or equal than the current 
	position.

	Finally I iterate the original nums array and get the index from bucket corresponding 
	the value of the number from nums - 1 (minus one because without it we also get the ones 
	equal to it and we only want smaller). When doing this I assign the result as the new 
	value in the nums array instead of creating a new array. Also if value is 0 we 
	automatically return 0 as no element can be smaller than it.

		For example, if nums array is
		4 5 1 3 5 4 4 1 4 5 1 4

		and the final bucket mapping is:
		0 3 3 4 9 12

		buck[4-1] = 4
		buck[5-1] = 9
		buck[1-1] = 0
		buck[3-1] = 3
		buck[5-1] = 9
		buck[4-1] = 4
		buck[4-1] = 4
		buck[1-1] = 0
		buck[4-1] = 4
		buck[5-1] = 9
		buck[1-1] = 0
		buck[4-1] = 4

*/
import java.util.*;

public class HowManyNumAreSmallerThanCurrentNum_LC1365 {
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] buck = new int[101];
        
        for(int i=0; i<nums.length; i++) {
            buck[nums[i]] +=1;
        }
        
        for(int j=1; j<= 100; j++) {
            buck[j] += buck[j-1];
        }
        
        for(int k=0; k< nums.length; k++) {
            int pos = nums[k];
            nums[k] = pos==0 ? 0 : buck[pos-1];
        }
        
        return nums;
    }
	public static void main(String[] args) {
		HowManyNumAreSmallerThanCurrentNum_LC1365 smallerThanCurrentNum = new HowManyNumAreSmallerThanCurrentNum_LC1365();
		
		int[] input1 = {8,1,2,2,3}; // output [4,0,1,1,3]
		int[] input2 = {6,5,4,8};	// output [2,1,0,3]
		int[] input3 = {7,7,7,7};	// output [0,0,0,0]
		int[] input4 = {4, 5, 1, 3, 5, 4, 4, 1, 4, 5, 1, 4};  // output [4,9,0,3,9,4,4,0,4,9,0,4]
		
		System.out.println(Arrays.toString(input1) + " with output " + 
			Arrays.toString(smallerThanCurrentNum.smallerNumbersThanCurrent1(input1)));
		System.out.println(Arrays.toString(input2) + " with output " + 
			Arrays.toString(smallerThanCurrentNum.smallerNumbersThanCurrent1(input2)));
		System.out.println(Arrays.toString(input3) + " with output " + 
			Arrays.toString(smallerThanCurrentNum.smallerNumbersThanCurrent1(input3)));
		System.out.println(Arrays.toString(input4) + " with output " + 
			Arrays.toString(smallerThanCurrentNum.smallerNumbersThanCurrent1(input4)));
	}
}