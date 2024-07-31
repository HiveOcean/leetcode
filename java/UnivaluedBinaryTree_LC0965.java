/*
	https://leetcode.com/problems/univalued-binary-tree/
	965. Univalued Binary Tree
	
	A binary tree is uni-valued if every node in the tree has the 
	same value.

	Given the root of a binary tree, return true if the given tree 
	is uni-valued, or false otherwise.

 

	Example 1:
				(1)		
			  /		\	
			(1)		(1)	
		   /   \	   \	
		 (1)   (1)	   (1)

		Input: root = [1,1,1,1,1,null,1]
		Output: true
		
	Example 2:
				(2)		
			  /		\	
			(2)		(2)	
		   /   \	  	
		 (5)   (2)	   

		Input: root = [2,2,2,5,2]
		Output: false
		 

	Constraints:
		The number of nodes in the tree is in the range [1, 100].
		0 <= Node.val < 100

*/
import java.util.*;

public class UnivaluedBinaryTree_LC0965 {
	// use DFS inorder traversal with iterative.
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
		int unival = root.val;
		
		while (root!= null || !stack.isEmpty()) {
			while (root!= null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.val != unival)
				return false;
			root = root.right;
		}
		return true;
    }
	// use DFS inorder traversal recursive (from solution)
	public boolean isUnivalTree(TreeNode root) {
		
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}
	
	public static void main(String[] args) {
		UnivaluedBinaryTree_LC0965 univalTree = new UnivaluedBinaryTree_LC0965();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(1);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(1);
		t1.right = new TreeNode(1);
		t1.right.right  = new TreeNode(1);
		System.out.println("Tree 1 is unival? " + univalTree.isUnivalTree(t1));
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(2);
		t2.left.left = new TreeNode(5);
		t2.left.right = new TreeNode(2);
		t2.right = new TreeNode(2);
		System.out.println("Tree 2 is unival? " + univalTree.isUnivalTree(t2));
	}
}




