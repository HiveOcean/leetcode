/*
	https://leetcode.com/problems/remove-linked-list-elements/
	RemoveLinkedListElements - LeetCode #203
	
	Remove all elements from a linked list of integers that have value val.

	Example:
		Input:  1->2->6->3->4->5->6, val = 6
		Output: 1->2->3->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
	Test case:
	1. element is the head of the list.
	2. element is the tail of the list.
	3. element appears more than once, not in consecutive elements.
	4. element appears in consecutive list elements.
*/
public class RemoveLinkedListElements_LC203 {
	public static void main(String[] args) {
		ListNode tail1;
		ListNode test1 = new ListNode(1);
		tail1 = test1;
		tail1.next = new ListNode(2);
		tail1 = tail1.next;
		tail1.next = new ListNode(6);
		tail1 = tail1.next;
		tail1.next = new ListNode(3);
		tail1 = tail1.next;
		tail1.next = new ListNode(3);
		tail1 = tail1.next;
		tail1.next = new ListNode(3);
		tail1 = tail1.next;
		tail1.next = new ListNode(9);
		tail1 = tail1.next;
		tail1.next = new ListNode(6);
		tail1 = tail1.next;
		
		ListNode n = removeElements(test1,3);
		while (n!= null) {
			System.out.print(" " + n.val);
			n = n.next;
		} 
	}
    public static ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
		ListNode prev = head;
		ListNode nodeHead = head;
		
		while (current != null) {
			if (current.val == val) {
				if (current == nodeHead) {
					nodeHead = current.next;		
					current = current.next;
					prev = current;
				} else {
					current = current.next;
					prev.next = current;
				}
			} else {
				prev = current;
				current = current.next;
			}
		}
		return nodeHead;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}