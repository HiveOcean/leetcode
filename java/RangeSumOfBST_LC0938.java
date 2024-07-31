/* 
	https://leetcode.com/problems/range-sum-of-bst/
	938. Range Sum of BST
	
	Given the root node of a binary search tree and two integers low 
	and high, return the sum of values of all nodes with a value in 
	the inclusive range [low, high].

 

	Example 1:
				(10)		
			  /		\	
			(5)		(15)	
		   /   \	   \	
		 (3)   (7)	   (18)

		Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
		Output: 32
		Explanation: Nodes 7, 10, and 15 are in the 
					range [7, 15]. 7 + 10 + 15 = 32.
		
	Example 2:
				(10)		
			  /		\	
			(5)		 (15)	
		   /   \	 /  \	
		 (3)   (7) (13)	(18)
		 /	   /
	   (1)	 (6)

		Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
		Output: 23
		Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 
					6 + 7 + 10 = 23.
		 
	Constraints:
		The number of nodes in the tree is in the range [1, 2 * 10^4].
		1 <= Node.val <= 10^5
		1 <= low <= high <= 10^5
		All Node.val are unique.

// method 2:
public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);
        if(root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);      
    }
public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val <= L) return rangeSumBST(root.right, L, R) + (root.val == L ? root.val : 0);
        if (root.val >= R) return rangeSumBST(root.left, L, R) + (root.val == R ? root.val : 0);
        return rangeSumBST(root.left, L, R) + root.val + rangeSumBST(root.right, L, R);
    }
*/

import java.util.*;

public class RangeSumOfBST_LC0938 {
	// Method 1: iterative 
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
		int sum = 0;
		
		while (root != null || !stack.isEmpty()) {
			while (root!= null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			
			if (root.val >= low && root.val <= high)
				sum += root.val;
			
			root = root.right;
		}
		return sum;
    }
	public static void main(String[] args) {
		RangeSumOfBST_LC0938 getSum = new RangeSumOfBST_LC0938();
		
		TreeNode t1 = new TreeNode(10);
		t1.left = new TreeNode(5);
		t1.right = new TreeNode(15);
		t1.left.left = new TreeNode(3);
		t1.left.right = new TreeNode(7);
		t1.right.right = new TreeNode(18);
		int low1 = 7, high1 = 15;
		System.out.println("Tree 1 sum between " + low1 + " and " + high1 +
				" is " + getSum.rangeSumBST(t1, low1, high1));
		
		TreeNode t2 = new TreeNode(10);
		t2.left = new TreeNode(5);
		t2.right = new TreeNode(15);
		t2.left.left = new TreeNode(3);
		t2.left.right = new TreeNode(7);
		t2.left.right.left = new TreeNode(6);
		t2.left.left.left = new TreeNode(1);
		t2.right.right = new TreeNode(18);
		t2.right.left = new TreeNode(13);
		int low2 = 6, high2 = 10;
		System.out.println("Tree 2 sum between " + low2 + " and " + high2 +
				" is " + getSum.rangeSumBST(t2, low2, high2));
	
	}
}
