/*
	https://leetcode.com/problems/invert-binary-tree/
	226. Invert Binary Tree
	
	Given the root of a binary tree, invert the tree, and return its root.

 

	Example 1:
					(4)							(4)
				/			\				/			\
			  (2)		    (7)			  (7)		    (2)
			/    \		  /  	\		/	  \		  /		\
		  (1)   (3)     (6)     (9)   (9)     (6)   (3)	    (1)

		Input: root = [4,2,7,1,3,6,9]
		Output: [4,7,2,9,6,3,1]
		
	Example 2:
					(2)					(2)
				  /		\			   /	\
				(1)	    (3)			 (3)	(1)

		Input: root = [2,1,3]
		Output: [2,3,1]
	
	Example 3:
		Input: root = []
		Output: []
 

	Constraints:
		The number of nodes in the tree is in the range [0, 100].
		-100 <= Node.val <= 100
	
*/
import java.util.*;

public class InvertBinaryTree_LC0226 {
	// Breadth-first-search
    public TreeNode invertTree(TreeNode root) {
        
		if (root == null) return null;
		
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		
		while ( !queue.isEmpty() ) {
			TreeNode node = queue.poll();
			if (node.right != null && node.left != null) {
				TreeNode temp = node.right;
				node.right = node.left;
				node.left = temp;
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		return root;
    }
	
	// Recursive
	public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return root;
        
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        
        return root;
    }
	
	public void printBinaryTree(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		if (root == null)
			System.out.println("[]");
		else {
			queue.add(root);
			while (!queue.isEmpty() ) {
				TreeNode node = queue.poll();
				System.out.print(node.val + " ");
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		InvertBinaryTree_LC0226 ivtTree = new InvertBinaryTree_LC0226();
		
		TreeNode t1 = new TreeNode(4);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(1);
		t1.left.right = new TreeNode(3);
		t1.right = new TreeNode(7);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(9);
		ivtTree.printBinaryTree(t1);
		TreeNode tree1 = ivtTree.invertTree(t1);
		ivtTree.printBinaryTree(tree1);
		
		
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		ivtTree.printBinaryTree(t2);
		TreeNode tree2 = ivtTree.invertTree(t2);
		ivtTree.printBinaryTree(tree2);
		
		TreeNode t3 = new TreeNode();
		ivtTree.printBinaryTree(t3);
		TreeNode tree3 = ivtTree.invertTree(t3);
		ivtTree.printBinaryTree(tree3);
		
		
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