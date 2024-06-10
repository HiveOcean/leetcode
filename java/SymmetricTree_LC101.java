/*
	https://leetcode.com/problems/symmetric-tree/
	Symmetric Tree - LeetCode #101 
	
	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around 
	its center).

	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

			1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		 

		But the following [1,2,2,null,3,null,3] is not:

			1
		   / \
		  2   2
		   \   \
		   3    3
		 

	Follow up: Solve it both recursively and iteratively.
	
	public class TreeNode {
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
	
	https://www.educative.io/edpresso/how-to-check-for-a-symmetric-binary-tree-recursive-approach
	
	The following steps are involved in the recursive approach:

		1. If the tree is empty, then it is symmetrical to the vertical axis going 
		   through its root node.
		2. Else, check if the value at the root node of both subtrees is the same.
		3. If it is, then check if the left subtree and the right subtree are 
		   symmetrical.
		4. This can be done by checking if:
			4.1 The root nodes of both trees contain the same value.
			4.2 The left subtree of the left subtree and the right subtree of the 
			    right subtree are symmetrical.
			4.3 The right subtree of the left subtree and the left subtree of the 
			    right subtree are symmetrical.
*/
import java.util.*;
public class SymmetricTree_LC101 {
	public static void main(String[] args) {
		int[] data1 = {1,2,2,3,4,4,3};
		TreeNode t1root = new TreeNode(1);
		t1root.left = new TreeNode(2);
		t1root.left.left = new TreeNode(3);
		t1root.left.right = new TreeNode(4);
		t1root.right = new TreeNode(2);
		t1root.right.left = new TreeNode(4);
		t1root.right.right = new TreeNode(3);
		
		//int[] data2 = {1,2,2,null,3,null,3};
		int[] data2 = {1,2,2,3,3};
		TreeNode t2root = new TreeNode(1);
		t2root.left = new TreeNode(2);
		t2root.left.right = new TreeNode(3);
		t2root.right = new TreeNode(2);
		t2root.right.right = new TreeNode(3);
		
		System.out.print("\nTree [ ");
		for (int i: data1)
			System.out.print(i + " ");
		System.out.print("] is a binary symetric tree: " + isSymmetric(t1root));
	
		System.out.print("\nTree [ ");
		for (int j: data2)
			System.out.print(j + " ");
		System.out.print("] is a binary symetric tree: " + isSymmetric(t2root));
		
		System.out.println("\nMethod 2: ");
		System.out.println("tree 1 " + isSymmetric2(t1root));
		System.out.println("tree 2 " + isSymmetric2(t2root));
	}
	// Method 1: recursive
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
	/*
		The following steps are involved in the recursive approach:
		1. If the tree is empty, then it is symmetrical to the vertical axis going 
		   through its root node.
		2. Else, check if the value at the root node of both subtrees is the same.
		3. If it is, then check if the left subtree and the right subtree are 
		   symmetrical.
		4. This can be done by checking if:
			4.1 The root nodes of both trees contain the same value.
			4.2 The left subtree of the left subtree and the right subtree of the 
			    right subtree are symmetrical.
			4.3 The right subtree of the left subtree and the left subtree of the 
			    right subtree are symmetrical.
	*/
	public static boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		
		if (node1 != null && node2 != null && node1.val == node2.val  ) {
			return ( isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
		}
		
		return false;
	}
	
	// Method 2: iteratively
	public static boolean isSymmetric2(TreeNode root) {
		
		if (root == null) return true;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
	
		while (!stack.empty()) {
			TreeNode n1 = stack.pop();
			TreeNode n2 = stack.pop();
			if (n1 == null && n2 == null)
				continue;
			
			if (n1 == null || n2 == null)
				return false;
			
			if (n1.val != n2.val) {
				return false;
			}
			
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
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