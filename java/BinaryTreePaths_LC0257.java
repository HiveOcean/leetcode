/*
	https://leetcode.com/problems/binary-tree-paths/
	257. Binary Tree Paths
	
	Given the root of a binary tree, return all root-to-leaf paths in any order.

	A leaf is a node with no children.

		 

	Example 1:
						(1)
					   /   \
					 (2)   (3)
					   \ 
					   (5)
					   
		Input: root = [1,2,3,null,5]
		Output: ["1->2->5","1->3"]
		
	Example 2:

		Input: root = [1]
		Output: ["1"]
		 

	Constraints:
		The number of nodes in the tree is in the range [1, 100].
		-100 <= Node.val <= 100

	Related topics:
		String, Tree, Depth-First Search, Binary Tree 


*/
import java.util.*;

public class BinaryTreePaths_LC0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
		
		if (root != null )
			findPaths(root, paths, "");
		return paths;
    }
	private void findPaths(TreeNode node, List<String> paths, String path) {
			
		if (node.left == null && node.right == null) {
			paths.add(path + node.val);
		}
		if (node.left != null)
			findPaths(node.left, paths, path + node.val + "->");
		if (node.right != null)
			findPaths(node.right, paths, path + node.val + "->");	
	}
	public static void main(String[] args) {
		BinaryTreePaths_LC0257 treePaths = new BinaryTreePaths_LC0257();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.right = new TreeNode(5);
		System.out.println("Tree 1: " + treePaths.binaryTreePaths(t1).toString());
		
		TreeNode t2 = new TreeNode(1);
		System.out.println("Tree 2: " + treePaths.binaryTreePaths(t2).toString());
	}
}