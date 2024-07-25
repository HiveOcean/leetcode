/*
	https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
	653. Two Sum IV - Input is a BST
	
	Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

		Example 1:


		Input: root = [5,3,6,2,4,null,7], k = 9
		Output: true
		Example 2:


		Input: root = [5,3,6,2,4,null,7], k = 28
		Output: false
		Example 3:

		Input: root = [2,1,3], k = 4
		Output: true
		Example 4:

		Input: root = [2,1,3], k = 1
		Output: false
		Example 5:

		Input: root = [2,1,3], k = 3
		Output: true
		 

	Constraints:

		The number of nodes in the tree is in the range [1, 10^4].
		-10^4 <= Node.val <= 10^4
		root is guaranteed to be a valid binary search tree.
		-10^5 <= k <= 10^5
	
*/

import java.util.*;

public class TwoSumIV_LC0653 {
	// Method 1: use hashset
	public boolean findTarget1(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
		HashSet<Integer> hs = new HashSet<>();
		
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int value = k - node.val;
			if (hs.contains(value))
				return true;
			hs.add(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return false;
		
    }
	// Method 2: inorder traversal + two pointers
	public boolean findTarget2(TreeNode root, int k) {
		List<Integer> array = new ArrayList<>();
		
		inorder(root, array);
		int left = 0, right = array.size() - 1;
		while (left < right) {
			if ( array.get(left) + array.get(right) == k)
				return true;
			if (array.get(left) + array.get(right) > k )
				right--;
			if (array.get(left) + array.get(right) < k)
				left++;
		}
		return false;
	}
	private void inorder(TreeNode node, List<Integer> array) {
		if (node != null) {
			inorder(node.left, array);
			array.add(node.val);
			inorder(node.right, array);
		}
	}
	public static void main(String[] args) {
		TwoSumIV_LC0653 findtwosum = new TwoSumIV_LC0653();
		
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(2);
		t1.left.right = new TreeNode(4);
		t1.right = new TreeNode(6);
		t1.right.right = new TreeNode(7);
		System.out.println("Tree 1 two sum: " + findtwosum.findTarget1(t1,9));
		System.out.println("Tree 1 two sum: " + findtwosum.findTarget2(t1,9));
		
		TreeNode t2 = new TreeNode(5);
		t2.left = new TreeNode(3);
		t2.left.left = new TreeNode(2);
		t2.left.right = new TreeNode(4);
		t2.right = new TreeNode(6);
		t2.right.right = new TreeNode(7);
		System.out.println("Tree 2 two sum: " + findtwosum.findTarget1(t2,14));
		System.out.println("Tree 2 two sum: " + findtwosum.findTarget2(t2,14));
		
		TreeNode t3 = new TreeNode(2);
		t3.left = new TreeNode(1);
		t3.right = new TreeNode(3);
		System.out.println("Tree 3 two sum: " + findtwosum.findTarget1(t3,4));
		System.out.println("Tree 3 two sum: " + findtwosum.findTarget2(t3,4));
		
		TreeNode t4 = new TreeNode(2);
		t4.left = new TreeNode(1);
		t4.right = new TreeNode(3);
		System.out.println("Tree 4 two sum: " + findtwosum.findTarget1(t4,1));
		System.out.println("Tree 4 two sum: " + findtwosum.findTarget2(t4,1));
		
		TreeNode t5 = new TreeNode(2);
		t5.left = new TreeNode(1);
		t5.right = new TreeNode(3);
		System.out.println("Tree 5 two sum: " + findtwosum.findTarget1(t5,3));
		System.out.println("Tree 5 two sum: " + findtwosum.findTarget2(t5,3));
	}
}