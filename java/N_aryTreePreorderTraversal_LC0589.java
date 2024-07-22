/*
	https://leetcode.com/problems/n-ary-tree-preorder-traversal/
	589. N-ary Tree Preorder Traversal
	
	Given the root of an n-ary tree, return the preorder traversal 
	of its nodes' values.

	Nary-Tree input serialization is represented in their level order 
	traversal. Each group of children is separated by the null value 
	(See examples)

	Example 1:
								(1)
						    /    |    \
						  (3)   (2)   (4)
						 /  \
					   (5)  (6)

		Input: root = [1,null,3,2,4,null,5,6]
		Output: [1,3,5,6,2,4]

	Example 2:
							(1)
						     |
					-------------------
					/    /       \     \
				  (2)   (3)   	(4)    (5)
					   /  \		 |     /   \
					 (6)  (7)   (8)  (9)  (10)
						   |     |    |
						 (11)  (12)  (13)
						   |
						 (14)

		Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
		Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
		 

	Constraints:
		The number of nodes in the tree is in the range [0, 104].
		0 <= Node.val <= 104
		The height of the n-ary tree is less than or equal to 1000.

	Follow up: 
		Recursive solution is trivial, could you do it iteratively?
*/
import java.util.*;

public class N_aryTreePreorderTraversal_LC0589 {
	// Method 1: recursive Preorder
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
		
		dsfPreOrder(root, list);
		return list;
    }
	private void dsfPreOrder(Node node, List<Integer> list) {
		if (node == null)
			return;
		
		list.add(node.val);
		if (node.children != null) {
			for (Node n: node.children)
				dsfPreOrder(n, list);
		}
	}
	public List<Integer> preorder2(Node root) {
		List<Integer> ans = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		
		stack.push(root);
		while (!stack.empty()) {
			Node node = stack.pop();
			if (node != null) {
				ans.add(node.val);				
				if (node.children != null) {
					
					for (int i = node.children.size() - 1; i >= 0; i--) {
						stack.push(node.children.get(i));
					}
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		N_aryTreePreorderTraversal_LC0589 preorderTree = new N_aryTreePreorderTraversal_LC0589();
		
		Node root1 = new Node(1);
		root1.children = new ArrayList<>();
		(root1.children).add(new Node(3));
		root1.children.add(new Node(2));
		root1.children.add(new Node(4));
		root1.children.get(0).children = new ArrayList<>();
		root1.children.get(0).children.add(new Node(5));
		root1.children.get(0).children.add(new Node(6));
		System.out.println("Preorder of Tree 1: " + preorderTree.preorder1(root1));
		System.out.println("Preorder of Tree 1: " + preorderTree.preorder2(root1));
		
		Node root2 = new Node(1);
		root2.children = new ArrayList<>();
		root2.children.add(new Node(2));
		root2.children.add(new Node(3));
		root2.children.add(new Node(4));
		root2.children.add(new Node(5));
		root2.children.get(1).children = new ArrayList<>();
		root2.children.get(1).children.add(new Node(6));
		root2.children.get(1).children.add(new Node(7));
		root2.children.get(2).children = new ArrayList<>();
		root2.children.get(2).children.add(new Node(8));
		root2.children.get(3).children = new ArrayList<>();
		root2.children.get(3).children.add(new Node(9));
		root2.children.get(3).children.add(new Node(10));
		root2.children.get(1).children.get(1).children = new ArrayList<>();
		root2.children.get(1).children.get(1).children.add(new Node(11));
		root2.children.get(2).children.get(0).children = new ArrayList<>();
		root2.children.get(2).children.get(0).children.add(new Node(12));
		root2.children.get(3).children.get(0).children = new ArrayList<>();
		root2.children.get(3).children.get(0).children.add(new Node(13));	
		root2.children.get(1).children.get(1).children.get(0).children = new ArrayList<>();
		root2.children.get(1).children.get(1).children.get(0).children.add(new Node(14));
		
		System.out.println("Preorder of Tree 2: " + preorderTree.preorder1(root2));	
		System.out.println("Preorder of Tree 2: " + preorderTree.preorder2(root2));	
	}
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/