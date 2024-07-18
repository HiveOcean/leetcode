/*
	https://leetcode.com/problems/sum-of-left-leaves/
	404. Sum of Left Leaves
	
	Given the root of a binary tree, return the sum of all left leaves.

 

	Example 1:
						(3)
					  /		\
					(9)    (20)
						   /  \
						 (15) (7)

		Input: root = [3,9,20,null,null,15,7]
		Output: 24
		Explanation: There are two left leaves in the binary tree, with 
		values 9 and 15 respectively.
		
	Example 2:
		Input: root = [1]
		Output: 0
		 
	Constraints:
		The number of nodes in the tree is in the range [1, 1000].
		-1000 <= Node.val <= 1000

	Related topics:
		Tree, Depth-First Search, Breadth-First Search, Binary Tree	
		
*/
import java.util.*;

public class SumOfLeftLeaves_LC0404 {
    public int sumOfLeftLeaves1(TreeNode root) {
        int sum = 0;
		
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.pop();
			
			if (node.left != null){
				sum += node.left.val;
				queue.push(node.left);
			}
			if (node.right != null)
				queue.push(node.right);		
		}
		return sum;
    }
	public static void main(String[] args) {
		SumOfLeftLeaves_LC0404 sumLeaves = new SumOfLeftLeaves_LC0404();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		
		System.out.println("Tree1: " + sumLeaves.sumOfLeftLeaves1(t1));
		
		TreeNode t2 = new TreeNode(1);
		System.out.println("Tree1: " + sumLeaves.sumOfLeftLeaves1(t2));
		
		TreeNode t3 = new TreeNode(1);
		t3.right = new TreeNode(2);
		System.out.println("Tree13 " + sumLeaves.sumOfLeftLeaves1(t3));
	}
}	