/*
	https://leetcode.com/problems/subsets/
	Subsets - LeetCode #78

	Given an integer array nums, return all possible subsets (the power set).

	The solution set must not contain duplicate subsets.

	Example 1:
		Input: nums = [1,2,3]
		Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

	Example 2:
		Input: nums = [0]
		Output: [[],[0]]

	Constraints:
		1 <= nums.length <= 10
		-10 <= nums[i] <= 10

	Related topics:
		backtracking/recursion
*/
import java.util.*;

public class Subsets_LC078 {
	
	public static void main(String[] args) {
		Subsets_LC078 findSubset = new Subsets_LC078();	
		int[][] inputs = {{1,2,3},{0},{1,2},{1,2,3,4}};
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < inputs.length; i++) {
			System.out.print("[ ");
			for (int k: inputs[i])
				System.out.print(k + " ");
			System.out.print("] with combinations: [ ");
			
			output = findSubset.subsets1(inputs[i]); 
			for (int j = 0; j < output.size(); j++) {
				System.out.print("[ ");
				for (int k: output.get(j))
					System.out.print(k + " ");
				System.out.print("] ");	
			}
			System.out.println("]");
			output.clear();
		}
	}
	// Method 1: https://www.youtube.com/watch?v=B8ZEcSAliM4
    public  List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return results;
		
		backtrack1(new ArrayList<Integer>(), nums, 0, results);
		return results;
    }
	private void backtrack1( ArrayList<Integer> current, int[] nums, int start, List<List<Integer>> results) {
		
		results.add(new ArrayList<Integer>(current));
			
		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			backtrack1(current, nums,i + 1,results);
			current.remove(current.size() - 1);
		}
	}
	// Method 2
	// https://www.youtube.com/watch?v=bGC2fNALbNU
}
/*
https://leetcode.com/problems/subsets/solution/
Solution Pattern
Let us first review the problems of Permutations / Combinations / Subsets, 
since they are quite similar to each other and there are some common 
strategies to solve them.

First, their solution space is often quite large:

	Permutations: N!.

	Combinations: C_N^k = \frac{N!}{(N - k)! k!}C 
			C (from k to N) = N!/(N−k)!k!

	Subsets: 2^N, since each element could be absent or present.

Given their exponential solution space, it is tricky to ensure that the 
generated solutions are complete and non-redundant. It is essential to 
have a clear and easy-to-reason strategy.

There are generally three strategies to do it:

	Recursion

	Backtracking

	Lexicographic generation based on the mapping between binary bitmasks 
	and the corresponding permutations / combinations / subsets.

As one would see later, the third method could be a good candidate 
for the interview because it simplifies the problem to the generation 
of binary numbers, therefore it is easy to implement and verify that 
no solution is missing.

Besides, this method has the best time complexity, and as a bonus, it 
generates lexicographically sorted output for the sorted inputs.


Approach 1: Cascading
Intuition

Let's start from empty subset in output list. At each step one takes new 
integer into consideration and generates new subsets from the existing ones.
	nums = {1,2,3}
	1. start from empty subset output = {}
	2. Take 1 into consideration and add new subsets by updating existing 
	   one.  output = {}{1}
	3. Take 2 into consideration and add new subsets by updating existing 
	   ones. output = {}{1}{2}{1,2}
	4. Take 3 into consideration and add new subsets by updating existing
	   ones. output = {}{1}{2}{1,2}{3}{1,3}{2,3}{1,2,3}

 class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    output.add(new ArrayList<Integer>());

    for (int num : nums) {
      List<List<Integer>> newSubsets = new ArrayList();
      for (List<Integer> curr : output) {
        newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
      }
      for (List<Integer> curr : newSubsets) {
        output.add(curr);
      }
    }
    return output;
  }
}
Complexity Analysis

Time complexity: O(N x 2^N) to generate all subsets and then copy them into 
output list.

Space complexity:(N × 2^N). This is exactly the number of solutions for subsets 
multiplied by the number NN of elements to keep for each subset.

For a given number, it could be present or absent (i.e. binary choice) in a subset 
solution. As as result, for N numbers, we would have in total 2^N choices (solutions).

Approach 2: Backtracking
Algorithm

Power set is all possible combinations of all possible lengths, from 0 to n.

Given the definition, the problem can also be interpreted as finding the 
power set from a sequence.

So, this time let us loop over the length of combination, rather than the candidate 
numbers, and generate all combinations for a given length with the help of 
backtracking technique.

	nums = {1,2,3}
	
	iterate over all possible lengths: from 0 to new
		all subsets of length 0: {}
		all subsets of length 1: {1}{2}{3}
		all subsets of length 2: {1,2}{2,3}{1,3}
		all subsets of length 3: {1,2,3}

Backtracking is an algorithm for finding all solutions by exploring all potential 
candidates. If the solution candidate turns to be not a solution (or at least not 
the last one), backtracking algorithm discards it by making some changes on the 
previous step, i.e. backtracks and then try again.

	backtracking: generate all possible subsets of length 2
	nums = {1,2,3}
	
	1. take nums[0] = 1 as the first element
	2. use next elements: nums[1] and nums[2] to complete the subset
		2.1 use nums[1] = 2.  The subset is complete	{1,2} --> good 
		2.2 backtrack: pop nums[1] out 					{1}
		2.3 use nums[2] = 3.  The subset is complete.	{1,3} --> good
	3. take nums[1] = 2 as the first element.			{2}
	4. use next elements: nums[2] to completee the subset {2,3} --> good
	

Algorithm

We define a backtrack function named backtrack(first, curr) which takes the 
index of first element to add and a current combination as arguments.

	- If the current combination is done, we add the combination to 
	  the final output.

	- Otherwise, we iterate over the indexes i from first to the length 
	  of the entire sequence n.

		- Add integer nums[i] into the current combination curr.

		- Proceed to add more integers into the combination : backtrack(i + 1, curr).

		- Backtrack by removing nums[i] from curr.

class Solution {
  List<List<Integer>> output = new ArrayList();
  int n, k;

  public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
    // if the combination is done
    if (curr.size() == k) {
      output.add(new ArrayList(curr));
      return;
    }
    for (int i = first; i < n; ++i) {
      // add i into the current combination
      curr.add(nums[i]);
      // use next integers to complete the combination
      backtrack(i + 1, curr, nums);
      // backtrack
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    n = nums.length;
    for (k = 0; k < n + 1; ++k) {
      backtrack(0, new ArrayList<Integer>(), nums);
    }
    return output;
  }
}

Complexity Analysis

Time complexity: O(N × 2^N) to generate all subsets and then copy them into 
output list.

Space complexity: O(N). We are using O(N) space to maintain curr, and are 
modifying curr in-place with backtracking. Note that for space complexity 
analysis, we do not count space that is only used for the purpose of returning 
output, so the output array is ignored.


Approach 3: Lexicographic (Binary Sorted) Subsets
Intuition

The idea of this solution is originated from Donald E. Knuth.

The idea is that we map each subset to a bitmask of length n, where 1 on 
the ith position in bitmask means the presence of nums[i] in the subset, 
and 0 means its absence.

	nums	{1 2 3}		{1 2 |3|}		{1 |2| 3} 	{|1||2||3|}
	bitmask {0 0 0}		{0 0 |1|}		{0 |1| 0}	{|1||1||1|}
	subset  {     }     {    |3|}       {  |2|  }	{|1||2||3|}
	
For instance, the bitmask 0..00 (all zeros) corresponds to an empty 
subset, and the bitmask 1..11 (all ones) corresponds to the entire 
input array nums.

Hence to solve the initial problem, we just need to generate n bitmasks 
from 0..00 to 1..11.

It might seem simple at first glance to generate binary numbers, but 
the real problem here is how to deal with zero left padding, because 
one has to generate bitmasks of fixed length, i.e. 001 and not just 1. 
For that one could use standard bit manipulation trick:

	int nthBit = 1 << n;
	for (int i = 0; i < (int)Math.pow(2, n); ++i) {
		// generate bitmask, from 0..00 to 1..11
		String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
	
or keep it simple stupid and shift iteration limits:

	for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
	  // generate bitmask, from 0..00 to 1..11
	  String bitmask = Integer.toBinaryString(i).substring(1);
  
Algorithm

	- Generate all possible binary bitmasks of length n.

	- Map a subset to each bitmask: 1 on the ith position in bitmask means 
	  the presence of nums[i] in the subset, and 0 means its absence.

	- Return output list.

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();
    int n = nums.length;

    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1') curr.add(nums[j]);
      }
      output.add(curr);
    }
    return output;
  }
}


*/