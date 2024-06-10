/*
	https://leetcode.com/problems/same-tree/
	100. Same Tree
	
	Given the roots of two binary trees p and q, write a function to check 
	if they are the same or not.

	Two binary trees are considered the same if they are structurally identical, 
	and the nodes have the same value.
	
	Example 1:
					(1)			(1)
				   /   \       /   \
				 (2)   (3)   (2)   (3)
	
		Input: p = [1,2,3], q = [1,2,3]
		Output: true
		
	Example 2:
					(1)			(1)
				   /               \
				 (2)   				(2)
		Input: p = [1,2], q = [1,null,2]
		Output: false

	Example 3:
					(1)			(1)
				   /   \       /   \
				 (2)   (1)   (1)   (2)	
		Input: p = [1,2,1], q = [1,1,2]
		Output: false
		 

	Constraints:
		The number of nodes in both trees is in the range [0, 100].
		-10^4 <= Node.val <= 10^4

	Related topics:
		Tree, Depth-First-Search, Breadth-First-Search, Binary Tree

*/
import java.util.*;

public class SameTree_LC0100 {
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		// p and q are null
		if (p == null && q == null) return true;
		// one of p and q is null
		if (p == null || q == null) return false;
		
		// do the inorder to the list
		while (p != null || !stack.empty()) {
			while (p!=null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			list.add(p.val);
			p = p.right;
		}
		for (Integer k: list) 
			System.out.print(k + " ");
		
		stack.removeAllElements();
		int i = 0;
		// do inorder traversal to tree q and compare to the list of in order traversal tree p
		while (q != null || !stack.empty()) {
			while (q!=null) {
				stack.push(q);
				q = q.left;
			}
			q = stack.pop();
			if (list.get(i) != q.val) 
				return false;
			
			i++;
			
			q = q.right;
		} 
		return true;
    }
	// Method 2: recursion  
	// time: O(n), space complexity  O(N) in worst case of completely unbalance
	// tree and in best case is: O(log(n))
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		// p and q are null
		if (p == null && q == null) return true;
		// one of p and q is null
		if (p == null || q == null) return false;
		
		if (p.val != q.val) return false;
		
		return (isSameTree2(p.left, q.left) && isSameTree(p.right, q.right));
	}
	// Method 3: Iteration.
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (!check(p, q)) return false;

		// init deques
		ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
		ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
		deqP.addLast(p);
		deqQ.addLast(q);

		while (!deqP.isEmpty()) {
		  p = deqP.removeFirst();
		  q = deqQ.removeFirst();

		  if (!check(p, q)) return false;
		  if (p != null) {
			// in Java nulls are not allowed in Deque
			if (!check(p.left, q.left)) return false;
			if (p.left != null) {
			  deqP.addLast(p.left);
			  deqQ.addLast(q.left);
			}
			if (!check(p.right, q.right)) return false;
			if (p.right != null) {
			  deqP.addLast(p.right);
			  deqQ.addLast(q.right);
			}
		  }
		}
		return true;
	}
	public static void main(String[] args) {
		SameTree_LC0100 sameTree = new SameTree_LC0100();
		
		TreeNode p1 = new TreeNode(1);
		p1.left = new TreeNode(2);
		p1.right = new TreeNode(3);
		TreeNode q1 = new TreeNode(1);
		q1.left = new TreeNode(2);
		q1.right = new TreeNode(3);
		
		TreeNode p2 = new TreeNode(1);
		p2.left = new TreeNode(2);
		TreeNode q2 = new TreeNode(1);
		q2.right = new TreeNode(2);
		
		TreeNode p3 = new TreeNode(1);
		p3.left = new TreeNode(2);
		p3.right = new TreeNode(1);
		TreeNode q3 = new TreeNode(1);
		q3.left = new TreeNode(1);
		q3.right = new TreeNode(2);
		
		System.out.println("Test1: " + sameTree.isSameTree(p1, q1));
		System.out.println("Test2: " + sameTree.isSameTree(p2, q2));
		System.out.println("Test3: " + sameTree.isSameTree(p3, q3));
		
	}
}
