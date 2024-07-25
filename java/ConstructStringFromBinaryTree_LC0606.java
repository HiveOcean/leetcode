/*
	https://leetcode.com/problems/construct-string-from-binary-tree/
	606. Construct String from Binary Tree

	Given the root of a binary tree, construct a string consisting 
	of parenthesis and integers from a binary tree with the preorder 
	traversal way, and return it.

	Omit all the empty parenthesis pairs that do not affect the 
	one-to-one mapping relationship between the string and the 
	original binary tree.
	 
	
	Example 1:
				 (1)
			   /     \		
			 (2)     (3)	
			/ 
		  (4)	

		Input: root = [1,2,3,4]
		Output: "1(2(4))(3)"
		Explanation: Originally, it needs to be "1(2(4)())(3()())",
			but you need to omit all the unnecessary empty parenthesis 
			pairs. And it will be "1(2(4))(3)"
		
	Example 2:
				 (1)
			   /     \		
			 (2)     (3)	
				\
				(4)

		Input: root = [1,2,3,null,4]
		Output: "1(2()(4))(3)"
		Explanation: Almost the same as the first example, except we
			cannot omit the first parenthesis pair to break the 
			one-to-one mapping relationship between the input and the 
			output.
		 

	Constraints:
		The number of nodes in the tree is in the range [1, 10^4].
		-1000 <= Node.val <= 1000

	Related topics:
		String, Tree, Depth-First Search, Binary Tree
		
*/
import java.util.*;

public class ConstructStringFromBinaryTree_LC0606 {
	// Method 1: recursion
/*    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
		
		if (root == null) return "";
				
		constructTreeStr(root);
		
		return str.toString();
    }
	private void constructTreeStr(TreeNode node, StringBuilder str) {
		

				
				

		
	}
	*/
	// Method 2: iternatively
	public String tree2str(TreeNode root) {
		StringBuilder str = new StringBuilder();
		Stack<TreeNode> stack = new Stack<>();
		//TreeNode dummy = new TreeNode(2000);
		if (root == null) 
			return "";
		
		stack.push(root);
		
		while ( !stack.empty() ) {
			TreeNode node = stack.pop();
			if (node != null && node.val == 2000) {
				str.append(")");
				if (stack.size() >0)
					str.append("(");
			} else {
				if (node != null) {
					if (node.left == null && node.right == null)
						str.append(node.val + ")");
					//	str.append("("+ node.val +")");
					else {
						str.append(node.val);
						if (node.left != null || node.right != null)
							str.append("(");
					
						if (node.left == null) //&& node.right != null)
							str.append("()");
						stack.push(new TreeNode(2000));
						stack.push(node.right);
						stack.push(node.left);
						//str.append(")");
					}
				}
			}		
		}
		System.out.println(str);
		return str.toString();
	}
	public static void main(String[] args) {
		ConstructStringFromBinaryTree_LC0606 getStr = new ConstructStringFromBinaryTree_LC0606();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.left = new TreeNode(4);
		System.out.println("Tree 1 in string: " + getStr.tree2str(t1));
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		System.out.println("Tree 1 in string: " + getStr.tree2str(t2));
	}
}