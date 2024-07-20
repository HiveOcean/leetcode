/*
	https://leetcode.com/problems/minimum-absolute-difference-in-bst/
	530. Minimum Absolute Difference in BST
	
	Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

	Example 1:
					 (4)
				   /     \
				 (2)	 (6)
			    /   \
			  (1)   (3)

		Input: root = [4,2,6,1,3]
		Output: 1
		
	Example 2:
					 (1)
				   /     \
				 (0)	 (48)
						/   \
					  (12)   (49)

		Input: root = [1,0,48,null,null,12,49]
		Output: 1

	Example 3:
					 (10)
				   /     \
				 (0)	 (48)
						/   \
					  (12)   (56)	

	Constraints:

		The number of nodes in the tree is in the range [2, 10^4].
		0 <= Node.val <= 10^5

*/
import java.util.*;

public class MinimumAbsoluteDifferenceInBST_LC0530 {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
		
		if (root == null) return 0;
		
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		// inorder traversal to create a ascending order list	
		while (root != null || !stack.empty()) {
			while (root != null ) {	
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		System.out.println("Tree: " + list.toString());
		
		for (int i = 1; i < list.size(); i++) {
			if ( list.get(i) - list.get(i-1) < min)
				min = list.get(i) - list.get(i-1);
		}
		return min;
    }
	// Method 2: recursive
	public int getMinimumDifference2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		int[] min = {Integer.MAX_VALUE};
		inorder(root, list, min);
		return min[0];
	}
	private void inorder(TreeNode node, List<Integer> list, int[] min) {
		if (node != null) {
			inorder(node.left, list, min);
			list.add(node.val);
			if (list.size() > 1) {
				if (min[0] > list.get(list.size() - 1) - list.get(list.size() -2))
					min[0] = list.get(list.size() - 1) - list.get(list.size() -2);
			}
			inorder(node.right, list, min);
		}
	}

	public static void main(String[] args) {
		MinimumAbsoluteDifferenceInBST_LC0530 findMinDiff = new MinimumAbsoluteDifferenceInBST_LC0530();
		
		TreeNode t1 = new TreeNode(4);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(6);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(3);
		System.out.println("Tree 1: " + findMinDiff.getMinimumDifference(t1));
		System.out.println("Tree 1: " + findMinDiff.getMinimumDifference2(t1));
		
		TreeNode t2 = new TreeNode(5);
		t2.left = new TreeNode(0);
		t2.right = new TreeNode(48);
		t2.right.left = new TreeNode(12);
		t2.right.right = new TreeNode(56);
		System.out.println("Tree 2: " + findMinDiff.getMinimumDifference(t2));
		System.out.println("Tree 2: " + findMinDiff.getMinimumDifference2(t2));
		
		TreeNode t3 = new TreeNode(10);
		t3.left = new TreeNode(0);
		t3.right = new TreeNode(48);
		t3.right.left = new TreeNode(12);
		t3.right.right = new TreeNode(56);
		System.out.println("Tree 3: " + findMinDiff.getMinimumDifference(t3));
		System.out.println("Tree 3: " + findMinDiff.getMinimumDifference2(t3));
		
		
		
		TreeNode t4 = new TreeNode(50);
		t4.right = new TreeNode(60);
		t4.left = new TreeNode(30);
		t4.left.left = new TreeNode(11);
		t4.left.right = new TreeNode(45);
		t4.left.left.right = new TreeNode(29);
		
		System.out.println("Tree 4: " + findMinDiff.getMinimumDifference(t4));
		System.out.println("Tree 4: " + findMinDiff.getMinimumDifference2(t4));
	}
}