/*
	https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	235. Lowest Common Ancestor of a Binary Search Tree
	
	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two 
	given nodes in the BST.

	According to the definition of LCA on Wikipedia: "The lowest common ancestor
	is defined between two nodes p and q as the lowest node in T that has both p 
	and q as descendants (where we allow a node to be a descendant of itself)."

		 

	Example 1:
							 (6)
						 /		   \
					  (2)		    (8)
					/	  \		  /     \
				  (0)	 (4)	(7)		(9)
					    /   \
					  (3)   (5)

		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
		Output: 6
		Explanation: The LCA of nodes 2 and 8 is 6.
		
	Example 2:
							 (6)
						 /		   \
					  (2)		    (8)
					/	  \		  /     \
				  (0)	 (4)	(7)		(9)
					    /   \
					  (3)   (5)

		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
		Output: 2
		Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
		
	Example 3:

		Input: root = [2,1], p = 2, q = 1
		Output: 2
		 
	Example 4:
							 (20)
						 /		   \
					  (8)		    (22)
					/	  \		 
				  (4)	 (12)
					    /   \
					  (10)   (14)			

		Input: p = 10, q = 14
		Output: 12
					  
	Constraints:

		The number of nodes in the tree is in the range [2, 10^5].
		-10^9 <= Node.val <= 10^9
		All Node.val are unique.
		p != q
		p and q will exist in the BST.
		
	Related topics:
		Tree, Depth-First Search, Binary Search Tree, Binary Tree
	
	Solution
	https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 
	is defined as the lowest node in T that has both n1 and n2 as descendants 
	(where we allow a node to be a descendant of itself).
	The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located 
	farthest from the root. Computation of lowest common ancestors may be useful, 
	for instance, as part of a procedure for determining the distance between 
	pairs of nodes in a tree: the distance from n1 to n2 can be computed as the 
	distance from the root to n1, plus the distance from the root to n2, minus 
	twice the distance from the root to their lowest common ancestor. 
	
	Approach: For Binary search tree, while traversing the tree from top to bottom 
	the first node which lies in between the two numbers n1 and n2 is the LCA of 
	the nodes, i.e. the first node n with the lowest depth which lies in between 
	n1 and n2 (n1<=n<=n2) n1 < n2. So just recursively traverse the BST in, if 
	node’s value is greater than both n1 and n2 then our LCA lies in the left 
	side of the node, if it’s is smaller than both n1 and n2, then LCA lies on 
	the right side. Otherwise, the root is LCA (assuming that both n1 and n2 are 
	present in BST).

	Algorithm:  

	1. Create a recursive function that takes a node and the two values n1 and n2.
	2. If the value of the current node is less than both n1 and n2, then LCA lies 
	   in the right subtree. Call the recursive function for the right subtree.
	3. If the value of the current node is greater than both n1 and n2, then LCA 
	   lies in the left subtree. Call the recursive function for the left subtree.
	4. If both the above cases are false then return the current node as LCA.
*/
public class LowestCommonAncesterOfaBST_LC0235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) 
			return null;
		
		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		
		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		
		return root;
    }
	public static void main(String[] args) {
		LowestCommonAncesterOfaBST_LC0235 lca = new LowestCommonAncesterOfaBST_LC0235();
		
		TreeNode t1 = new TreeNode(6);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(8);
		t1.left.left = new TreeNode(0);
		t1.left.right = new TreeNode(4);
		t1.left.right.left = new TreeNode(3);
		t1.left.right.right = new TreeNode(5);
		t1.right.left = new TreeNode(7);
		t1.right.right = new TreeNode(9);
		TreeNode p1 = new TreeNode(2), q1 = new TreeNode(8);
		
		System.out.println("Tree 1 LCA of " + p1.val + ", " + q1.val + " is " + 
				lca.lowestCommonAncestor(t1,p1,q1).val);
		
		TreeNode p2 = new TreeNode(2), q2 = new TreeNode(4);
		System.out.println("Tree 1 LCA of " + p2.val + ", " + q2.val + " is " + 
				lca.lowestCommonAncestor(t1,p2,q2).val);
				
				
		TreeNode t3 = new TreeNode(2);
		t3.left = new TreeNode(1);
		TreeNode p3 = new TreeNode(2), q3 = new TreeNode(1);
		System.out.println("Tree 3 LCA of " + p3.val + ", " + q3.val + " is " + 
				lca.lowestCommonAncestor(t3,p3,q3).val);
		
		TreeNode t4 = new TreeNode(20);
		t4.left = new TreeNode(8);
		t4.left.left = new TreeNode(4);
		t4.left.right = new TreeNode(12);
		t4.left.right.left = new TreeNode(10);
		t4.left.right.right = new TreeNode(14);
		t4.right = new TreeNode(22);
		TreeNode p4 = new TreeNode(10), q4 = new TreeNode(14);
		System.out.println("Tree 4 LCA of " + p4.val + ", " + q4.val + " is " + 
				lca.lowestCommonAncestor(t4,p4,q4).val);
	}
}		