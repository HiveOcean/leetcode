/*
	https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
	117. Populating Next Right Pointers In Each Node II
	
	Given a binary tree

		struct Node {
		  int val;
		  Node *left;
		  Node *right;
		  Node *next;
		}
		
	Populate each next pointer to point to its next right node. If there is 
	no next right node, the next pointer should be set to NULL.

	Initially, all next pointers are set to NULL.

		 

	Example 1:
					(1)						   (1)->null
				  /		\					/		\
				(2)		(3)				  (2) ---->	(3)-> null
			   /   \       \			  /  \	      \
			 (4)   (5)     (7)			(4)->(5)----->(7)-> null

		Input: root = [1,2,3,4,5,null,7]
		Output: [1,#,2,3,#,4,5,7,#]
		Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
		
	Example 2:

		Input: root = []
		Output: []
		 
	
	Example 3:
					(1)						   (1)-> null
				  /		\					/		\
				(2)		(3)				  (2) ---->	(3)-> null
			   /          \			  	  /  	      \
			 (4)          (5)			(4)---------> (5)-> null
			   \		  /				  \  		  /
			   (6)		(7)				  (6)------>(7)-> null
						 \
						 (8)
	
		Input: root = [1,2,3,4,null,null,5,null, 6,7,null]
		Output: [1,#,2,3,#,4,5,#,6,7,#]
	Constraints:

		The number of nodes in the tree is in the range [0, 6000].
		-100 <= Node.val <= 100
		 

	Follow-up:
		-You may only use constant extra space.
		-The recursive approach is fine. You may assume implicit stack 
		 space does not count as extra space for this problem.
	
	My note:
	this problem is to only define the next of each node!
	left child cases:
	I:  when parent has both left and right child, the left.next = right
		(1)
		/ \
	  (2)  (3)
	II: when parent has no right child and parent has no sibling, left.next = null
		(1)
		/
	   (2)
	III: when parent has no right child but has sibling. left.next = parent.next.left 
		 or if the parent sibling has no left child, left.next = parent.next.right.
		 Does no matter if parent sibling has no child, the end case left.next = parent.next.right
		 will have left.next point to null if parent.next.right is null.
		(2)-->(3)
		/ 
	  (4)
	right child cases: only care if any node on the right
	I: when parent has no sibling, right.next must be null
		(1)
		/ \
	  (2)  (3)
	II: when parent has sibling, right.next must point to the parent sibling's kid
	    no matter the parent sibling has child or not.  It uncle has left child
		right.next point to the uncle's left child. Otherwise, point to uncle's right
		child.  if uncle also has no right child. it will point to null.
		(2)---------->(3)
		/ \			/    \
	  (4)  (5)---> (6)  (7)
		
*/

import java.util.*;

public class PopulatingNextRightPointersInEachNodeII_LC0117 {
	// Method 1: Level order traversal, but not constant extra space
    public Node connect(Node root) {
		
		if (root == null) return null;
		Queue<Node> queue = new LinkedList<>();
		Node prev = null;
		Node node = null;
		
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();  // number of node in current level
			while (size > 0) {
				node = queue.poll();
					
				if (prev != null) 
					prev.next = node;
					
				prev = node;

				// add next level nodes to the queue
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				size--;
			}
			//node.next = null;  // the rightmost in the level but no need as initially all next point to null
			prev = null;	  // reset for the next level
		}
        return root;
    }
	// Method 2:  use 3 variable: Node leftmost, prev, cur
    public Node connect2(Node root) {
		if (root == null) return root;
		
		Node leftmost = root;
		
		while (leftmost != null) {
			Node cur = leftmost;
			leftmost = null;	// clear this to avoid infinite loop
			Node prev = null;
			
			// process the current level
			while (cur != null) {
				if (cur.left != null) {
					if (leftmost == null) 
						leftmost = cur.left;
				
					if (prev != null)
						prev.next = cur.left;
					
					prev = cur.left;
				}
				if (cur.right != null) {
					if (leftmost == null)
						leftmost = cur.right;
					
					if (prev != null) 
						prev.next = cur.right;
					
					prev = cur.right;
				}
				cur = cur.next;
			}
		}
		return root;
	}		
	// Method 3:
    public Node connect3(Node root) {	
		Node cur = root;
		Node head = root;	// the leftmost node of a level
		
		while (head != null) {
			head = null;	// reset for next level, need to find head of next level in the below loop.
			
			while (cur != null)	{	// for each node in a level
				// find the left.next, right.next and the leftmost of next level
				// the leftmost node can be in left subtree or right subtree if left subtree is empty.
				if (cur.left != null) {  // find head of a level if not exists
					if (head == null)
						head = cur.left;
					
					// the left.next can only be in following cases:
					if (cur.right != null) // left.next point to sibling
						cur.left.next = cur.right;
					else if (cur.next == null)
						cur.left.next = null;	// no other node on the right
					else if (cur.next.left != null)   // left.next should point to cousin
						cur.left.next = cur.next.left;
					else 
						cur.left.next = cur.next.right;
				}
				if (cur.right != null) {  
					if (head == null)		// find head of a level (when no left subtree, then it is in the right subtree)
						head = cur.right;
					
					// the right.next can only be in the following cases:
					if (cur.next == null)		// when parent node's next is null, the right child's next must be null
						cur.right.next = null;	// no other node on the right
					else if (cur.next.left != null)   // left.next should point to uncle's child i.e cousin
						cur.right.next = cur.next.left;	// if uncle has no child, right.next will be null.
					else 
						cur.right.next = cur.next.right;
				}
				cur = cur.next;  // next node in the same level
			}
			cur = head;		// cur move to the next level's leftmost node
		}
		return root;
	}
	private void printNextNode(Node node) {
		if (node != null) {
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
	}	
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII_LC0117 nextRight = new PopulatingNextRightPointersInEachNodeII_LC0117();

		Node t1 = new Node(1);
		t1.left = new Node(2);
		t1.right = new Node(3);
		t1.left.left = new Node(4);
		t1.left.right = new Node(5);
		t1.right.right = new Node(7);
		System.out.println("Tree 1: ");
		nextRight.printNextNode(t1);
		nextRight.connect3(t1);
		nextRight.printNextNode(t1);	

		Node t2 = null;
		System.out.println("Tree 2: ");
		nextRight.printNextNode(t2);
		nextRight.connect3(t2);
		nextRight.printNextNode(t2);
		
		Node t3 = new Node(1);
		t3.left = new Node(2);
		t3.right = new Node(3);
		t3.left.left = new Node(4);
		t3.left.right = new Node(5);
		t3.left.right.left = new Node(8);
		t3.left.right.left.left = new Node(9);
		t3.right.right = new Node(7);
		t3.right.right.right = new Node(10);
		System.out.println("Tree 3: ");
		nextRight.printNextNode(t3);
		nextRight.connect3(t3);
		nextRight.printNextNode(t3);
		
		Node t4 = new Node(1);
		t4.left = new Node(2);
		t4.right = new Node(3);
		t4.left.left = new Node(4);
		t4.left.left.right = new Node(6);
		t4.right.right = new Node(5);
		t4.right.right.left = new Node(7);
		t4.right.right.left.right = new Node(8);
		System.out.println("Tree 4: ");
		nextRight.printNextNode(t4);
		nextRight.connect3(t4);
		nextRight.printNextNode(t4);
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
