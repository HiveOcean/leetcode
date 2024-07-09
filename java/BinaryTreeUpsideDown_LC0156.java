/*
	https://leetcode.com/problems/binary-tree-upside-down/
	156. Binary Tree Upside Down
	
	Given the root of a binary tree, turn the tree upside down and 
	return the new root.
	
	You can turn a binary tree upside down with the followiing steps:
	1. The original left child becomes the new root.
	2. The original root becoes the new right child.
	3. The original right child becomes the new left child.
	
			(X)				(X)				(Y)
			/ \			   -/|				/ \
		   /   \	->	   /        ->     /   \
		  \/   \/         /				  \/   \/
		 (Y)   (Z)		 (Y)-->(Z)		 (Z)   (X)  
	
	The mentioned steps are done level by level, it is guranteed that
	every node in the given tree has either 0 or 2 children.

	Example 1:

		Input: [1,2,3,4,5]

			1				
		   / \
		  2   3		  
		 / \
		4   5

		Output: return the root of the binary tree [4,5,2,#,#,3,1]

		   4
		  / \
		 5   2
			/ \
		   3   1
		   
	---------------------------------------------------------------------
	Given a binary tree where all the right nodes are either leaf nodes 
	with a sibling (a left node that shares the same parent node) or 
	empty, flip it upside down and turn it into a tree where the 
	original right nodes turned into left leaf nodes. Return the 
	new root.

		Clarification:

		Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

		The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

		Here's an example:

		   1
		  / \
		 2   3
			/ 
		   4
			\
			 5
		The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].

	Solution:
	https://www.geeksforgeeks.org/flip-binary-tree/
	only need to flip the left most branch, so it only recursive to reach
	the left most of the whole tree.
*/	
import java.util.*;

public class BinaryTreeUpsideDown_LC0156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return root;
		if (root.left == null && root.right == null) 
			return root;
		
		TreeNode newlyFlippedRoot = upsideDownBinaryTree(root.left);
		
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		
		return newlyFlippedRoot;
	}
	private void printTree(TreeNode root) {
		if (root == null) return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				System.out.print(node.val + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				size--;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		BinaryTreeUpsideDown_LC0156 upsidedown = new BinaryTreeUpsideDown_LC0156();
		/*
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.left = new TreeNode(4);
		t1.left.right = new TreeNode(5);
		upsidedown.printTree(t1);
		TreeNode ans1 = upsidedown.upsideDownBinaryTree(t1);
		upsidedown.printTree(ans1);
		*/
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.right.left = new TreeNode(4);
		t2.right.right = new TreeNode(5);
		t2.right.left.right = new TreeNode(7);
		t2.right.left.left = new TreeNode(6);
		upsidedown.printTree(t2);
		TreeNode ans2 = upsidedown.upsideDownBinaryTree(t2);
		upsidedown.printTree(ans2);
		
		
	}
}
