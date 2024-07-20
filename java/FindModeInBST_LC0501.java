/*
	https://leetcode.com/problems/find-mode-in-binary-search-tree/
	501. Find Mode in Binary Search Tree
	
	Given the root of a binary search tree (BST) with duplicates, 
	return all the mode(s) (i.e., the most frequently occurred element) 
	in it.

	If the tree has more than one mode, return them in any order.

	Assume a BST is defined as follows:

		- The left subtree of a node contains only nodes with keys 
		  less than or equal to the node's key.
		- The right subtree of a node contains only nodes with keys 
		  greater than or equal to the node's key.
		- Both the left and right subtrees must also be binary search 
		  trees.
		 

	Example 1:


		Input: root = [1,null,2,2]
		Output: [2]
		
	Example 2:

		Input: root = [0]
		Output: [0]
		 

	Constraints:
		The number of nodes in the tree is in the range [1, 104].
		-10^5 <= Node.val <= 10^5
		 

	Follow up: 
	Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

	Related topics:
		Tree, Depth-First Search, Binary Search Tree, Binary Tree
		
*/
import java.util.*;

public class FindModeInBST_LC0501 {
    public int[] findMode(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
		int frequency = Integer.MIN_VALUE;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		// use preorder traversal
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				map.put(node.val, map.getOrDefault(node.val,0) + 1);
				if (frequency < map.get(node.val))
					frequency = map.get(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		final int freq = frequency;
		map.forEach((key,value) -> {
			if (value == freq)
				ans.add(key);
		});
		
		return ans.stream().mapToInt(i->i).toArray();
		//return ans.stream().mapToInt(Integer::intValue).toArray();
    }
	public static void main(String[] args){
		FindModeInBST_LC0501 mode = new FindModeInBST_LC0501();
		
		TreeNode t1 = new TreeNode(1);
		t1.right = new TreeNode(2);
		t1.right.left = new TreeNode(2);
		System.out.println("Tree 1: " + Arrays.toString(mode.findMode(t1)));
		
		TreeNode t2 = new TreeNode(0);
		System.out.println("Tree 2: " + Arrays.toString(mode.findMode(t2)));
		
		TreeNode t3 = new TreeNode(5);
		t3.left = new TreeNode(3);
		t3.left.left = new TreeNode(3);
		t3.left.right = new TreeNode(3);
		t3.right = new TreeNode(9);
		t3.right.right = new TreeNode(15);
		t3.right.right.left = new TreeNode(12);
		t3.right.right.left.left = new TreeNode(12);
		t3.right.right.left.right = new TreeNode(12);
		System.out.println("Tree 3: " + Arrays.toString(mode.findMode(t3)));
	}
}	