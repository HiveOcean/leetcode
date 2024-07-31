/*
	https://leetcode.com/problems/cousins-in-binary-tree/
	993. Cousins in Binary Tree
	
	Given the root of a binary tree with unique values and the values 
	of two different nodes of the tree x and y, return true if the 
	nodes corresponding to the values x and y in the tree are cousins, 
	or false otherwise.

	Two nodes of a binary tree are cousins if they have the same depth 
	with different parents.

	Note that in a binary tree, the root node is at the depth 0, and 
	children of each depth k node are at the depth k + 1.
	
	Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:


Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.

Related topics:
Tree, Depth-First Search, Breadth-First Search, Binary Tree


*/
import java.util.*;

public class CousinsInBinaryTree_LC0993 {
    public boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		List<Integer> levelchildlist = new ArrayList<>();
		List<Integer> children = new ArrayList<>();
		
		queue.add(root);
		
		while ( ! queue.isEmpty() ) {
			int qSize = queue.size();
			
			while ( qSize > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					children.add(node.left.val);
					levelchildlist.add(node.left.val);
					queue.add(node.left);
				}
				if (node.right != null) {
					children.add(node.right.val);
					levelchildlist.add(node.right.val);
					queue.add(node.right);
				}
				// check if x, y are silbings
				if (children.contains(x) && children.contains(y))
					return false;
				children.clear();
				qSize--;
			}
			// finish one level and now check if x,  y in the level children list
			if (levelchildlist.contains(x) && levelchildlist.contains(y))
				return true;
			
			levelchildlist.clear();
		}
        return false;
    }
	public static void main(String[] args) {
		CousinsInBinaryTree_LC0993 cousins = new CousinsInBinaryTree_LC0993();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.left = new TreeNode(4);
		int x1 = 4, y1 = 3;
		System.out.println("Tree 1 - " + x1 + ", " + y1 + " are cousins? " +
				cousins.isCousins(t1, x1, y1));
				
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(5);
		int x2 = 5, y2 = 4;
		System.out.println("Tree 2 - " + x2 + ", " + y2 + " are cousins? " +
				cousins.isCousins(t2, x2, y2));
				
		TreeNode t3 = new TreeNode(1);
		t3.left = new TreeNode(2);
		t3.right = new TreeNode(3);
		t3.left.right = new TreeNode(4);
		int x3 = 2, y3 = 3;
		System.out.println("Tree 2 - " + x3 + ", " + y3 + " are cousins? " +
				cousins.isCousins(t3, x3, y3));
	}
}
