"""
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a
cycle in it.

There is a cycle in a linked list if there is some node in the list that
can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next
pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
		(3) --> (2) --> (0) --> (4)
				 ^		|
				 ^----------------
		
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
	
Example 2:
		(1) --> (2)
		 ^		 |
		 ^-------

    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
	
Example 3:
		(1)

    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.
	 

Constraints:
    The number of the nodes in the list is in the range [0, 10e4].
    -10e5 <= Node.val <= 10e5
    pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?
        
"""
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class LinkedListCycle_LC141:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        slowNode = head
        fastNode = head.next

        while fastNode != None and fastNode.next != None:
            if fastNode == slowNode:
                return True
            fastNode = fastNode.next.next
            slowNode = slowNode.next

        return False


myTest = LinkedListCycle_LC141()

list1 = None
print("list1 is cycled? ", myTest.hasCycle(list1))

list2 = ListNode(3)
list2.next = ListNode(2)
list2.next.next = ListNode(0)
list2.next.next.next = ListNode(4)
list2.next.next.next = list2.next.next
print("list2 is cycled? ", myTest.hasCycle(list2))

list3 = ListNode(1)
list3.next = ListNode(2)
list3.next.next = list3
print("list3 is cycled? ", myTest.hasCycle(list3))

list4 = ListNode(1)
print("list4 is cycled? ", myTest.hasCycle(list4))

"""
ListNode tail1, tail4, node2;
		
		ListNode l1 = new ListNode(-3);
		tail1 = l1;
		tail1.next = new ListNode(1);
		tail1 = tail1.next;
		tail1.next = new ListNode(11);
		tail1 = tail1.next;
		
		ListNode l4 = new ListNode(-10);
		tail4 = l4;
		tail4.next = new ListNode(-4);
		tail4 = tail4.next;
		tail4.next = new ListNode(0);
		node2 = tail4.next;
		tail4 = tail4.next;
		tail4.next = new ListNode(3);
		tail4 = tail4.next;
		tail4.next = new ListNode(11);
		tail4 = tail4.next;
		tail4.next = new ListNode(35);
		tail4 = tail4.next;
		tail4.next = new ListNode(40);
		tail4 = tail4.next;
		tail4.next = node2;
		
		System.out.println(" list1 has cycle: " + hasCycle(l1) );
		System.out.println(" list2 has cycle: " + hasCycle(l4) );
"""
