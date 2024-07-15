/*
	https://leetcode.com/problems/odd-even-linked-list/
	Odd Even Linked List - LeetCode #328
	
	Given a singly linked list, group all odd nodes together followed by the even 
	nodes. Please note here we are talking about the node number and not the value 
	in the nodes.

	You should try to do it in place. The program should run in O(1) space complexity 
	and O(nodes) time complexity.

	Example 1:
		Input: 1->2->3->4->5->NULL
		Output: 1->3->5->2->4->NULL
	
	Example 2:
		Input: 2->1->3->5->6->4->7->NULL
		Output: 2->3->6->7->1->5->4->NULL
		 

	Constraints:
	-	The relative order inside both the even and odd groups should remain as 
		it was in the input.
	-	The first node is considered odd, the second node even and so on ...
	-	The length of the linked list is between [0, 10^4].
**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
	Solution Reference:
		https://www.youtube.com/watch?v=C_LA6SOwVTM
*/

public class OddEvenLinkedList_LC328 {
	public static void main(String[] args) {
		OddEvenLinkedList_LC328 oell = new OddEvenLinkedList_LC328();
		
		ListNode tail1, tail2;
		ListNode test1 = new ListNode(1);
		tail1 = test1;
		tail1.next = new ListNode(2);
		tail1 = tail1.next;
		tail1.next = new ListNode(3);
		tail1 = tail1.next;
		tail1.next = new ListNode(4);
		tail1 = tail1.next;
		tail1.next = new ListNode(5);
		tail1 = tail1.next;	
		
		ListNode test2 = new ListNode(2);
		tail2 = test2;
		tail2.next = new ListNode(1);
		tail2 = tail2.next;
		tail2.next = new ListNode(3);
		tail2 = tail2.next;	
		tail2.next = new ListNode(5);
		tail2 = tail2.next;
		tail2.next = new ListNode(6);
		tail2 = tail2.next;
		tail2.next = new ListNode(4);
		tail2 = tail2.next;	
		tail2.next = new ListNode(7);
		tail2 = tail2.next;
		
		ListNode ans1 = oell.oddEvenList(test1);
		
		while (ans1!= null) {
			System.out.print(" " + ans1.val);
			ans1 = ans1.next;
		} 
	}
    public ListNode oddEvenList(ListNode head) {
		if (head == null) return head;
		
		ListNode  odd = head, even = head.next,  evenhead = even;
		
		while ( even != null && even.next != null ){
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		
		odd.next = evenhead;
		
		return head;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}