"""
108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the
two subtrees of every node never differs by more than one.


Example 1:

		      0
		     / \
		   -3   9
		   /   /
		 -10  5

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:


		      0
		     /  \
		   -10   5
                     \     \
                     -3     9


Example 2:

        3         1
       /           \
      1             3

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


Constraints:

1 <= nums.length <= 10**4
-10**4 <= nums[i] <= 10**4
nums is sorted in a strictly increasing order.

https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
The idea is to find the middle element of the array and make it the root of
the tree, then perform the same operation on the left subarray for the root’s
left child and the same operation on the right subarray for the root’s right
child.
Follow the steps mentioned below to implement the approach:

Set The middle element of the array as root.
Recursively do the same for the left half and right half.
Get the middle of the left half and make it the left child of the root created in step 1.
Get the middle of the right half and make it the right child of the root created in step 1.
Print the preorder of the tree.
"""
from typing import Optional
from queue import Queue

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class ConvertSortedArrayToBST_LC108:
    # Method 1:
    def sortedArrayToBST(self, nums: list[int]) -> Optional[TreeNode]:
        # base case
        if not nums:
            return None
        
        # make the middle element the root
        # midpoint = left + (right - left) /2;
        mid = (len(nums)) // 2 
        root = TreeNode(nums[mid])

        # left subtree of root has all the values < nums[mid]
        root.left = self.sortedArrayToBST(nums[:mid])

        # right subtree of root has all values > nums[mid]
        root.right = self.sortedArrayToBST(nums[mid+1:])

        return root
    
    # Method 2:
    def sortedArrayToBST2(self, nums: list[int]) -> Optional[TreeNode]:
        if len(nums) == 0:
            return None
        return self.constructBST(nums, 0, len(nums)-1)

    def constructBST(self, nums: list[int], left: int, right: int) -> TreeNode:
        if left > right:
            return None
        
        midpoint = left + (right - left) // 2
        root = TreeNode(nums[midpoint])
        root.left = self.constructBST(nums, left, midpoint -1)
        root.right = self.constructBST(nums, midpoint + 1, right)
        return root
    
    # traversal of the BST
    def preOrder(self, node: TreeNode) -> None:
        if not node:
            return
        
        print(node.val)
        self.preOrder(node.left)
        self.preOrder(node.right)

    # traversal of BST Level order
    def printLevelOrder(self, root: TreeNode) -> None:
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
    
    # traversal of BST level order using Queue
    def printLevelOrder2(self, root: TreeNode) -> None:
        if root is None:
            return

        queue = Queue()
        queue.put(root)

        while (not queue.empty()):
            node = queue.get()
            if node == None:
                continue
            print(node.val, end =" ")
            queue.put(node.left)
            queue.put(node.right)

        



myTest = ConvertSortedArrayToBST_LC108()

input1 = [-10,-3,0,5,9]
root = myTest.sortedArrayToBST(input1)
print("PreOrder traversal:")
myTest.preOrder(root)
print("Level order traversal:")
#myTest.printLevelOrder(root)
myTest.printLevelOrder2(root)

print("\nMethod 2:")
root2 = myTest.sortedArrayToBST2(input1)
myTest.preOrder(root2)
#myTest.printLevelOrder(root2)
myTest.printLevelOrder2(root2)
