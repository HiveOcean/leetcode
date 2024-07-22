/*
	https://leetcode.com/problems/binary-tree-tilt/
	563. Binary Tree Tilt
	
	Given the root of a binary tree, return the sum of every tree node's 
	tilt.

	The tilt of a tree node is the absolute difference between the sum 
	of all left subtree node values and all right subtree node values. 
	If a node does not have a left child, then the sum of the left 
	subtree node values is treated as 0. The rule is similar if there 
	the node does not have a right child.

		 

	Example 1:


		Input: root = [1,2,3]
		Output: 1
		Explanation: 
		Tilt of node 2 : |0-0| = 0 (no children)
		Tilt of node 3 : |0-0| = 0 (no children)
		Tilt of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum is 3)
		Sum of every tilt : 0 + 0 + 1 = 1
		
	Example 2:


		Input: root = [4,2,9,3,5,null,7]
		Output: 15
		Explanation: 
		Tilt of node 3 : |0-0| = 0 (no children)
		Tilt of node 5 : |0-0| = 0 (no children)
		Tilt of node 7 : |0-0| = 0 (no children)
		Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum is 5)
		Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
		Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right subtree values are 9 and 7, which sums to 16)
		Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15
	
	Example 3:


		Input: root = [21,7,14,1,1,2,2,3,3]
		Output: 9
		 

	Constraints:
		The number of nodes in the tree is in the range [0, 104].
		-1000 <= Node.val <= 1000

		Related topics:
		Tree, Depth-First Search, Binary Tree

*/

import java.util.*;

class BinaryTreeTilt_LC0563 {
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];

		dfsHelper(root, tilt);
		return tilt[0];
    }

	private int dfsHelper(TreeNode node, int[] tilt) {
		if (node == null) {
			return 0;
		}
		tilt[0] += Math.abs(dfsHelper(node.left, tilt) - dfsHelper(node.right, tilt));
		
		return node.val + dfsHelper(node.left, tilt) + dfsHelper(node.right, tilt); 
	}
	public static void main(String[] args) {
		BinaryTreeTilt_LC0563 tiltValue = new BinaryTreeTilt_LC0563();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		System.out.println("Tree 1 tilt: " + tiltValue.findTilt(t1));
		
		TreeNode t2 = new TreeNode(4);
		t2.right = new TreeNode(9);
		t2.left = new TreeNode(2);
		t2.left.left = new TreeNode(3);
		t2.left.right = new TreeNode(5);
		t2.right.right = new TreeNode(7);
		System.out.println("Tree 2 tilt: " + tiltValue.findTilt(t2));
		
		TreeNode t3 = new TreeNode(21);
		t3.right = new TreeNode(14);
		t3.left = new TreeNode(7);
		t3.left.left = new TreeNode(1);
		t3.left.right = new TreeNode(1);
		t3.left.left.left = new TreeNode(3);
		t3.left.left.right = new TreeNode(3);
		t3.right.right = new TreeNode(2);
		t3.right.left = new TreeNode(2);
		System.out.println("Tree 3 tilt: " + tiltValue.findTilt(t3));
	}
}