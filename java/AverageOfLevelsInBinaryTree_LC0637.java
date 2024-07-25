/*
	https://leetcode.com/problems/average-of-levels-in-binary-tree/
	637. Average of Levels in Binary Tree
	
	Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 

	Example 1:
				 (3)
			   /     \		
			 (9)     (20)	
					/ 	 \
				  (15)   (7)					

		Input: root = [3,9,20,null,null,15,7]
		Output: [3.00000,14.50000,11.00000]
		Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
		Hence return [3, 14.5, 11].
	
	Example 2:
				 (3)
			   /     \		
			 (9)     (20)	
			/ 	 \
		  (15)   (7)

		Input: root = [3,9,20,15,7]
		Output: [3.00000,14.50000,11.00000]
 

	Constraints:
		The number of nodes in the tree is in the range [1, 104].
		-2^31 <= Node.val <= 2^31 - 1

	Related topics:
		Tree, Depth-First Search, Breadth-First Search, Binary Tree

	Solution:
	https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
	
	Method 1: use queue BFS
		Declare two queue, q1, q2.  q1 is to store all node in the current
		level, q2 is to store the child node of every node in q1.  And 
		vary to hold the sum and count of each level.  And a list to 
		store average value of all levels.
			1. push root to Q1.
			2. initialize sum, count as 0.  Q2 as another empty queue.
			3. While Q1 is not empty, 
				4. pop a node out.
				5. increment the sum and count accordingly.
				6. if left of current node is not empty, push it to Q2.
				7. if right of current node is not empty, push it to Q2.
				8. if Q1 is empty
					9. Calculate the average of this level, avg = sum / count
					10. Add avg to the result list.
					11. reset sum, count to 0.
					12. While Q2 is not empty,
							12. pop a node out.
							13. add this node to Q1.
							
	
*/
import java.util.*;

class AverageOfLevelsInBinaryTree_LC0637 {
    public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> temp = new ArrayDeque<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		List<Double> ans = new LinkedList<>();
		Double sum = 0.0, count = 0.0;
		
		queue.add(root);
		while ( !queue.isEmpty() ) {
			TreeNode node = queue.poll();
			sum += node.val;
			count++;
			
			if (node.left != null)
				temp.add(node.left);
			if (node.right != null)
				temp.add(node.right);
			
			if (queue.isEmpty()) {
				Double avg = sum / count;
				ans.add(avg);
				sum = 0.0;
				count = 0.0;
				
				while (!temp.isEmpty()) {
					queue.add(temp.poll());
				}
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree_LC0637 avglevel = new AverageOfLevelsInBinaryTree_LC0637();
		
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		System.out.println("Tree 1: " + avglevel.averageOfLevels(t1).toString());
		
		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(9);
		t2.right = new TreeNode(20);
		t2.left.left = new TreeNode(15);
		t2.left.right = new TreeNode(7);
		System.out.println("Tree 2: " + avglevel.averageOfLevels(t2).toString());
	
		TreeNode t3 = new TreeNode(1);
		t3.left = new TreeNode(2);
		t3.right = new TreeNode(4);
		t3.left.left = new TreeNode(6);
		t3.left.right = new TreeNode(8);
		t3.right.left = new TreeNode(10);
		t3.right.right = new TreeNode(12);
		t3.left.right.left = new TreeNode(20);
		t3.right.right.left = new TreeNode(30);
		t3.right.right.right = new TreeNode(6);
		System.out.println("Tree 3: " + avglevel.averageOfLevels(t3).toString());
	}
}