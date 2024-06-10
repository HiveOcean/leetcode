/*
	https://leetcode.com/problems/maximum-depth-of-binary-tree/
	Maximum Depth of Binary Tree - LeetCode #104
	
	Given a binary tree, find its maximum depth.

	The maximum depth is the number of nodes along the longest path from the root 
	node down to the farthest leaf node.

	Note: A leaf is a node with no children.

	Example:
		Given binary tree [3,9,20,null,null,15,7],

				3
			   / \
			  9  20
				/  \
			   15   7
		return its depth = 3.

 
	Reference:
	https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
	
	Solution:
	https://www.youtube.com/watch?v=AWIJwNf0ZQE
	- if the node == null, return -1
	  one level up to the parent, do +1
			2
		 /	   \
		4		5
	- so the height from node 5 to node 2 is 0 as at node 5, it get -1 on right subtree
	  and -1 on left subtree, 
	  Then find the max(right subtree height, left subtree height) which is -1
	  Go back to parent, it does -1 + 1, =>0
	- Same process at node 4.  So as the height from node 4 to 2 is 0
	- Then at node 2, it max(height of right subtree, height of left subtree) => max(0,0) => 0
	  It gets 0, and then go back to parent of node 2, we 0 + 1, => 1
	  
				  1
			  /		  \
			2		   3
		  /	  \			\
		 4	   5		 6
						/
					   7
	- Next, what is the height of the right subtree,
	- Node 1 will ask node 3.  Node 3 will check the left and right subtree.
	- Node 6 will ask node 7.
	- At node 7, it has no child, it will get -1.  max(-1, -1) => -1
	- Go back to parent, node 6, it does -1 + 1 => 0 (from 6 node to 7node)
	- At node 6, the right substree is -1,  so max(height of right subtree, height of left subtree)
	  is max(0, -1) => 0
	- At node 3, it does +1. From node 3 to node 6 is 0 + 1 =>1
	  the left subtree is -1.
	- At node 1 to node 3, it will get max (-1, 1) => 1 and do +1=> 2
	- The height of the right subtree is 2 + 1 = 3
	
			
*/

public class MaxDepthOfBinaryTree_LC104 {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		
		System.out.println("[3,9,20,null,null,15,7] is with depth = " + maxDepth(root1));
		
		int[] data2 = {1,2,2,3,3,9};
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.right = new TreeNode(3);
		root2.right = new TreeNode(2);
		root2.right.right = new TreeNode(3);
		root2.right.right.right = new TreeNode(9);
		
		System.out.println("[1,2,2,null,3,null,3,null,9] is with depth = " + maxDepth(root2));
		
		int[] data3 = {5,3,2,4,1};
		TreeNode root3 = new TreeNode(5);
		root3.left = new TreeNode(3);
		root3.left.left = new TreeNode(2);
		root3.left.left.left = new TreeNode(4);
		root3.left.left.left.left = new TreeNode(1);
		System.out.println("[5,3,2,4,1] is with depth = " + maxDepth(root3));
	}
    public static int maxDepth(TreeNode root) {
		if ( root == null) return -1;
		
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		
        return leftHeight > rightHeight ? leftHeight + 1: rightHeight + 1;	
    }
	public int maxDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
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
