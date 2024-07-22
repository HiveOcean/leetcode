/*
	https://leetcode.com/problems/subtree-of-another-tree/
	572. Subtree Of Another Tree
	
	Given the roots of two binary trees root and subRoot, return true 
	if there is a subtree of root with the same structure and node 
	values of subRoot and false otherwise.

	A subtree of a binary tree tree is a tree that consists of a node 
	in tree and all of this node's descendants. The tree tree could 
	also be considered as a subtree of itself.


	Example 1:
				root
				 (3)
			   /     \				subRoot
			 (4)     (5)			  (4)
			/   \                    /   \
          (1)   (2)				   (1)   (2)
		  
		Input: root = [3,4,5,1,2], subRoot = [4,1,2]
		Output: true
		
	Example 2:
				root
				 (3)
			   /     \				subRoot
			 (4)     (5)			  (4)
			/   \                    /   \
          (1)   (2)				   (1)   (2)
				/
			  (0)

		Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
		Output: false
		 

	Constraints:

		The number of nodes in the root tree is in the range [1, 2000].
		The number of nodes in the subRoot tree is in the range [1, 1000].
		-10^4 <= root.val <= 10^4
		-10^4 <= subRoot.val <= 10^4

	Related topics:
		Tree, DFS, String Matching, Binary Tree, Hash Function
	
	Hints:
	If you use recursive, can you write recursive function with its 
	parameters?  Two trees s and t are said to be identical if their 
	root values are same and their left and right subtrees are 
	identical. Can you write this in form of recursive formulae?
	Recursive formulae can be: 
	isIdentical(s,t)= s.val==t.val AND isIdentical(s.left,t.left) AND isIdentical(s.right,t.right)
	
*/
import java.util.*;

public class SubtreeOfAnotherTree_LC0572 {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isIdentical(root, subRoot);
    }
	private boolean isIdentical(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 ==null )
			return false;
		
		if (n1.val == n2.val)
			return (isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right));
		
		return (isIdentical(n1.left, n2) || isIdentical(n1.right, n2));
	}
	public static void main(String[] args) {
		SubtreeOfAnotherTree_LC0572 identicalSubTrees = new SubtreeOfAnotherTree_LC0572();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(4);
		t1.right = new TreeNode(5);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(2);
		TreeNode st1 = new TreeNode(4);
		st1.left = new TreeNode(1);
		st1.right = new TreeNode(2);
		
		System.out.println("Tree 1 has identical subtree: " + identicalSubTrees.isSubtree(t1,st1));
		
		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(4);
		t2.right = new TreeNode(5);
		t2.left.left = new TreeNode(1);
		t2.left.right = new TreeNode(2);
		t2.left.right.left = new TreeNode(0);
		TreeNode st2 = new TreeNode(4);
		st2.left = new TreeNode(1);
		st2.right = new TreeNode(2);
		
		System.out.println("Tree 2 has identical subtree: " + identicalSubTrees.isSubtree(t2,st2));
	}
}