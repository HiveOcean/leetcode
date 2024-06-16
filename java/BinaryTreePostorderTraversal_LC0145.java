/*
	https://leetcode.com/problems/binary-tree-postorder-traversal/
	145. Binary Tree Postorder Traversal
	
	Given the root of a binary tree, return the postorder traversal of its nodes' values.

	Postorder (Left, Right, Root)

	Example 1:
						(1)
							\
							(2)
							/
						  (3)

		Input: root = [1,null,2,3]
		Output: [3,2,1]
		Example 2:

		Input: root = []
		Output: []
	
	Example 3:

		Input: root = [1]
		Output: [1]
		
	Example 4:
						(1)
					  /
					(2)

		Input: root = [1,2]
		Output: [2,1]
		
	Example 5:
						(1)
							\
							(2)

		Input: root = [1,null,2]
		Output: [2,1]
		 
	Example 6:
						(1)
					  /		\
					(2)		(3)
					/ \
				  (4) (5)	
				  
		Output: [4 5 2 3 1]

	Constraints:

		The number of the nodes in the tree is in the range [0, 100].
		-100 <= Node.val <= 100
		 

	Follow up: Recursive solution is trivial, could you do it iteratively?
	
	Related topics:
		Stack, Tree, Depth-First Search, Binary Tree
*/
import java.util.*;

class BinaryTreePostorderTraversal_LC0145 {
	// Method 1: recursive
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
		
		postorderUtil(root, ans);
		return ans;
	}
	private void postorderUtil(TreeNode node, List<Integer> list) {

		if (node != null) {
			postorderUtil(node.left, list);
			postorderUtil(node.right, list);
			list.add(node.val);
		}
	}
	// Method 2: iteratively 
	public List<Integer> postorderTraversal2(TreeNode root) {
		LinkedList<Integer> ans = new LinkedList<>();
		
		if (root == null) return ans;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while ( !stack.empty()) {
			TreeNode node = stack.pop();
			ans.addFirst(Integer.valueOf(node.val));
			
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return ans;
	}
	
	// Method 2 alternative: iteratively 
	// https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
	public List<Integer> postorderTraversal3(TreeNode node) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> S = new Stack<>();
         
        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        TreeNode prev = null;
        while (!S.isEmpty())
        {
            TreeNode current = S.peek();
 
            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                                        prev.right == current)
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.val);
                }
 
                /* go up the tree from left node, if the child is right
                push it onto stack otherwise process parent and pop
                stack */
            }
            else if (current.left == prev)
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.val);
                }
                 
                /* go up the tree from right node and after coming back
                from right node process parent and pop stack */
            }
            else if (current.right == prev)
            {
                S.pop();
                list.add(current.val);
            }
 
            prev = current;
        }
 
        return list;
	} 
	
	public static void main(String[] args) {
		BinaryTreePostorderTraversal_LC0145 postorder = new BinaryTreePostorderTraversal_LC0145();
		
		TreeNode t1 = new TreeNode(1);
		t1.right = new TreeNode(2);
		t1.right.left = new TreeNode(3);
		System.out.println("Tree 1: " + postorder.postorderTraversal1(t1).toString());
		
		TreeNode t2 = null;
		System.out.println("Tree 2: " + postorder.postorderTraversal1(t2).toString());
		
		TreeNode t3 = new TreeNode(1);
		System.out.println("Tree 3: " + postorder.postorderTraversal1(t3).toString());
		
		TreeNode t4 = new TreeNode(1);
		t4.left = new TreeNode(2);
		System.out.println("Tree 4: " + postorder.postorderTraversal1(t4).toString());
		
		TreeNode t5 = new TreeNode(1);
		t5.right = new TreeNode(2);
		System.out.println("Tree 5: " + postorder.postorderTraversal1(t5).toString());
		
		TreeNode t6 = new TreeNode(1);
		t6.left = new TreeNode(2);
		t6.left.left = new TreeNode(4);
		t6.left.right = new TreeNode(5);
		t6.right = new TreeNode(3);
		System.out.println("Tree 6: " + postorder.postorderTraversal1(t6).toString());
		
		TreeNode t7 = new TreeNode(1);
		t7.left = new TreeNode(2);
		t7.right = new TreeNode(3);
		t7.left.left = new TreeNode(4);
		t7.left.right = new TreeNode(5);
		t7.right.left = new TreeNode(6);
		t7.right.right = new TreeNode(7);
		System.out.println("Tree 7: " + postorder.postorderTraversal1(t7).toString());
		System.out.println("Tree 7: " + postorder.postorderTraversal2(t7).toString());
		System.out.println("Tree 7: " + postorder.postorderTraversal3(t7).toString());
	}
}