/*
	https://leetcode.com/problems/balanced-binary-tree/
	110. Balanced Binary Tree
	
	Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as:

	a binary tree in which the left and right subtrees of every node differ in 
	height by no more than 1.

	Example 1:
							(3)
						  /		 \
						(9)	    (20)
							   /    \
							 (15)   (7)

		Input: root = [3,9,20,null,null,15,7]
		Output: true
		
	Example 2:
						 (1)
						/	\
					  (2)   (2)
					 /   \
				  (3)    (3)
				 /   \
			   (4)   (4)

		Input: root = [1,2,2,3,3,null,null,4,4]
		Output: false
	
	Example 3:

	Input: root = []
	Output: true
	
	Example 4:
						 (1)
						/	\
					  (2)   (2)
					  /		   \
				   (3)			(3)
				   /			   \
				 (4)               (4)
	output: false
	
	Constraints:

	The number of nodes in the tree is in the range [0, 5000].
	-10^4 <= Node.val <= 10^4
	
	Related topics:
	Tree, Depth-First Search, Binary Tree
	
	Solution:
	To check if a tree is height-balanced, get the height of left and right subtrees. 
	Return true if difference between heights is not more than 1 
	and left and right subtrees are balanced, otherwise return false. 
*/
public class BalancedBinaryTree_LC0110 {
    public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		
		int leftDepth = findSubTreeDepth(root.left);
		int rightDepth = findSubTreeDepth(root.right);
		return (Math.abs(leftDepth - rightDepth) <= 1  && isBalanced(root.left) && isBalanced(root.right));
		// Cannot only base on the overall height, the subtree itself are not balanced in test case 4.
		//return (Math.abs(leftDepth - rightDepth) <= 1  );
    }
	private int findSubTreeDepth(TreeNode node) {
		if (node == null)
			return 0;
		return (1 + Math.max(findSubTreeDepth(node.left), findSubTreeDepth(node.right)));
	}
	public static void main(String[] args) {
		BalancedBinaryTree_LC0110 balancedTree = new BalancedBinaryTree_LC0110();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		
		System.out.println("Tree with root value " + t1.val + 
				" is balanced binary tree? " + balancedTree.isBalanced(t1));
				
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(2);
		t2.left.left = new TreeNode(3);
		t2.left.right = new TreeNode(3);
		t2.left.left.left = new TreeNode(4);
		t2.left.left.right = new TreeNode(4);
		System.out.println("Tree with root value " + t2.val + 
				" is balanced binary tree? " + balancedTree.isBalanced(t2));
		
		TreeNode t3 = new TreeNode();
		System.out.println("Tree with root value "  + 
				" is balanced binary tree? " + balancedTree.isBalanced(t3));
		
		TreeNode t4 = new TreeNode(4);
		t4.left = new TreeNode(2);
		t4.right = new TreeNode(2);
		t4.left.left = new TreeNode(3);
		t4.left.left.left = new TreeNode(4);
		t4.right.right = new TreeNode(3);
		t4.right.right.right = new TreeNode(4);
		System.out.println("Tree with root value "  + t4.val + 
				" is balanced binary tree? " + balancedTree.isBalanced(t4));
	}
}
	