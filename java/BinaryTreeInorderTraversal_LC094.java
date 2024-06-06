/*
	https://leetcode.com/problems/binary-tree-inorder-traversal/
	Binary Tree Inorder Traversal - LeetCode #094
	
	Given the root of a binary tree, return the inorder traversal of its 
	nodes' values.  Inorder (Left, Root, Right).

	Example 1:
					(1)
						\
						(2)
						/
					 (3)
		Input: root = [1,null,2,3]
		Output: [1,3,2]

	Example 2:
		Input: root = []
		Output: []

	Example 3:
		Input: root = [1]
		Output: [1]

	Example 4:
					(1)
				   /
				 (2)
		Input: root = [1,2]
		Output: [2,1]
		
	Example 5:
					(1)
						\
						(2)
		Input: root = [1,null,2]
		Output: [1,2]

	Constraints:
		* The number of nodes in the tree is in the range [0, 100].
		* -100 <= Node.val <= 100
 
	Follow up:
		Recursive solution is trivial, could you do it iteratively?
		
	Reference:
		https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
		Algorithm Inorder(tree)
		   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
		   2. Visit the root.
		   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
	**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
*/
import java.util.*;

public class BinaryTreeInorderTraversal_LC094 {
	public static void main(String[] args) {
		BinaryTreeInorderTraversal_LC094 btit = new BinaryTreeInorderTraversal_LC094();
		
		// example 1 input: {1,null,2,3}
		TreeNode t1 = new TreeNode(1);
		t1.right = new TreeNode(2);
		t1.right.left = new TreeNode(3);
		System.out.print("Example 1 output: ");
		for (int i: btit.inorderTraversal(t1))
			System.out.print(i + " ");
		
		TreeNode t2 = new TreeNode();
		System.out.print("\nExample 2 output: ");
		for (int i: btit.inorderTraversal(t2))
			System.out.print(i + " ");
		
		TreeNode t3 = new TreeNode(1);
		System.out.print("\nExample 3 output: ");
		for (int i: btit.inorderTraversal(t3))
			System.out.print(i + " ");
		
		TreeNode t4 = new TreeNode(1);
		t4.left = new TreeNode(2);
		System.out.print("\nExample 4 output: ");
		for (int i: btit.inorderTraversal(t4))
			System.out.print(i + " ");
		
		TreeNode t5 = new TreeNode(1);
		t5.right = new TreeNode(2);
		System.out.print("\nExample 5 output: ");
		for (int i: btit.inorderTraversal(t5))
			System.out.print(i + " ");
	}
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
		
		inorder(treeList, root);
		
		
		return treeList;
    }
	protected void inorder(List<Integer> list, TreeNode node) {
		if (node == null)
			return;
		inorder(list, node.left);
		list.add(node.val);
		inorder(list, node.right);
	}
	
}
//Definition for a binary tree node.
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