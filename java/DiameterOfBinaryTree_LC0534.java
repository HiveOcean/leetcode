/*
	https://leetcode.com/problems/diameter-of-binary-tree/
	534. Diameter of Binary Tree
	
	Given the root of a binary tree, return the length of the diameter of 
	the tree.

	The diameter of a binary tree is the length of the longest path 
	between any two nodes in a tree. This path may or may not pass through 
	the root.

	The length of a path between two nodes is represented by the number 
	of edges between them.

		 

	Example 1:
					(1)	
				  /		\
				(2)	    (3)
			   /	\
			 (4)	(5)
				
		Input: root = [1,2,3,4,5]
		Output: 3
		Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
		
	Example 2:
		Input: root = [1,2]
		Output: 1
		 

	Example 3:
				 (10)	
				  /		 	
				(5)	     		
			   /	\	  		
			 (4)	(7)		   
			 /        \		
		   (3) 	      (8) 
		                \
					    (9)
				  
		output: 5
		Explanation: 5 is the length of path [3,4,5,6,8,9]
			
					  
	Constraints:
		The number of nodes in the tree is in the range [1, 10^4].
		-100 <= Node.val <= 100
		
	Related Topics:
		Tree, Depth-First-Search, Binary Tree
		
	Reference:
	https://aaronice.gitbook.io/lintcode/trees/diameter-of-a-binary-tree
	https://leetcode.com/problems/diameter-of-binary-tree/discuss/240383/Java-Solution-from-pratik
	http://cslibrary.stanford.edu/110/BinaryTrees.html (Solution #3)
	Explanation of diameter of binary tree
	https://www.youtube.com/watch?v=bkxqA8Rfv04
	
	Python:
class Solution:
	def diameterOfBinaryTree(self, root: TreeNode) -> int:
		res = [0]	// to store the max diameter
		
		def dfs(root):
			if not root:
				return -1;  // height of a null tree is -1 
				
			left = dfs(root.left)	// height of left subtree
			right = dfs(root.right)	// height of right subtree
			
			// diameter of current node is height of left + right + 2 (since null node is -1 height)
			// D = L + R + 2
			res[0] = max(res[0], 2 + left + right)
			res[0] = 2 + left + right
			
			return 1 + max(left, right)		// the height running through the root node
		
		
		dfs(root)
		return res[0];
		
	
	
*/
import java.util.*;

public class DiameterOfBinaryTree_LC0534 {
	int maxdiameter = 0;
	
    public int diameterOfBinaryTree(TreeNode root) {
		maxdiameter = 0;
		int height = maxDepth(root);
		System.out.println("\nHeight of Tree: " + height);
		return maxdiameter;
    }
	private int maxDepth(TreeNode node) {
        if (node == null)
			return 0;
		
		int	lDepth = maxDepth(node.left);
		int	rDepth = maxDepth(node.right);

		// use the larger one 
		maxdiameter = Math.max(maxdiameter, lDepth + rDepth);
		
		// the height of the subtree at the node is the max of either left or right tree + 1
		return Math.max(lDepth, rDepth) + 1; 
	}
	public static void main(String[] args) {
		DiameterOfBinaryTree_LC0534 maxDepth = new DiameterOfBinaryTree_LC0534();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(4);
		t1.left.right = new TreeNode(5);
		t1.right = new TreeNode(3);	
		System.out.println("Diameter t1 is: " + maxDepth.diameterOfBinaryTree(t1));
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		System.out.println("Diameter t2 is: " + maxDepth.diameterOfBinaryTree(t2));
		
		
		TreeNode t3 = new TreeNode(10);
		t3.left = new TreeNode(5);
		t3.left.left = new TreeNode(4);
		t3.left.left.left = new TreeNode(3);
		t3.left.right = new TreeNode(7);
		t3.left.right.right = new TreeNode(8);
		t3.left.right.right.right = new TreeNode(9);
		System.out.println("Diameter t3 is: " + maxDepth.diameterOfBinaryTree(t3));
		
		TreeNode t4 = new TreeNode(1);
		System.out.println("Diameter t4 is: " + maxDepth.diameterOfBinaryTree(t4));
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}