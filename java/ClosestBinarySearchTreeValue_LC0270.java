/*
	https://leetcode.com/problems/closest-binary-search-tree-value/
	https://goodtecher.com/leetcode-270-closest-binary-search-tree-value/
	270. Closest Binary Search Tree Value
	
	Given the root of a binary search tree and a target value, return the 
	value in the BST that is closest to the target.

	Example 1:
						(4)
					  /		\
					(2)	    (5)
				  /    \
				(1)	   (3)
					
		Input: root = [4,2,5,1,3], target = 3.714286
		Output: 4
		
	Example 2:

		Input: root = [1], target = 4.428571
		Output: 1
		
	Constraints:
		The number of nodes in the tree is in the range [1, 10^4].
		0 <= Node.val <= 10^9
		-10^9 <= target <= 10^9
		
	Explanation
		Base on the characteristics of binary search tree to search for the 
		target.

*/
import java.util.*;

public class ClosestBinarySearchTreeValue_LC0270 {
	int value;
	double gap = Double.MAX_VALUE;
	
	// Method 1 recursive (need helper function and global variables)
	public int closestValue(TreeNode root, double target) {
		value = root.val;
		searchBST(root, target);
		return value;
	}
	private void searchBST(TreeNode node, double target) {
		if (node == null)
			return;
		
		double differences = Math.abs(node.val - target);
		if (differences < gap) {
			value = node.val;
			gap = differences;
		}
		if (node.val > target) {
			searchBST(node.left, target);
			
		} else
			searchBST(node.right, target);
		
	}
	// Method 2: iterative
	public int closestValue2(TreeNode root, double target) {
		int value = root.val;
		double gap = Double.MAX_VALUE;
		
		TreeNode node;
		if (target > root.val)
			node = root.right;
		else
			node = root.left;
		
		gap = Math.min(gap,Math.abs(root.val - target));
		
		while (node!= null) {
			double differences = Math.abs(node.val - target);
			if (differences < gap) {
				value = node.val;
				gap = differences;
			}
			if (node.val > target) 
				node = node.left;
			else
				node = node.right;
		}
		
		return value;
	}
	public static void main(String[] args) {
		ClosestBinarySearchTreeValue_LC0270 findValue = new ClosestBinarySearchTreeValue_LC0270();
		
		TreeNode t1 = new TreeNode(4);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(5);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(3);
		double target1 = 3.714286;
		System.out.println(findValue.closestValue1(t1, target1));
		
		TreeNode t2 = new TreeNode(1);
		double target2 = 4.428571;
		System.out.println(findValue.closestValue1(t2, target2));
	}
}	
/*	
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
public class LC0270 {
	// Method 1: recursive
	int closestNodeValue;
	public int closestValue1(TreeNode root, Double target) {
		Double diff = Double.MAX_VALUE;
		findClosest(root, diff, target);
		
		return closestNodeValue;	
	}
	private void findClosest(TreeNode node, Double diff,  Double target) {
		
		if (node == null) return;
		
		if (diff > Math.abs(node.val - target)) {
			diff = (Math.abs(node.val - target));
			closestNodeValue = node.val;
		}
		if (node.left != null && target < node.val)
			findClosest(node.left, diff, target);
		
		if (node.right != null && target > node.val)
			findClosest(node.right, diff, target);
		
	}
	// Method 2: iterative using Stack
	public int closestValue2(TreeNode root, Double target) {
		int closeNodeVal = root.val;
		double diff = Double.MAX_VALUE;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			
			if (diff > Math.abs(node.val - target)) {
				diff = Math.abs(node.val - target);
				closeNodeVal = node.val;
			}
			if (node.left != null && target < node.val)
				stack.push(node.left);
			if (node.right != null && target > node.val)
				stack.push(node.right);
		}
		return closeNodeVal;	
	}
}
*/