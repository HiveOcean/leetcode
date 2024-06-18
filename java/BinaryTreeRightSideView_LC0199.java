/*
	https://leetcode.com/problems/binary-tree-right-side-view/
	199. Binary Tree Right Side View
	
	Given the root of a binary tree, imagine yourself standing on the 
	right side of it, return the values of the nodes you can see ordered 
	from top to bottom.

 

	Example 1:
		    1
		  /   \
		 2     3
		 \      \
		  5     4				

		Input: root = [1,2,3,null,5,null,4]
		Output: [1,3,4]
		
	Example 2:

		Input: root = [1,null,3]
		Output: [1,3]
		
	Example 3:

		Input: root = []
		Output: []
		 
	Constraints:
		The number of nodes in the tree is in the range [0, 100].
		-100 <= Node.val <= 100
	
	Solution:
	Method 1: recursive
	https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
	1. Each depth of the tree only select one node.
	   the traverse of the tree is NOT standard pre-order traverse. It checks 
	   the RIGHT node first and then the LEFT
	2. View depth is current size of the result list.
	   the line to check depth == result.size() makes sure the first element 
	   of that level will be added to the result list
	if reverse the visit order, that is first LEFT and then RIGHT, it will 
	return the left view of the tree.
	
	Method 2: BFS level order traversal.
	
*/
import java.util.*;

public class BinaryTreeRightSideView_LC0199 {
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		
		//  pass the current node, result list and height to dfsRightView.
		dfsRightView(root, result, 0);
		
        return result;
    }
	private void dfsRightView(TreeNode node, List<Integer> result, int height) {
		if (node == null)
			return;
		
		if (result.size() == height) 
			result.add(node.val);
		
		dfsRightView(node.right, result, height + 1);
		dfsRightView(node.left, result, height + 1);
	}
	// Method 2: iterative BFS level order traversal
	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		if (root == null) 
			return result;
		
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				size--;
				if (size == 0)
					result.add(node.val);
				
				if (node.left != null) 
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		BinaryTreeRightSideView_LC0199 findRightView = new BinaryTreeRightSideView_LC0199();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.right = new TreeNode(5);
		t1.right.right = new TreeNode(4);
		System.out.println("Tree 1: " + findRightView.rightSideView(t1).toString());
		System.out.println("Tree 1: " + findRightView.rightSideView2(t1).toString());
		
		TreeNode t2 = new TreeNode(1);
		t2.right = new TreeNode(3);
		System.out.println("Tree 2: " + findRightView.rightSideView(t2).toString());
		System.out.println("Tree 2: " + findRightView.rightSideView2(t2).toString());
		
		TreeNode t3 = new TreeNode();
		System.out.println("Tree 3: " + findRightView.rightSideView(t3).toString());
		System.out.println("Tree 3: " + findRightView.rightSideView2(t3).toString());
		
		TreeNode t4 = new TreeNode(1);
		t4.left = new TreeNode(2);
		t4.left.left = new TreeNode(3);
		t4.left.right = new TreeNode(4);
		t4.left.right.right = new TreeNode(5);
		
		System.out.println("Tree 4: " + findRightView.rightSideView(t4).toString());
		System.out.println("Tree 4: " + findRightView.rightSideView2(t4).toString());
		
	}
}