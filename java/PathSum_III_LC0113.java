/*
	https://leetcode.com/problems/path-sum-ii/
	113. Path Sum II
	
	Given the root of a binary tree and an integer targetSum, return 
	all root-to-leaf paths where the sum of the node values in the 
	path equals targetSum. Each path should be returned as a list of 
	the node values, not node references.

	A root-to-leaf path is a path starting from the root and ending 
	at any leaf node. A leaf is a node with no children.
	
	Example 1:
					(5)		
				  /		\	
				(4)		(8)	
			   /   	   /   \
			 (11)    (13)  (4)	
			 /	\		   / \	
		   (7)	(2)		 (5) (1)

		Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
		Output: [[5,4,11,2],[5,8,4,5]]
		Explanation: There are two paths whose sum equals targetSum:
					5 + 4 + 11 + 2 = 22
					5 + 8 + 4 + 5 = 22
		
	Example 2:
					(1)		
				  /		\	
				(2)		(3)	

		Input: root = [1,2,3], targetSum = 5
		Output: []
		
	Example 3:

		Input: root = [1,2], targetSum = 0
		Output: []
		 

	Constraints:
		The number of nodes in the tree is in the range [0, 5000].
		-1000 <= Node.val <= 1000
		-1000 <= targetSum <= 1000

	Related topics:
		Backtracking, Tree, Depth-First Search, Binary Tree

*/
import java.util.*;

public class PathSum_III_LC0113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		
		dfsPathSum(root, result, path, targetSum);
		return result;
    }
	private void dfsPathSum(TreeNode node, List<List<Integer>> targetList, List<Integer> currentList, int targetSum) {
		if (node != null) {
			currentList.add(node.val);
			if (node.left == null && node.right == null && node.val - targetSum == 0) {
				targetList.add(new ArrayList(currentList));
			} else {
				targetSum -= node.val;				
				dfsPathSum(node.left, targetList, currentList, targetSum);
				dfsPathSum(node.right, targetList, currentList, targetSum);
			}
			currentList.remove(currentList.size() - 1);
		}
	}
	public static void main(String[] args) {
		PathSum_III_LC0113 findPaths = new PathSum_III_LC0113();
		
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(4);
		t1.right = new TreeNode(8);
		t1.left.left = new TreeNode(11);
		t1.left.left.left = new TreeNode(7);
		t1.left.left.right = new TreeNode(2);
		t1.right.left = new TreeNode(13);
		t1.right.right = new TreeNode(4);
		t1.right.right.right = new TreeNode(1);
		t1.right.right.left = new TreeNode(5);
		int target1 = 22;
		System.out.println("Tree 1 with sum " + target1 + " is: " );
		List<List<Integer>> ans1 = findPaths.pathSum(t1, target1);
		for (List list1 : ans1) 
			System.out.println(list1);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		int target2 = 5;
		System.out.println("Tree 2 with sum " + target2 + " is: " );
		List<List<Integer>> ans2 = findPaths.pathSum(t2, target2);
		for (List list2 : ans2) 
			System.out.println(list2);
		
		TreeNode t3 = new TreeNode(1);
		t3.left = new TreeNode(2);
		int target3 = 0;
		System.out.println("Tree 3 with sum " + target3 + " is: " );
		List<List<Integer>> ans3 = findPaths.pathSum(t3, target3);
		for (List list3 : ans3) 
			System.out.println(list3);
	
	}
}


	