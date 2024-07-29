/*
	https://leetcode.com/problems/increasing-order-search-tree/
	897. Increasing Order Search Tree
	
	Given the root of a binary search tree, rearrange the tree in 
	in-order so that the leftmost node in the tree is now the root 
	of the tree, and every node has no left child and only one right 
	child.

	Example 1:
				(5)					  (1)
			  /		\					\
			(3)		(6)					(2)
		   /   \	   \				  \
		 (2)   (4)	   (8)				  (3)
		 /			   / \					\
	   (1)			 (7) (9)				(4)
											  \
											  (5)
											    \
											    (6)
												  \
												  (7)
													\
													(8)
													  \
													  (9)

		Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
		Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
		
	Example 2:
				(5)					  (1)
			  /		\					\
			(1)		(7)					(5)
										  \
										  (7)

		Input: root = [5,1,7]
		Output: [1,null,5,null,7]
		 

	Constraints:
		The number of nodes in the given tree will be in the range [1, 100].
		0 <= Node.val <= 1000


*/
import java.util.*;

public class IncreasingOrderSearchTree_LC0897 {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
		TreeNode tree = null, prev = null;
		
		while ( root != null || !stack.isEmpty() ) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (tree == null) {
				tree = new TreeNode(root.val);
				prev = tree;
			} else {
				prev.right = new TreeNode(root.val);
				prev = prev.right;
			}
			root = root.right;
		}
		return tree;
    }
	private void printTree(TreeNode node) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		
		queue.add(node);
		while (!queue.isEmpty()) {
			
			TreeNode n = queue.poll();	
			System.out.print(n.val + " ");
			
			if (n.left != null) 
				queue.add(n.left);				
			if (n.right != null)
				queue.add(n.right);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		IncreasingOrderSearchTree_LC0897 increasingTree = new IncreasingOrderSearchTree_LC0897();

		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(2);
		t1.left.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(4);
		t1.right = new TreeNode(6);
		t1.right.right = new TreeNode(8);
		t1.right.right.left = new TreeNode(7);
		t1.right.right.right = new TreeNode(9);
		
		//increasingTree.printTree(t1);		
		TreeNode inorderTree1 = increasingTree.increasingBST(t1);
		increasingTree.printTree(inorderTree1);
		
		TreeNode t2 = new TreeNode(5);
		t2.left = new TreeNode(1);
		t2.right =new TreeNode(7);
		TreeNode inorderTree2 = increasingTree.increasingBST(t2);
		increasingTree.printTree(inorderTree2);
		
	}
}