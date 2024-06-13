/*
	https://leetcode.com/problems/linked-list-cycle/
	Linked List Cycle - LeeCode #141 Easy
	Given head, the head of a linked list, determine if the linked list has a cycle in it.

	There is a cycle in a linked list if there is some node in the list that can be 
	reached again by continuously following the next pointer. Internally, pos is used 
	to denote the index of the node that tail's next pointer is connected to. Note 
	that pos is not passed as a parameter.

	Return true if there is a cycle in the linked list. Otherwise, return false.

	Example 1:
		(3) --> (2) --> (0) --> (4)
				 ^			 	  |
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
*/


public class LinkedListCycle_LC141 {
	public static void main(String[] args) {
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
	}
    public static boolean hasCycle(ListNode head) {
		if (head == null) return false;
		
		int pos = 0,totalNode = 0;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while ( fast != null && fast.next != null ) {
			fast = fast.next.next;
			slow = slow.next;		
			if (fast == slow) {
				return true;	
			}
		}
        return false;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}