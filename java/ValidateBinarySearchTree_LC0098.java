/*
	https://leetcode.com/problems/validate-binary-search-tree/
	98. Validate Binary Tree (medium)
	
	Given the root of a binary tree, determine if it is a valid binary search 
	tree (BST).

	A valid BST is defined as follows:

		- The left subtree of a node contains only nodes with keys less than 
		  the node's key.
		- The right subtree of a node contains only nodes with keys greater 
		  than the node's key.
		- Both the left and right subtrees must also be binary search trees.
 

	Example 1:
						(2)
					  /     \
					(1)	    (3)
					
		Input: root = [2,1,3]
		Output: true
		
	Example 2:
						(5)
					  /     \
					(1)	    (4)
						   /    \
						 (3)    (6)
							  
	
		Input: root = [5,1,4,null,null,3,6]
		Output: false
		Explanation: The root node's value is 5 but its right child's value is 4.
		 
	Constraints:
		The number of nodes in the tree is in the range [1, 104].
		-2^31 <= Node.val <= 2^31 - 1
		
	Solution:
	Method 1:
		1) Don't just only check if left-node < root, and right-node > root	
						(3)
					 / 		 \
				   (2)      (5)			4 is left subtree of 3, it's > 2 it's parent node
				 /    \			        but > root node 3.  This is not BST because 4 is
			   (1)    (4)				in left subtree of 3.
		
		2) Should check the left subtree's max value is less than root
		   and right subtree's min value is larger than root.
	Time Complexity: O(n)
	
	Method 2:
	If it is an valid BST, In-order travesal will return it in acsending order!
	
	1) Do In-Order Traversal of the given tree and store the result in a temp array. 
	2) This method assumes that there are no duplicate values in the tree
	3) Check if the temp array is sorted in ascending order, if it is, then the tree 
	   is BST.
	Time Complexity: O(n)
	We can avoid the use of a Auxiliary Array. While doing In-Order traversal, we 
	can keep track of previously visited node. If the value of the currently visited 
	node is less than the previous value, then tree is not BST. 

*/
import java.util.*;

public class ValidateBinarySearchTree_LC0098 {
    public boolean isValidBST1(TreeNode root) {
        return (isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
	private boolean isBSTUtil(TreeNode node, Long min, Long max) {
		// an empty subtree is BST 
		if (node == null)
			return true;
		
		/* false if this node violates the min/max constraints */
		if (node.val < min || node.val > max)
			return false;
		
		return (isBSTUtil(node.left, min, Long.valueOf(node.val - 1) ) &&
			    isBSTUtil(node.right, Long.valueOf(node.val + 1), max ));
		
		
	}
	public boolean isValidBST2(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		
		if (node == null) 
			return true;
		
		while ( node != null || !stack.isEmpty() ) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			// each pop from the stack will be in the inorder traversal 
			node = stack.pop();
			if (pre != null && pre.val > node.val)
				return false;
			
			pre = node;
			node = node.right;	
		}
		return true;
	}
	public static void main(String[] args) {
		ValidateBinarySearchTree_LC0098 validBST = new ValidateBinarySearchTree_LC0098();
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
		
		System.out.println("Test case tree 1: " + validBST.isValidBST1(root1));
		
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(5);
		root2.left.left = new TreeNode(1);
		root2.left.right = new TreeNode(4);
		System.out.println("Test case tree 2: " + validBST.isValidBST1(root2));
		
		System.out.println("Method 2: using stack");
		System.out.println("Test case tree 1: " + validBST.isValidBST2(root1));
		System.out.println("Test case tree 2: " + validBST.isValidBST2(root2));
	}
}
