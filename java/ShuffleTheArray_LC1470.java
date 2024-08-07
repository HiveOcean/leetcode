/*
	https://leetcode.com/problems/shuffle-the-array/
	1470. Shuffle the Array (Easy)

	Given the array nums consisting of 2n elements in the form 
	[x1,x2,...,xn,y1,y2,...,yn].

	Return the array in the form [x1,y1,x2,y2,...,xn,yn].

	Example 1:
	Input: nums = [2,5,1,3,4,7], n = 3
	Output: [2,3,5,4,1,7] 
	Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

	Example 2:
	Input: nums = [1,2,3,4,4,3,2,1], n = 4
	Output: [1,4,2,3,3,2,4,1]

	Example 3:
	Input: nums = [1,1,2,2], n = 2
	Output: [1,2,1,2]
	 

	Constraints:

	1 <= n <= 500
	nums.length == 2n
	1 <= nums[i] <= 10^3

*/
public class ShuffleTheArray_LC1470 {
    public int[] shuffle(int[] nums, int n) {
		int[] ans = new int[n];
		int index;
		
        for (int i = 0; i < n/2; i++) {
			index = i * 2;
			ans[index] = nums[i];
			ans[index + 1] = nums[i  + n/2];
			
		}
		return ans;
    }
	public static void main(String[] args) {
		ShuffleTheArray_LC1470 sa = new ShuffleTheArray_LC1470();
		int[] input1 = {2,5,1,3,4,7};
		int[] input2 = {1,2,3,4,4,3,2,1};
		int[] input3 = {1,1,2,2};
		
		for (int i: sa.shuffle(input1, input1.length))
			System.out.print(i + " ");
		
		System.out.println();
		for (int i: sa.shuffle(input2, input2.length))
			System.out.print(i + " ");
		
		System.out.println();
		for (int i: sa.shuffle(input3, input3.length))
			System.out.print(i + " ");
		
		System.out.println();
	}
}