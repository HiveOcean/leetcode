/*
	https://leetcode.com/problems/middle-of-the-linked-list/
	LeetCode 876. Given the 'head' of a singly linked list, return the 'middle' node of 
	the linked list.

	If there are two middle nodes, return the 'second middle node'.
	
	Example 1:
			(1) -> (2) -> (3) -> (4) -> (5)

		Input: head = [1,2,3,4,5]
		Output: [3,4,5]
		Explanation: The middle node of the list is node 3.
		
	Example 2:
			(1) -> (2) -> (3) -> (4) -> (5) ->  (6)
		
		Input: head = [1,2,3,4,5,6]
		Output: [4,5,6]
		Explanation: Since the list has two middle nodes with values 3 and 4, we 
		return the second one.
		 
	Constraints:

		The number of nodes in the list is in the range [1, 100].
		1 <= Node.val <= 100
	
	Related Topics:
		Linked List, Two Pointers
		
	Time Complexity: O(N), where N is the number of nodes in the given list.

	Space Complexity: O(1), the space used by slow and fast.

*/
import java.util.*;

public class MiddleOfTheLinkedList_LC0876 {
    public ListNode middleNode(ListNode head) {
        ListNode slownode = head, fastnode = head;
		
		if (head.next == null)
			return slownode;
		
		fastnode = head.next;
		
		System.out.println(slownode.val + " " +fastnode.val);
		while (fastnode != null) {
			slownode = slownode.next;
			fastnode = fastnode.next;
			if (fastnode != null)
				fastnode = fastnode.next;
		}
		
		
		return slownode;
    }
	public static void main(String[] args) {
		MiddleOfTheLinkedList_LC0876 findmiddle = new MiddleOfTheLinkedList_LC0876();
		
		ListNode root1 = new ListNode(1);
		root1.next = new ListNode(2);
		root1.next.next = new ListNode(3);
		root1.next.next.next = new ListNode(4);
		root1.next.next.next.next = new ListNode(5);
		
		ListNode root2 = new ListNode(1);
		root2.next = new ListNode(2);
		root2.next.next = new ListNode(3);
		root2.next.next.next = new ListNode(4);
		root2.next.next.next.next = new ListNode(5);
		root2.next.next.next.next.next = new ListNode(6);
		
		ListNode ans = findmiddle.middleNode(root1);
		System.out.println(ans.val);
		
		ListNode ans2 = findmiddle.middleNode(root2);
		System.out.println(ans2.val);
	}
}
/*
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { 
		this.val = val; 
	}
	ListNode(int val, ListNode next) {
		this.val = val; 
		this.next = next; 
	}
}