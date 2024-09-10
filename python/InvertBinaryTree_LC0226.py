"""
226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
			   (4)				(4)
			/	\		    /	      \
		     (2)	(7)		 (7)	       (2)
		    /    \	/   \		/   \	     /	   \
		  (1)   (3)  (6)    (9)      (9)     (6)   (3)	   (1)

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
		
Example 2:
		     (2)	       (2)
		    /	\	     /	  \
		(1)	(3)	    (3)	  (1)

Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
 

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

"""
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class InvertBinaryTree_LC226:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root == None:
            return

        tmp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(tmp)
        
        return root

    def printTree(self, root: TreeNode) -> None:
        
        if root is None:
            return

        queue = []
        queue.append(root)
        while(len(queue) > 0):
            # print front of the queue and remove it from queue
            print(queue[0].val, end=" ")
            node = queue.pop(0)

            # enqueue left child
            if node.left is not None:
                queue.append(node.left)

            # enqueue right child
            if node.right is not None:
                queue.append(node.right)
        print('\n')
myTest = InvertBinaryTree_LC226()

Input1 = [4,2,7,1,3,6,9]
t1 = TreeNode(4)
t1.left = TreeNode(2)
t1.left.left = TreeNode(1)
t1.left.right = TreeNode(3)
t1.right = TreeNode(7);
t1.right.left = TreeNode(6);
t1.right.right = TreeNode(9);
myTest.printTree(t1)
myTest.invertTree(t1)
myTest.printTree(t1)

t2 = TreeNode(2)
t2.left = TreeNode(1)
t2.right = TreeNode(3)

myTest.printTree(t2)
myTest.invertTree(t2)
myTest.printTree(t2)
