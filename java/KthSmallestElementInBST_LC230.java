/*
	https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	Kth Smallest Element in a BST - LeetCode #230
	
	Given a binary search tree, write a function kthSmallest to find the kth 
	smallest element in it.

	Example 1:
		Input: root = [3,1,4,null,2], k = 1

		Output: 1

	Example 2:
		Input: root = [5,3,6,2,4,null,null,1], k = 3
		
		Output: 3

	Follow up:
		What if the BST is modified (insert/delete operations) often and you 
		need to find the kth smallest frequently? How would you optimize the 
		kthSmallest routine?
 
	Constraints:
		* The number of elements of the BST is between 1 to 10^4.
		* You may assume k is always valid, 1 ≤ k ≤ BST's total elements.	

	Solution reference:
	https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
	
*/

import java.util.*;

public class KthSmallestElementInBST_LC230 {
	
	public static void main(String[] args) {
		KthSmallestElementInBST_LC230 k_smallest = new KthSmallestElementInBST_LC230();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(1);
		t1.right = new TreeNode(4);
		t1.left.right = new TreeNode(2);
		
		TreeNode t2 = new TreeNode(5);
		t2.left = new TreeNode(3);
		t2.right = new TreeNode(6);
		t2.left.left = new TreeNode(2);
		t2.left.right = new TreeNode(4);
		t2.left.left.left = new TreeNode(1);
		
		TreeNode t3 = new TreeNode(4);
		t3.left = new TreeNode(3);
		t3.left.left = new TreeNode(2);
		t3.left.left.left = new TreeNode(1);
		t3.right = new TreeNode(8);
		t3.right.left = new TreeNode(7);
		t3.right.right = new TreeNode(11);
		t3.right.right.right = new TreeNode(13);
		t3.right.right.right.right = new TreeNode(15);
		
		TreeNode t4 = new TreeNode(20);
		t4.left = new TreeNode(8);
		t4.right = new TreeNode(22);
		t4.left.left = new TreeNode(4);
		t4.left.right = new TreeNode(12);
		t4.left.right.left = new TreeNode(10);
		t4.left.right.right = new TreeNode(14);
		
		TreeNode[] trees = {t1, t2, t3, t4};
		int[] kth = {1,3,5,5};	// ans = 1, 3, 7, 14
		
		for (int i = 0; i < trees.length; i++ ) {
			System.out.println(kth[i] + "th smallest element is: " 
				+ k_smallest.kthSmallest(trees[i], kth[i]));
		}
	}
    public int kthSmallest(TreeNode root, int k) {	
		//if (root == null ) return 0;
			
		// in-order traversal: left, root, right
		int[] array = {k,0};  // to hold the counter to kth smallest and the kth smallest value
			
		// alternative use an arraylist to hold all the in-order node
		ArrayList<Integer> arr = new ArrayList<>();
		
		inOrder(root, array, arr);
		
		 return arr.get(k - 1);
		//return array[1];
    }
	private void inOrder(TreeNode node, int[] array, ArrayList<Integer> arr ) {
		if ( node == null) {
			return ;
		}
		inOrder(node.left, array, arr);
		arr.add(node.val);
		//System.out.print( node.val + " ");
		if (--array[0] == 0) {
			//System.out.println("THis is the k smallest: " + node.val);
			array[1] = node.val;
		}
		inOrder(node.right, array, arr);	
	
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