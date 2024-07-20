/*
	https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
	559. Maximum Depth of N-ary Tree
	
	Given a n-ary tree, find its maximum depth.

	The maximum depth is the number of nodes along the longest path from 
	the root node down to the farthest leaf node.

	Nary-Tree input serialization is represented in their level order 
	traversal, each group of children is separated by the null value 
	(See examples).

	Example 1:
								(1)
						    /    |    \
						  (3)   (2)   (4)
						 /  \
					   (5)  (6)

		Input: root = [1,null,3,2,4,null,5,6]
		Output: 3

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


		Input: root = [1,null,2,3,4,5,
						null,null,6,7,null,8,null,9,10,
						null,null,11,null,12,null,13,null,null,14]
		Output: 5
 
	Constraints:
		The total number of nodes is in the range [0, 10^4].
		The depth of the n-ary tree is less than or equal to 1000.
	
	Solution:
	https://www.geeksforgeeks.org/depth-n-ary-tree/
	
*/
import java.util.*;

public class MaximumDepthOfN_aryTree_LC0559 {
    public int maxDepth(Node root) {
		if (root == null)
			return 0;
		
		int maxdepth = 0;
		if (root.children != null) {
			for (Node node: root.children)
				maxdepth = Math.max(maxdepth, maxDepth(node));
        }
		return maxdepth + 1;
    }
	public static void main(String[] args) {
		MaximumDepthOfN_aryTree_LC0559 n_aryTree = new MaximumDepthOfN_aryTree_LC0559();
		
		Node root1 = new Node(1);
		root1.children = new ArrayList<>();
		(root1.children).add(new Node(3));
		root1.children.add(new Node(2));
		root1.children.add(new Node(4));
		root1.children.get(0).children = new ArrayList<>();
		root1.children.get(0).children.add(new Node(5));
		root1.children.get(0).children.add(new Node(6));
		
		System.out.println("Depth of Tree 1: " + n_aryTree.maxDepth(root1));
		
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
		
		System.out.println("Depth of Tree 2: " + n_aryTree.maxDepth(root2));
	}
}

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
}