/*
	https://leetcode.com/problems/merge-two-binary-trees/
	617. Merge Two Binary Trees (Easy)
	
	You are given two binary trees root1 and root2.

	Imagine that when you put one of them to cover the other, some nodes of the two 
	trees are overlapped while the others are not. You need to merge the two trees 
	into a new binary tree. The merge rule is that if two nodes overlap, then sum node
	values up as the new value of the merged node. Otherwise, the NOT null node will 
	be used as the node of the new tree.

	Return the merged tree.

	Note: The merging process must start from the root nodes of both trees.

			(1)				(2)								(3)
		   /   \		   /   \						 /		 \
		 (3)   (2)		 (1)   (3)		  ==>		   (4)		 (5)
		/				   \	  \					  /	  \			\
	  (5)				   (4)    (7)				(5)   (4)	    (7)
	  
 
	Example 1:
		Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
		Output: [3,4,5,5,4,null,7]

	Example 2:
		Input: root1 = [1], root2 = [1,2]
		Output: [2,2]
 
	Constraints:
		The number of nodes in both trees is in the range [0, 2000].
		-10^4 <= Node.val <= 10^4
	
	Breadth First Traversal: 
	https://www.tutorialspoint.com/data_structures_algorithms/breadth_first_traversal.htm
						(s)
					/	 |	  \
				   A	 B 	   C
				   |	 |	   |
				   D 	 E 	   F
					\	 |    /
						 G
					
	As in the example given above, BFS algorithm traverses from A to B to E to F first 
	then to C and G lastly to D. It employs the following rules.

		Rule 1 − Visit the adjacent unvisited vertex. Mark it as visited. Display it. 
				 Insert it in a queue.
		Rule 2 − If no adjacent vertex is found, remove the first vertex from the queue.
		Rule 3 − Repeat Rule 1 and Rule 2 until the queue is empty.
	
	Solution:
	https://leetcode.com/problems/merge-two-binary-trees/discuss/104331/Java-One-Recursive-Solution-and-Two-Iterative-Solutions-(DFS-and-BFS)-with-Explanations
	
*/
import java.util.*;

public class MergeTwoBinaryTrees_LC0617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		Queue<TreeNode[]> queue = new LinkedList<>();
		
		if (t1 == null && t2 == null)
			return null;
		
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
			
		queue.add( new TreeNode[]{t1, t2} );
		
		while ( !queue.isEmpty()) {
			
			TreeNode[] nodes = queue.poll();
			// merge tree2 node's val to tree1's node when tree2 is not null
			if (nodes[1] == null) 
				continue;
			
			// tree1 node must not be null
			nodes[0].val = nodes[0].val + nodes[1].val;
			
			
			if (nodes[0].left == null)
				nodes[0].left = nodes[1].left;
			else 
				queue.add(new TreeNode[]{nodes[0].left, nodes[1].left});
			
			if (nodes[0].right == null) 
				nodes[0].right = nodes[1].right;
			else
				queue.add(new TreeNode[]{nodes[0].right, nodes[1].right});
			
			
		}
		
		return t1;
    }
	public static void printTree(TreeNode n) {
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(n);

		while(q.size() > 0) {
			TreeNode node = q.poll();
			if (node == null )
				System.out.print("null ");
			else
				System.out.print(node.val + " "); 
			
			if (node.left != null) q.add(node.left);
			if (node.right != null) q.add(node.right);
		}
		System.out.println();
	}
	public static void main(String[] ags) {
		MergeTwoBinaryTrees_LC0617 tree = new MergeTwoBinaryTrees_LC0617();
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7); 
		
		//printTree(root1);
		
		//printTree(root2);
		System.out.println("\n***********");
		TreeNode mergeTree1 = tree.mergeTrees(root1, root2); // output [3,4,5,5,4,null,7]
		printTree(mergeTree1);
		
		TreeNode root3 = new TreeNode(1);
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		
		TreeNode mergeTree2 = tree.mergeTrees(root3, root4);
	}
}	
/**
 * Definition for a binary tree node.
 */
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

