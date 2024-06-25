/*
	https://leetcode.com/problems/palindrome-linked-list/
	Palindrome Linked List - LeetCode #234 Easy
	
	Given a singly linked list, determine if it is a palindrome.

	Example 1:
		Input: 1->2
		Output: false

	Example 2:
		Input: 1->2->2->1
		Output: true

	Follow up:
		Could you do it in O(n) time and O(1) space?


	Definition for singly-linked list.
	  public class ListNode {
		  int val;
		  ListNode next;
		  ListNode() {}
		  ListNode(int val) { this.val = val; }
		  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
*/
import java.util.*;

public class PalindromeLinkedList_LC234 {
	public static void main(String[] args) {
		ListNode tail1, tail4, merged;
		
		ListNode l1 = new ListNode(3);
		tail1 = l1;
		tail1.next = new ListNode(1);
		tail1 = tail1.next;
		tail1.next = new ListNode(3);
		tail1 = tail1.next;
		
		ListNode l4 = new ListNode(-10);
		tail4 = l4;
		tail4.next = new ListNode(-4);
		tail4 = tail4.next;
		tail4.next = new ListNode(11);
		tail4 = tail4.next;		
		tail4.next = new ListNode(11);
		tail4 = tail4.next;
		tail4.next = new ListNode(-4);
		tail4 = tail4.next;
		tail4.next = new ListNode(-10);
		tail4 = tail4.next;
		
		System.out.println(isPalindrome(l4));
		
		ListNode tail5;
		ListNode l5 = new ListNode(1);
		tail5 = l5;
		tail5.next = new ListNode(2);
		tail5 = tail5.next;
		System.out.println(isPalindrome(l5));
		/* test the reverse function
		//System.out.println(isPalindrome(l1));
		ListNode tailTest;
		ListNode test = new ListNode(1);
		tailTest = test;
		tailTest.next = new ListNode(2);
		tailTest = tailTest.next;
		tailTest.next = new ListNode(3);
		tailTest = tailTest.next;
		tailTest.next = new ListNode(4);
		tailTest = tailTest.next;
		ListNode n = reversed(test);
		
		while (n!= null) {
			System.out.print(" " + n.val);
			n = n.next;
		} 
		*/
	}
	/* solution by Nick White
		https://www.youtube.com/watch?v=wk4QsvwQwdQ
	*/
	public static boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		// after the below, slow should point to first node of second half
		// i.e 123321, slow is at the second 3 after this loop
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}	
		
		slow = reversed(slow);	// passed the second half of the list to do reverse i.e 321
		fast = head;
		
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			
			slow = slow.next;
			fast = fast.next;
		}
		
		
        return true;
    }
	public static ListNode reversed(ListNode head) {
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
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}