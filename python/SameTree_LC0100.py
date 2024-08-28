"""
100. Same Tree

Given the roots of two binary trees p and q, write a function to check if
they are the same or not.

Two binary trees are considered the same if they are structurally identical,
and the nodes have the same value.

Example 1

        (1)               (1)
      /     \           /     \
    (2)     (3)       (2)     (3)

Input: p = [1,2,3], q = [1,2,3]
Output: true      

Example 2
        (1)               (1)
      /                       \
    (2)                       (2)

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3

        (1)               (1)
      /     \           /     \
    (2)     (1)       (1)     (2)

Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:

The number of nodes in both trees is in the range [0, 100].
-10**4 <= Node.val <= 10**4


"""
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class SameTree_LC0100:
    def isSameTree1(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # DFS: Preorder Traverse
        #  visit Root, Left,subTree, Right subTree
        if p == None and q == None:
            return True

        if p == None or q == None:
            return False

        if p.val != q.val:
            return False

        return self.isSameTree1(p.left, q.left) and self.isSameTree1(p.right, q.right)


myTest = SameTree_LC0100()

p1 = TreeNode(1)
p1.left = TreeNode(2)
p1.right = TreeNode(3)
q1 = TreeNode(1)
q1.left = TreeNode(2)
q1.right = TreeNode(3)
print("p1 and q1 are the same tree? ", myTest.isSameTree1(p1, q1))
 
p2 = TreeNode(1)
p2.left = TreeNode(2)
q2 = TreeNode(1)
q2.right = TreeNode(2)
print("p2 and q2 are the same tree? ", myTest.isSameTree1(p2, q2))

p3 = TreeNode(1)
p3.left = TreeNode(2)
p3.right = TreeNode(1)
q3 = TreeNode(1)
q3.left = TreeNode(1)
q3.right = TreeNode(2)
print("p3 and q3 are the same tree? ", myTest.isSameTree1(p3, q3))
