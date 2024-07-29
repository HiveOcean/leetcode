/*
	https://leetcode.com/problems/leaf-similar-trees/
	872. Leaf-Similar Trees
	
	Consider all the leaves of a binary tree, from left to right order, 
	the values of those leaves form a leaf value sequence.

						  (3)
					   /        \		
					(5)         (1)	
					/ 	\	    /  \
				  (6)	(2)   (9)  (8)
				       /   \
					 (7)   (4)
		
	For example, in the given tree above, the leaf value sequence 
	is (6, 7, 4, 9, 8).

	Two binary trees are considered leaf-similar if their leaf value 
	sequence is the same.

	Return true if and only if the two given trees with head nodes 
	root1 and root2 are leaf-similar.

		 

	Example 1:

				(3)							(3)
			 /       \					 /       \	
		   (5)       (1)			   (5)       (1)
		  /   \	   	 /  \			  /   \	   	 /  \
		(6)	 (2)   (9)  (8)			(6)	 (7)   (4)  (2)
			/   \									/  \
		  (7)   (4)					  			  (9)  (8)

		Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], 
			   root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
		Output: true
		
	Example 2:

		Input: root1 = [1], root2 = [1]
		Output: true
		
	Example 3:

		Input: root1 = [1], root2 = [2]
		Output: false
		
	Example 4:

		Input: root1 = [1,2], root2 = [2,2]
		Output: true
		
	Example 5:

				(1)							(1)
			 /       \					 /       \	
		   (2)       (3)			   (3)       (2)

		Input: root1 = [1,2,3], root2 = [1,3,2]
		Output: false
		 

	Constraints:
		The number of nodes in each tree will be in the range [1, 200].
		Both of the given trees will have values in the range [0, 200].

	Related topics:
		Tree, Depth-First Search, Binary Tree
	
*/

import java.util.*;

public class LeafSimilarTrees_LC0872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();
		
		dfsPreorder(root1, leaves1);
		dfsPreorder(root2, leaves2);
		
		return (leaves1.equals(leaves2));
    }
	private void dfsPreorder(TreeNode node, List<Integer> leaves) {
		Stack<TreeNode> stack = new Stack<>();
		
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			if (node.left == null && node.right == null) {
				leaves.add(node.val);
			}
			node = node.right;
		}
	}
	public static void main(String[] args) {
		LeafSimilarTrees_LC0872 similarTrees = new LeafSimilarTrees_LC0872();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(5);	
		t1.left.left = new TreeNode(6);
		t1.left.right = new TreeNode(2);
		t1.left.right.left = new TreeNode(7);
		t1.left.right.right = new TreeNode(4);
		t1.right = new TreeNode(1);
		t1.right.left = new TreeNode(9);
		t1.right.right = new TreeNode(8);
		
		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(5);	
		t2.left.left = new TreeNode(6);
		t2.left.right = new TreeNode(7);
		t2.right = new TreeNode(1);
		t2.right.left = new TreeNode(4);
		t2.right.right = new TreeNode(2);
		t2.right.right.right = new TreeNode(8);
		t2.right.right.left = new TreeNode(9);
		
		System.out.println("Tree 1 & 2 are leaf similar: " + 
				similarTrees.leafSimilar(t1, t2));

		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(1);
		System.out.println("Tree 3 & 4 are leaf similar: " + 
				similarTrees.leafSimilar(t3, t4));
		
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(2);
		System.out.println("Tree 5 & 6 are leaf similar: " + 
				similarTrees.leafSimilar(t5, t6));
				
		TreeNode t7 = new TreeNode(1);
		t7.left = new TreeNode(2);
		TreeNode t8 = new TreeNode(2);
		t8.right = new TreeNode(2);
		System.out.println("Tree 7 & 8 are leaf similar: " + 
				similarTrees.leafSimilar(t7, t8));
		
		TreeNode t9 = new TreeNode(1);
		t9.left = new TreeNode(2);
		t9.right = new TreeNode(3);
		TreeNode t10 = new TreeNode(1);
		t10.left = new TreeNode(3);
		t10.right = new TreeNode(2);
		System.out.println("Tree 9 & 10 are leaf similar: " + 
				similarTrees.leafSimilar(t9, t10));
	}
}