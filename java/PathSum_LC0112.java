/*
	https://leetcode.com/problems/path-sum/
	112. Path Sum
	
	Given the root of a binary tree and an integer targetSum, return true if the 
	tree has a root-to-leaf path such that adding up all the values along the path 
	equals targetSum.

	A leaf is a node with no children.

		 

	Example 1:
						   (5)
						/		\
					  (4)		(8)
					/	      /		 \
				 (11)		(13)	 (4)
				/	\				   \
			  (7)   (2)				   (1)

		Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
		Output: true
		Explanation: The root-to-leaf path with the target sum is shown.
	
	Example 2:
							(1)
						  /		\
						(2)		(3)

		Input: root = [1,2,3], targetSum = 5
		Output: false
		Explanation: There two root-to-leaf paths in the tree:
			(1 --> 2): The sum is 3.
			(1 --> 3): The sum is 4.
			There is no root-to-leaf path with sum = 5.
	
	Example 3:
		Input: root = [], targetSum = 0
		Output: false
		Explanation: Since the tree is empty, there are no root-to-leaf paths.
		 

	Constraints:
		The number of nodes in the tree is in the range [0, 5000].
		-1000 <= Node.val <= 1000
		-1000 <= targetSum <= 1000

*/
import java.util.*;
public class PathSum_LC0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
		
		if (root.left == null && root.right == null && targetSum == root.val)
			return true;
		
		return (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val));
		
    }
	public static void main(String[] args) {
		PathSum_LC0112 pathSum = new PathSum_LC0112();
		
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(4);
		t1.right = new TreeNode(8);
		t1.left.left = new TreeNode(11);
		t1.left.left.left = new TreeNode(7);
		t1.left.left.right = new TreeNode(2);
		t1.right.left = new TreeNode(13);
		t1.right.right = new TreeNode(4);
		t1.right.right.right = new TreeNode(1);
		int targetSum1 = 22;
		System.out.println("Tree 1 with sum " + targetSum1 + ": " + pathSum.hasPathSum(t1, targetSum1));
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		int targetSum2 = 5;
		System.out.println("Tree 2 with sum " + targetSum2 + ": " + pathSum.hasPathSum(t2, targetSum2));
		
		TreeNode t3 = null;
		int targetSum3 = 0;
		System.out.println("Tree 3 with sum " + targetSum3 + ": " + pathSum.hasPathSum(t3, targetSum3));
		
	}
}