/*
	https://leetcode.com/problems/binary-tree-preorder-traversal/
	144. Binary Tree Preorder Traversal
	
	Given the root of a binary tree, return the preorder traversal of its nodes' values.
	
	Example 1:
					(1)
						\
					    (2)
						/
					  (3)

		Input: root = [1,null,2,3]
		Output: [1,2,3]
	
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
		Output: [1,2]
	
	Example 5:
					(1)
						\
					    (2)

		Input: root = [1,null,2]
		Output: [1,2]
	 

	Constraints:
		The number of nodes in the tree is in the range [0, 100].
		-100 <= Node.val <= 100

	Follow up: Recursive solution is trivial, could you do it iteratively?

	Related topics:
	Stack, Tree, Depth-First Search, Binary Tree

	Method 1: recursive
	Method 2: iteratively
*/
import java.util.*;

public class BinaryTreePreOrderTraversal_LC0144 {
	// Method 1: recursive
    public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		
		preorderUtil(root, ans);
		return ans;
    }
	private void preorderUtil(TreeNode node, List<Integer> ans) {
		if (node != null) {
			ans.add(node.val);
			preorderUtil(node.left, ans);
			preorderUtil(node.right, ans);
		}
	}
	// Method 2: iteratively
    public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				ans.add(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		return ans;
		/*  alternative
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				ans.add(node.val);
				stack.push(node.right);
				node = node.left;
			} else {
				node = stack.pop();
			}
		}
		return ans
		*/
    }
	public static void main(String[] args) {
		BinaryTreePreOrderTraversal_LC0144 preOrder = new BinaryTreePreOrderTraversal_LC0144();
		
		TreeNode t1 = new TreeNode(1);
		t1.right = new TreeNode(2);
		t1.right.left = new TreeNode(3);
		System.out.print("\nTree 1 preorder: " + preOrder.preorderTraversal1(t1).toString());
		System.out.print("\nTree 1 preorder: " + preOrder.preorderTraversal2(t1).toString());
		
		TreeNode t2 = null;
		System.out.print("\nTree 2 preorder: " + preOrder.preorderTraversal1(t2).toString());
		System.out.print("\nTree 2 preorder: " + preOrder.preorderTraversal2(t2).toString());
		
		TreeNode t3 = new TreeNode(1);
		System.out.print("\nTree 3 preorder: " + preOrder.preorderTraversal1(t3).toString());
		System.out.print("\nTree 3 preorder: " + preOrder.preorderTraversal2(t3).toString());
		
		TreeNode t4 = new TreeNode(1);
		t4.left = new TreeNode(2);
		System.out.print("\nTree 4 preorder: " + preOrder.preorderTraversal1(t4).toString());
		System.out.print("\nTree 4 preorder: " + preOrder.preorderTraversal2(t4).toString());
		
		TreeNode t5 = new TreeNode(1);
		t5.right = new TreeNode(2);
		System.out.print("\nTree 5 preorder: " + preOrder.preorderTraversal1(t5).toString());
		System.out.print("\nTree 5 preorder: " + preOrder.preorderTraversal2(t5).toString());
	
		TreeNode t6 = new TreeNode(1);
		t6.left = new TreeNode(2);
		t6.right = new TreeNode(3);
		t6.left.left = new TreeNode(4);
		t6.left.left.left = new TreeNode(5);
		t6.right.left = new TreeNode(7);
		t6.right.left.right = new TreeNode(8);
		System.out.print("\nTree 6 preorder: " + preOrder.preorderTraversal1(t6).toString());
		System.out.print("\nTree 6 preorder: " + preOrder.preorderTraversal2(t6).toString());
	}
}