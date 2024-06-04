/*
	https://leetcode.com/problems/merge-two-sorted-lists/
	Merge Two Sorted Lists - LeetCode # 21 Easy
	
	Merge two sorted linked lists and return it as a new sorted list. The new 
	list should be made by splicing together the nodes of the first two lists.
	
	Example 1:
		Input:
		l1 = [1, 2, 4], l2 = [1, 3, 4]
		Output:
		[1, 1, 2, 3, 4, 4]
	
	Example 2:
		Input: l1 = [], l2 = []
		Output: []
		
	Example 3:
		Input: l1 = [], l2 = [0]
		Output: [0]
		
	Constraints:
		The number of nodes in both lists is in the range [0, 50].
		-100 <= Node.val <= 100
		Both l1 and l2 are sorted in non-decreasing order.
		
	
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 
*/
import java.util.*;

public class MergeTwoSortedLists_LC021 {
	public static void main(String[] args) {
		
		ListNode tail1, tail4, merged;
		
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
		tail4 = tail4.next;
		tail4.next = new ListNode(3);
		tail4 = tail4.next;
		tail4.next = new ListNode(11);
		tail4 = tail4.next;
		tail4.next = new ListNode(35);
		tail4 = tail4.next;
		tail4.next = new ListNode(40);
		tail4 = tail4.next;
		
		merged = mergeTwoLists(l1, l4); 
		while (merged != null) {
			System.out.print(" " + merged.val);
			merged = merged.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), tail;
		tail = ans;
		int val1, val2, noValue = -1000;
		
		while (l1 != null || l2 != null) {
			
			if (l1 == null) {
				tail.next = new ListNode(l2.val);			
				l2 = l2.next;
			} else if (l2 == null) {
				tail.next = new ListNode(l1.val);			
				l1 = l1.next;
			} else {
				if (l1.val <= l2.val) {
					tail.next = new ListNode(l1.val);				
					l1 = l1.next;
				} else {
					tail.next = new ListNode(l2.val);
					l2 = l2.next;
				}	
			}
			tail = tail.next;	
		}
		
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