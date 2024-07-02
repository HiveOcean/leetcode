/*
	https://leetcode.com/problems/permutations/
	Permutations - LeetCode #46
	
	Given an array nums of distinct integers, return all the possible permutations. 
	You can return the answer in any order.

	Example 1:
		Input: nums = [1,2,3]
		Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		
	Example 2:
		Input: nums = [0,1]
		Output: [[0,1],[1,0]]
		
	Example 3:
		Input: nums = [1]
		Output: [[1]]
		 
	Constraints:
		1 <= nums.length <= 6
		-10 <= nums[i] <= 10
		All the integers of nums are unique.

	https://www.youtube.com/watch?v=s7AvT7cGdSo Neetcode
	
							[]
					/		|		\
				  [1]	   [2]		[3]
			  /		\     /	  \			\
		    [1,2]  [1,3] [2,1] [2,3]	[3,1][3,2]
            /
	     [1,2,3] [1,3,2][2,1,3][2,3,1][3,1,2][3,2,1]
*/
import java.util.*;

public class Permutation_LC046 {
	public static void main(String[] args) {
		Permutation_LC046 permutation = new Permutation_LC046();
		
		int[][] input = {{1,2,3,4},{0,1},{1},{1,2,3}};
		
		for (int i = 0; i < input.length; i++) {
			System.out.print("[ ");
			for (int j: input[i])
				System.out.print(j + " ");
			System.out.print("] with combinations: [ ");
			
			List<List<Integer>> output = permutation.permute(input[i]);
			
			for (int j = 0; j < output.size(); j++) {
				System.out.print("[ ");
				for (int k: output.get(j))
					System.out.print(k + " ");
				System.out.print("] ");	
			}
			System.out.println("] ");
		}
	}
    public List<List<Integer>> permute(int[] nums) {
		//for (int n: nums)
		//	System.out.println("\n^^" + n);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		List<Integer> current_arr = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtrack(results, current_arr, nums, used);
		return results;
    }
	private  void backtrack(List<List<Integer>> results, List<Integer> current_arr, int[] nums, boolean[] used) {
		if ( current_arr.size() == nums.length ) {
			results.add(new ArrayList<Integer>(current_arr));
		}
		for (int i = 0; i < nums.length; i++) {
			if ( used[i])	// skip this as already visited.
				continue;
			
			used[i] = true;
			current_arr.add(nums[i]);
			backtrack(results, current_arr, nums, used);
			current_arr.remove(current_arr.size() - 1);  // back off when the path is done
			used[i] = false;							 // back off when the path is done
		}
	}

	/*
		https://www.youtube.com/watch?v=idmgLLNIC2U
		public List<List<Integer>>  permute(int[] nums) {
			List<List<Integer>> res = new ArrayList<>();
			if (nums == null || nums.length == 0)
				return res;
			boolean[] used = new boolean[nums.length];
			List<Integer> permutation = new ArrayList<>();
			
			helper(nums, permutation, used, res);
			return res;
		}
		private void helper(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> res) {
			if (permutation.size() == nums.length) {
				res.add(new ArrayList<>(permutation));
				return;
			}
			for (int i = 0; i < nums.length; ++i) {
				if (used[i])
					continue;
				
				use[i] = true;
				permutation.add(nums[i]);
				helper(nums, permutation, used,  res);
				permutation.remove(permutation.size() - 1);
				used[i] = false;
				
			}
		}
		
		https://www.youtube.com/watch?v=foBqt8E94mI
		public List<List<Integer>>  permute(int[] nums) {
			List<List<Integer>> subset = new ArrayList<>();
			boolean[] used = new boolean[nums.length];
			dfs(subset, nums, new ArrayList(), used);
			return subset;
		}
		private void dfs( List<List<Integer>> subset, int[] nums, List<List<Integer>> current, boolean[] used) {
			if (current.size() ==  nums.length) {
				subset.add(new ArrayList(current));
				return;
			}

			for (int i = 0; i < nums.length; i++) {
				if (used[i] == true) continue;
				
				current.add(nums[i]);
				used[i] = true;
				dfs(subset, nums, current, used);
				current.remove(current.size() - 1);
				used[i] = false;
			}
		}
		
		https://www.youtube.com/watch?v=Nabbpl7y4Lo
		void Backtrack(res, args) 					=> void Backtrack(res, nums, permutation, used)
			if (Goal reached)						=> 		if ( permutation.size() == nums.size()
				add solution to res					=>			add permuttaion to res
				return								=>			return
			
			for (int i = 0; i < NB_CHOICES; i++)	=> for (int i=0; i < nums.size(); i++)
				if (Choices[i] is valid) 			=>		//if ( did we already use nums[i]) // distinct number Hashmap or									
					make choices[i]					=>		// Or array of booleans  used[i] is true if nums[i] is used , false otherwise
					Backtrack(res, args)			=>		if (not used[i])
					undo choices[i]								used[i] = true
																permutation.push_back(num[i])
																Backtrack(res, args)
																used[i] = false
																permutation.pop_back();
	
		https://www.youtube.com/watch?v=w4SjNXKLsv4
							 [ ]
							  |
			   --------------------------------			  
			   |			  |				  |
			  [1]			 [2]			 [3]
			/	 \		   /	  \		   /	  \
		 [1,2]	 [1,3]	 [2,1]	 [2,3]	 [3,1]	 [3,2]
		   |	   |	   |	   |	   |	   |
		[1,2,3]	[1,3,2]	[2,1,3]	[2,3,1]	[3,1,2]	[3,2,1]
		
	*/
}