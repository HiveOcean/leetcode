/*
	https://leetcode.com/problems/minimum-distance-between-bst-nodes/
	783. Minimum Distance Between BST Nodes
	
	Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
	
	Example 1:
				 (4)
			   /     \		
			 (2)     (6)	
			/	\
		  (1)	(3)
		  
		Input: root = [4,2,6,1,3]
		Output: 1
	
	Example 2:
				 (1)
			   /     \		
			 (0)     (48)	
					 /	\
				  (12)  (49)

		Input: root = [1,0,48,null,null,12,49]
		Output: 1
	 

	Constraints:
		The number of nodes in the tree is in the range [2, 100].
		0 <= Node.val <= 10^5
	
	Related topics:
		Tree, Depth-First Search, Breadth-First Search, Binary Search Tree,
		Binary Tree.
	
*/
import java.util.*;

public class MinimumDistanceBetweenBSTNodes_LC0783 {
	// 1. put the tree in inorder traversal in an array
	// 2. the array should be in ascending order
	// 3. Go through the array to make compare to array[i-1] and array[i]
	//    where i starts from index 1.
    public int minDiffInBST(TreeNode root) {
		List<Integer> ascdlist = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		if (root == null) return -1;
		
		// put the tree in array with inorder traversal
		while (root != null || !stack.isEmpty()) {
			while (root != null ) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			ascdlist.add(root.val);
			root = root.right;
		}
		//System.out.println(ascdlist);
		// Go through the array to find the minimum difference
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < ascdlist.size(); i++) {
			min = Math.min(min, Math.abs(ascdlist.get(i) - ascdlist.get(i - 1)));
		}
        return min;
    }
	public static void main(String[] args) {
		MinimumDistanceBetweenBSTNodes_LC0783 minDiff = new MinimumDistanceBetweenBSTNodes_LC0783();
		
		TreeNode t1 = new TreeNode(4);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(6);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(3);
		System.out.println("Tree 1 min diff: " + minDiff.minDiffInBST(t1));
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(0);
		t2.right = new TreeNode(48);
		t2.right.left = new TreeNode(12);
		t2.right.right = new TreeNode(49);
		System.out.println("Tree 2 min diff: " + minDiff.minDiffInBST(t2));
	}
}