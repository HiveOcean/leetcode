/*
	https://leetcode.com/problems/reverse-linked-list/
	Reverse Linked List - LeetCode #206

	Reverse a singly linked list.

	Example:
		Input: 1->2->3->4->5->NULL
		Output: 5->4->3->2->1->NULL
	
	Follow up:
		A linked list can be reversed either iteratively or recursively. 
		Could you implement both?

**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
*/
 
public class ReverseLinkedList_LC206 {
	public static void main(String[] args) {
		ListNode tailTest;
		ListNode test = new ListNode(1);
		tailTest = test;
		tailTest.next = new ListNode(2);
		tailTest = tailTest.next;
		tailTest.next = new ListNode(3);
		tailTest = tailTest.next;
		tailTest.next = new ListNode(4);
		tailTest = tailTest.next;
		ListNode n = reverseList(test);
		
		while (n!= null) {
			System.out.print(" " + n.val);
			n = n.next;
		} 
	}
    public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
    }
	
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { 
		this.val = val; this.next = next; 
	}
}