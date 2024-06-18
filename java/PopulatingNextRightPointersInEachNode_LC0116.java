/*
	https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	116. Populating Next Right Pointers in Each Node
	

	You are given a perfect binary tree where all leaves are on the same 
	level, and every parent has two children. The binary tree has the 
	following definition:

		struct Node {
		  int val;
		  Node *left;
		  Node *right;
		  Node *next;
		}
	Populate each next pointer to point to its next right node. If there 
	is no next right node, the next pointer should be set to NULL.

	Initially, all next pointers are set to NULL.

		 

	Example 1:
					(1)						   (1)->null
				  /		\					/		\
				(2)		(3)				  (2) ---->	(3)-> null
			   /   \    /   \			  /  \	   /   \
			 (4)   (5) (6)  (7)			(4)->(5)->(6)->(7)-> null
			 

		Input: root = [1,2,3,4,5,6,7]
		Output: [1,#,2,3,#,4,5,6,7,#]
		Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
		
	Example 2:

		Input: root = []
		Output: []
		 

	Constraints:
		The number of nodes in the tree is in the range [0, 2^12 - 1].
		-1000 <= Node.val <= 1000
		 

	Follow-up:
		You may only use constant extra space.
		The recursive approach is fine. You may assume implicit stack 
		space does not count as extra space for this problem
			
	
*/
import java.util.*;

public class PopulatingNextRightPointersInEachNode_LC0116 {
	// X Method 1: iterative Level Order Traversal BFS  // not constant extra space?
    public Node connect(Node root) {
		
		if (root == null) return null;
		
		Queue<Node> queue = new LinkedList<>();
		Node prev = null;
		Node node = null;
		
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				node = queue.poll();
					
				if (prev == null) {
					prev = node;
				} else {
					prev.next = node;
					prev = node;
				}
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				size--;
			}
			node.next = null;
			prev = null;
			
		}
        return root;
    }
	// Method 2: from leetcode solution
	public Node connect2(Node root) {
		if (root == null) return null;
		
		Node prev = root;
		Node cur = null;
		
		while (prev.left != null) {
			cur = prev;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) 
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			prev = prev.left;
		}
		return root;
	} 
	// Method 3: iternative using constant extra space.
	// https://www.youtube.com/watch?v=FrD3_PXwhj0
	// time complexity O(n), space O(1)
	public Node connect3(Node root) {
		
		if (root == null)
			return null;
		
		// Start with the first level (root's next is already null)
		Node current = root;
		
		// Start work beginning on the second and onward
		while (current.left != null ) {
			//keep track of the beginning of the next level
			Node nextLevelHead = current.left;
			
			// for each node on this level, populate the next pointer of the next level (it's children)
			while (current != null) {
				current.left.next = current.right;
				
				if (current.next == null) {
					current.right.next = null;
				} else {
					current.right.next = current.next.left;
				}
				// move the next node on this level
				current = current.next;
			}
			// move to the next level
			current = nextLevelHead;
		}
		return root;
	}
	private void printNextNode(Node node) {
		Queue<Node> queue = new LinkedList<>();
		Node n = null;
		
		queue.add(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				n = queue.poll();
				if (n.next != null)
					System.out.print(n.val + " ");
				else
					System.out.print(n.val + " # ");
				size--;
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode_LC0116 nextRight = new PopulatingNextRightPointersInEachNode_LC0116();
		
		Node t1 = new Node(1);
		t1.left = new Node(2);
		t1.right = new Node(3);
		t1.left.left = new Node(4);
		t1.left.right = new Node(5);
		t1.right.left = new Node(6);
		t1.right.right = new Node(7);
		
		nextRight.printNextNode(t1);
		nextRight.connect3(t1);
		nextRight.printNextNode(t1);
	}
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}
		
		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}
