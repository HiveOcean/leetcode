/*
	https://leetcode.com/problems/add-two-numbers/
	Add Two Numbers - LeetCode 002 Medium
	
	You are given two non-empty linked lists representing two non-negative 
	integers. The digits are stored in reverse order, and each of their nodes 
	contains a single digit. Add the two numbers and return the sum as a 
	linked list.

	You may assume the two numbers do not contain any leading zero, except 
	the number 0 itself.

	Example 1:	
		2 -> 4 -> 3
		5 -> 6 -> 4
	--------------------
		7 -> 0 -> 8
		
		Input: list1 = [2,4,3], list2 = [5,6,4]
		Output: [7,0,8]
		Explanation: 342 + 465 = 807
		
	Example 2:
		Input: list1 = [0], list2 = [0]
		Output: [0]
		
	Example 3:
		Input: list1 = [9,9,9,9,9,9,9], list2 = [9,9,9,9]
		Output: [8,9,9,9,0,0,0,1]
		
	Constraints:

	* The number of nodes in each linked list is in the range [1, 100].
	* 0 <= Node.val <= 9
	* It is guaranteed that the list represents a number that does not have 
	  leading zeros.
	  

	* Definition for singly-linked list.
	* public class ListNode {
	*     int val;
	*     ListNode next;
	*     ListNode() {}
	*     ListNode(int val) { this.val = val; }
	*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	* }
	 
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			
		}
	}
*/
import java.util.*;

public class AddTwoNumbers_LC002 {
	public static void main(String[] args) {
		
		ListNode tail1, tail2;
		
		ListNode l1 = new ListNode(2);
		tail1 = l1;
		tail1.next = new ListNode(4);
		tail1 = tail1.next;
		tail1.next = new ListNode(3);
		tail1 = tail1.next;
		
		ListNode l2 = new ListNode(5);
		tail2 = l2;
		tail2.next = new ListNode(6);
		tail2 = tail2.next;
		tail2.next = new ListNode(4);
		tail2 = tail2.next;
		tail2.next = new ListNode(8);
		tail2 = tail2.next;
		
		ListNode n = addTwoNumbers(l1, l2);
		while (n != null) {
			System.out.print(" " + n.val);
			n = n.next;
		}
		System.out.println();
		
		ListNode tail3, tail4;
		
		ListNode l3 = new ListNode(9);
		tail3 = l3;
		tail3.next = new ListNode(9);
		tail3 = tail3.next;
		tail3.next = new ListNode(9);
		tail3 = tail3.next;
		tail3.next = new ListNode(9);
		tail3 = tail3.next;
		
		ListNode l4 = new ListNode(9);
		tail4 = l4;
		tail4.next = new ListNode(9);
		tail4 = tail4.next;
		tail4.next = new ListNode(9);
		tail4 = tail4.next;
		tail4.next = new ListNode(9);
		tail4 = tail4.next;
		tail4.next = new ListNode(9);
		tail4 = tail4.next;
		tail4.next = new ListNode(9);
		tail4 = tail4.next;
		tail4.next = new ListNode(9);
		tail4 = tail4.next;
		
		ListNode m = addTwoNumbers(l3, l4);
		while (m != null) {
			System.out.print(" " + m.val);
			m = m.next;
		}
		
	}
	public static ListNode addTwoNumbers(ListNode current1, ListNode current2) {
		
		ListNode ans = new ListNode(0), tail;
		tail = ans;
		
		int current_sum, carry_over = 0, nodeSum, val1 = 0, val2 = 0;
		
		while (current1 != null || current2 != null) {
			if (current1 != null) {
				val1 = current1.val;
				current1 = current1.next;
			} else
				val1 = 0;
			
			if (current2 != null) {
				val2 = current2.val;
				current2 = current2.next;
			} else
				val2 = 0;
			
			current_sum = val1 + val2 + carry_over;
			carry_over = current_sum / 10;
			nodeSum = current_sum % 10;
			
			tail.next = new ListNode(nodeSum);
			tail = tail.next;			
		}	

		if (carry_over > 0) {
			tail.next = new ListNode(carry_over);
			tail = tail.next;
		}
		// the head of ans is a dummy, so we don't need it.
		return ans.next;	
	}
	
}
class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}