/*
	https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	Convert Sorted Array to Binary Search Tree - LeetCode #108
	
	Given an array where elements are sorted in ascending order, convert it to 
	a height balanced BST.

	For this problem, a height-balanced binary tree is defined as a binary tree 
	in which the depth of the two subtrees of every node never differ by more 
	than 1.

	Example:
		Given the sorted array: [-10,-3,0,5,9],

		One possible answer is: [0,-3,9,-10,null,5], which represents the following 
								height balanced BST:

			  0
			 / \
		   -3   9
		   /   /
		 -10  5


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
 
	Reference:
	https://www.youtube.com/watch?v=12omz-VAyRk by Nick White
	Use binary search idea, that is the root should be the middle of the sorted array
	  0   1  2 3 4 5 6	// indices
	[-10,-5,-3,0,5,8,9]	// left + (right - left) / 2  to find the middle index
						//  0   + ( 6 - 0 ) / 2 = 3  (the mddile index)
						
				0
			   / \
		   -5   	8
		   / \  	/ \
		 -10  -3	5	9	
*/

public class SortedArrayToBST_LC108 {
	public static void main(String[] args) {
		int[] nums1 = {-10,-3,0,5,9};
		int[] nums2 = {-3, -2, -1, 0, 5, 10, 15};
		int[] nums3 = {-10,-5,-3,0,5,8,9};
		
		TreeNode root1 = sortedArrayToBST(nums1);
		System.out.println(root1.val + " " + root1.left.val + " " + root1.right.val);
		TreeNode root2 = sortedArrayToBST(nums2);
		System.out.println(root2.val + " " + root2.left.val + " " + root2.right.val);
		TreeNode root3 = sortedArrayToBST(nums3);
		System.out.println(root3.val + " " + root3.left.val + " " + root3.right.val);
	}
    public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) return null;
		
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }
	public static TreeNode constructTreeFromArray(int[] nums, int left, int right) {
		if (left > right) return null;
		
		int midpoint = left + (right - left) /2;
		TreeNode node = new TreeNode(nums[midpoint]);
		node.left = constructTreeFromArray(nums, left, midpoint - 1);
		node.right = constructTreeFromArray(nums,  midpoint + 1, right);
		
		return node;
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