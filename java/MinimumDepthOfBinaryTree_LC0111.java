/*
	https://leetcode.com/problems/minimum-depth-of-binary-tree/
	111. Minimum Depth of Binary Tree
	
	Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

	Note: A leaf is a node with no children.

	 

	Example 1:
						(3)
					  /		\
					(9)		(20)
							/	\
						  (15)	(7)

		Input: root = [3,9,20,null,null,15,7]
		Output: 2

	Example 2:
						(1)
					   /	\
					 (9)	(3)
							  \
							  (4)
							    \
								(5)
								  \
								  (6)
						
		Input: root = [2,9,3,null,4,null,5,null,6]
		Output: 2
	
	Example 3:
						(2)
							\
							(3)
							  \
							  (4)
							    \
								(5)
								  \
								  (6)
						
		Input: root = [2,null,3,null,4,null,5,null,6]
		Output: 5
	 

	Constraints:

	The number of nodes in the tree is in the range [0, 10^5].
	-1000 <= Node.val <= 1000
	
	 Method 1: DFS 
		may end up with complete traversal of Binary Tree even when the topmost 
		leaf is close to root. 
		
	Method 2: Level order traversal
		A Better Solution is to do Level Order Traversal. While doing traversal, 
		returns depth of the first encountered leaf node.
*/
import java.util.*;

public class MinimumDepthOfBinaryTree_LC0111 {
	// Method 1: DFS 
    public int minDepth1(TreeNode root) {
        if (root == null)
			return 0;
		if (root.left == null) 
			return minDepth1(root.right) + 1;
		if (root.right == null)
			return minDepth1(root.left) + 1;
		return 1+ Math.min(minDepth1(root.left), minDepth1(root.right));
    }
	// Method 2: Level order traverse
	public int minDepth2(TreeNode root)
	{
		// Corner Case
		if (root == null)
			return 0;
	 
		// Create an empty queue for level order traversal
		Queue<qItem> q = new LinkedList<>();
	 
		// Enqueue Root and initialize depth as 1
		qItem qi = new qItem(root, 1);
		q.add(qi);
	 
		// Do level order traversal
		while (q.isEmpty() == false)
		{
			// Remove the front queue item
			qi = q.poll();

			// Get details of the remove item
			TreeNode node = qi.node;
			int depth = qi.depth;
		 	
			// If this is the first leaf node seen so far
			// Then return its depth as answer
			if (node.left == null && node.right == null)
				return depth;
		 
			// If left subtree is not null,
			// add it to queue
			if (node.left != null)
			{
				qItem nodeleft = new qItem(node.left, depth + 1);				
				q.add(nodeleft);
			}
			// If right subtree is not null,
			// add it to queue
			if (node.right != null)
			{
				qItem noderight = new qItem(node.right, depth + 1);
				q.add(noderight);
			}		
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree_LC0111 findmin = new MinimumDepthOfBinaryTree_LC0111();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		
		System.out.println("Tree root value: " + t1.val + " with min depth: " +
						findmin.minDepth1(t1));
		System.out.println("Tree root value: " + t1.val + " with min depth: " +
						findmin.minDepth2(t1));				
		
						
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(9);
		t2.right = new TreeNode(2);
		t2.right.right = new TreeNode(3);
		t2.right.right.right = new TreeNode(4);
		t2.right.right.right.right = new TreeNode(5);
		System.out.println("Tree root value: " + t2.val + " with min depth: " +
						findmin.minDepth1(t2));
		System.out.println("Tree root value: " + t2.val + " with min depth: " +
						findmin.minDepth2(t2));
		
		TreeNode t3 = new TreeNode(1);
		t3.right = new TreeNode(2);
		t3.right.right = new TreeNode(3);
		t3.right.right.right = new TreeNode(4);
		t3.right.right.right.right = new TreeNode(5);
		System.out.println("Tree root value: " + t3.val + " with min depth: " +
						findmin.minDepth1(t3));
		System.out.println("Tree root value: " + t3.val + " with min depth: " +
						findmin.minDepth2(t3));	
	}
}
// for method 2
class qItem
{
    TreeNode node;
    int depth;
 
    public qItem(TreeNode node, int depth)
    {
        this.node = node;
        this.depth = depth;
    }
}