/*
	https://leetcode.com/problems/binary-tree-level-order-traversal/
	Binary Tree Level Order Traversal - LeetCode #102
	
	Given a binary tree, return the level order traversal of its nodes' values. 
	(ie, from left to right, level by level).

	For example:
		Given binary tree [3,9,20,null,null,15,7],
		
					 (3)
					/	\
				   (9)  (20)
						/	\
					  (15)  (7)
		return its level order traversal as:
			[
			  [3],
			  [9,20],
			  [15,7]
			]
	
	Reference:
	Level Order Binary Tree Traversal (Breadth First Traversal)
	https://www.geeksforgeeks.org/level-order-tree-traversal/
	
	Method 1: 
	* Time Complexity: O(n^2) in worst case. For a skewed tree, 
	  printGivenLevel() takes O(n) time where n is the number of nodes in the 
	  skewed tree. So time complexity of printLevelOrder() is
	  O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2). 
	* Space Complexity: O(n) in worst case. For a skewed tree, 
	  printGivenLevel() uses O(n) space for call stack. For a Balanced tree, 
	  call stack uses O(log n) space, (i.e., height of the balanced tree). 
	 
	 Algorithm: 
		printLevelorder(tree) {
			for d = 1 to height(tree)
			   printGivenLevel(tree, d);
		}
		//Function to print all nodes at a given level
		printGivenLevel(tree, level) {
		if tree is NULL then return;
		if level is 1, then
			print(tree->data);
		else if level greater than 1, then
			printGivenLevel(tree->left, level-1);
			printGivenLevel(tree->right, level-1);
		}
	
	Method 2 - Using Queue.
	https://www.youtube.com/watch?v=MBZ-gBkjdMc
	* Time Complexity: O(n) where n is number of nodes in the binary tree 
	* Space Complexity: O(n) where n is number of nodes in the binary tree 
	
	Algorithm: 
	For each node, first the node is visited and then it’s child nodes are 
	put in a FIFO queue. 

		printLevelorder(tree)
		1) Create an empty queue q
		2) temp_node = root //start from root
		3) Loop while temp_node is not NULL
			a) print temp_node->data.
			b) Enqueue temp_node’s children 
			  (first left then right children) to q
			c) Dequeue a node from q.
*/
import java.util.*;

public class BinaryTreeLevelOrderTraversal_LC102 {
	public static void main(String[]  args) {
		BinaryTreeLevelOrderTraversal_LC102 btLevelOrderTraversal = new BinaryTreeLevelOrderTraversal_LC102();
		List<List<Integer>> ans1 = new LinkedList<>();
		List<List<Integer>> ans2 = new LinkedList<>();
		
		// example 1 input
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		
		// example 2 input
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.right.left = new TreeNode(6);
		t2.right.left.right = new TreeNode(9);
		t2.left.left = new TreeNode(4);
		t2.left.right = new TreeNode(5);
		t2.left.right.left = new TreeNode(7);
		t2.left.right.right = new TreeNode(8);
		
		/* Method 1
		ans1 = btLevelOrderTraversal.levelOrder(t2);
		System.out.print("[ ");
		for (int j = 0; j < ans1.size(); j++) {
				System.out.print("[ ");
				for (int n: ans1.get(j))
					System.out.print(n + " ");
				System.out.print("] ");
		}
		System.out.println("]");
		*/
		// Method 2
		ans2 = btLevelOrderTraversal.levelOrder2(t2);
		System.out.print("[ ");
		for (int j = 0; j < ans2.size(); j++) {
			System.out.print("[ ");
			for (int n: ans2.get(j))
				System.out.print(n + " ");
			System.out.print("] ");
		}
		System.out.println("]");
		//
	}
	
	// Method 1 Use function to add to a liston  a given level
    public List<List<Integer>> levelOrder(TreeNode root) {
        
		List<List<Integer>> bft = new LinkedList<>();
		int h = height(root);
		
		//System.out.println("Height of Tree: " + h);
		for (int i = 1; i <= h; i++) {
			bft.add(new ArrayList<>());
			levelOrderTraversal(bft, root, i, i-1);
		}
		
		return bft;
    }
	private void levelOrderTraversal(List<List<Integer>> list, TreeNode node, int level, int treelevel) {
		if (node == null)
			return;
		if (level == 1) {
			//System.out.println("Current Added Node: " + node.val + " Tree level: " + treelevel);
			list.get(treelevel).add(node.val);			
		} else if ( level > 1 ) {
			//System.out.println("Level: " + level + " current node: " + node.val + " left: " + 
			//			node.left.val + " right: " + node.right.val + " tree lv: " + treelevel);		
			levelOrderTraversal(list, node.left, level - 1, treelevel);
			levelOrderTraversal(list, node.right, level - 1, treelevel);
		}
	}
	private int height(TreeNode node) {
		if (node == null)
			return 0;
		else {
			// compute the height of each subtree
			int leftHeight = height(node.left);
			int rightHeight = height(node.right);
			
			if (leftHeight > rightHeight) 
				return (leftHeight + 1);
			else
				return (rightHeight + 1);
		}
	}
	// Method 2: Using Queue
	/*  1) Create an empty queue q
		2) temp_node = root //start from root
		3) Loop while temp_node is not NULL
			a) print temp_node->data.
			b) Enqueue temp_node’s children 
			  (first left then right children) to q
			c) Dequeue a node from q.
			
		https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
		Assume we don't delete val from the queue, for case 2, it will be like
		1->null->2->3->null->4->5->6->null->7->8->9->null
	*/
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> bft = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();		
		
		if (root == null) return bft;
				
		queue.add(root);
		queue.add(null);	// null marker to represent end of current level 
		bft.add(new ArrayList<Integer>());	// create the arraylist for root level
		
		// Do Level order of tree using NULL markers
		while ( !queue.isEmpty() ) {
			TreeNode tempNode = queue.poll();
			
			if (tempNode != null) {
				//System.out.println("Added " + tempNode.val );
				// add the poped node to the last arraylist in the list.
				bft.get(bft.size() - 1).add(tempNode.val);  
				
				if (queue.peek() == null) {
					// means end of current level, and have to 
					// create the arraylist in the list for next level
					bft.add(new ArrayList<Integer>()); 
				}
				
				// Enqueue left child
				if ( tempNode.left != null) 
					queue.add(tempNode.left);					
				
				// Enque right child
				if (tempNode.right != null) 
					queue.add(tempNode.right);

			} // if queue is not empty, push NULL to mark  
				// nodes at this level are visited 
			else if (! queue.isEmpty())
				queue.add(null);

		}
		
		bft.remove(bft.size() - 1);	// remove the last empty arraylist
		return bft;
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