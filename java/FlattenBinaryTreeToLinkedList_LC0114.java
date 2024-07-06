/*
	https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	114. Flatten Binary Tree to Linked List
	
	Given the root of a binary tree, flatten the tree into a "linked list":

	The "linked list" should use the same TreeNode class where the right 
	child pointer points to the next node in the list and the left child 
	pointer is always null.
	The "linked list" should be in the same order as a pre-order 
	traversal of the binary tree.
		 

	Example 1:
					(1)				  (1)
				  /		\				\
				(2)		(5)     ==>		(2)
			   /   \	   \			  \
			 (3)   (4)     (6)			  (3)
											\
											(4)
											  \
											  (5)
												\
												(6)
												
		Input: root = [1,2,5,3,4,null,6]
		Output: [1,null,2,null,3,null,4,null,5,null,6]
		
	Example 2:

		Input: root = []
		Output: []
		
	Example 3:

		Input: root = [0]
		Output: [0]
		 

	Constraints:
		The number of nodes in the tree is in the range [0, 2000].
		-100 <= Node.val <= 100

		Follow up: Can you flatten the tree in-place (with O(1) extra space)?

	Related topics:
		Linked List, Stack, Tree, Depth-First Search


*/
import java.util.*;

public class FlattenBinaryTreeToLinkedList_LC0114 {
	// Method: 1 use PreOrder Traversal and use a prev treenode to mark
	// the previous node.
    public void flatten(TreeNode root) {

		if (root == null) return;
		
        Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				stack.push(node.right);
				stack.push(node.left);
			
				if (prev == null) {
					prev = node;
				} else {
					prev.right = node;
					prev = node;
				}
				prev.left = null;
				//System.out.print(prev.val + " ** ");
			}
		}
    }
	// Method 2: solution from leetcode discussion.
	private TreeNode prev = null;
	public void flatten2(TreeNode root) {
		if (root == null)
			return;
		flatten2(root.right);
		flatten2(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
	private void printTreeBFS (TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty() ) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList_LC0114 flattenTree = new FlattenBinaryTreeToLinkedList_LC0114();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.left.right = new TreeNode(4);
		t1.right = new TreeNode(5);
		t1.right.right = new TreeNode(6);
		
		flattenTree.printTreeBFS(t1);
		
		flattenTree.flatten(t1);
		flattenTree.printTreeBFS(t1);
		
		TreeNode t2 = new TreeNode();
		flattenTree.flatten(t2);
		flattenTree.printTreeBFS(t2);
		
		TreeNode t3 = new TreeNode(1);
		flattenTree.flatten(t3);
		flattenTree.printTreeBFS(t3);
	}
}
