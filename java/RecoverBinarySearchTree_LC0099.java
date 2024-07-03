/*
	https://leetcode.com/problems/recover-binary-search-tree/
	99. Recover Binary Search Tree (Medium)
	
	You are given the root of a binary search tree (BST), where the values of exactly 
	two nodes of the tree were swapped by mistake. Recover the tree without changing 
	its structure.
	
	Example 1:
					(1)						(3)
				   /					   /
				 (3)			=>		 (1)
				   \					   \
				   (2)					   (2)
					

		Input:	root = [1,3,null,null,2]
		Output: [3,1,null,null,2]
		Explanation: 3 cannot be a left child of 1 because 3 > 1. 
					 Swapping 1 and 3 makes the BST valid.
		
	Example 2:
					(3)						(2)
				   /   \				   /    \
				 (1)   (4)		=>		 (1)    (4)
					   /						/
				     (2)					  (2)

		Input: root = [3,1,4,null,null,2]
		Output: [2,1,4,null,null,3]
		Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.


	Constraints:
		The number of nodes in the tree is in the range [2, 1000].
		-2^31 <= Node.val <= 2^31 - 1

	
	Follow up: A solution using O(n) space is pretty straight-forward. Could you 
			   devise a constant O(1) space solution?	
	
*/
import java.util.*;

public class RecoverBinarySearchTree_LC0099 {
    public void recoverTree(TreeNode root) {
        
		List<TreeNode> treelist = new ArrayList<>();
		
		// first do the inorder traversal of the tree
		inOrderTraversal(root, treelist);
		// now the list in inorder traversal of tree
		for (int i = 0; i < treelist.size(); i++){
			System.out.print(treelist.get(i).val + " ");
		}
		System.out.println();
		// the inorder traversal of BST should be in ascending order so
		// now only need to find the two out of sequential to swap
		// Here use two point to find them
		int left = 0, right = treelist.size() - 1;
		boolean found1 = false, found2 = false;
		
		while ((!found1 || !found2) && left < right  ) {
			if (treelist.get(left).val > treelist.get(left + 1).val) {
				found1 = true;
			} else
				left++;
			if (treelist.get(right).val < treelist.get(right - 1).val) {
				found2 = true;
			} else
				right--;
		}
		// Swap the two
		int temp = treelist.get(left).val;
		treelist.get(left).val = treelist.get(right).val;
		treelist.get(right).val = temp;
		
		
		for (int i = 0; i < treelist.size(); i++){
			System.out.print(treelist.get(i).val + " ");
		}
    }
	private void inOrderTraversal(TreeNode node, List<TreeNode> treelist) {
		
		if (node == null)
			return;
		
		inOrderTraversal(node.left, treelist);
		treelist.add(node);
		inOrderTraversal(node.right, treelist);
	}
	public static void main(String[] args) {
		RecoverBinarySearchTree_LC0099 recoverBSTree = new RecoverBinarySearchTree_LC0099();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.left.right = new TreeNode(2);
		
		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(4);
		t2.right.left = new TreeNode(2);
		
		recoverBSTree.recoverTree(t1);
		System.out.println();
		recoverBSTree.recoverTree(t2);
	}
}

	