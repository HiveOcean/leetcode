/*
	https://leetcode.com/problems/intersection-of-two-linked-lists/
	Intersection of Two Linked Lists - LeetCode #160 Easy
	
	Write a program to find the node at which the intersection of two singly 
	linked lists begins.

	For example, the following two linked lists:
			(a1) -> (a2) 
							\
							  -> (c1) -> (c2) -> (c3)
							/
		(b1) -> (b2) -> (b3)
	
	begin to intersect at node c1.
	
	Example 1:
	A:			(4) -> (1) 
							\
							  -> (8) -> (4) -> (5)
							/
	B:	  (5) -> (6) -> (1)
	
	Input: 
		intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], 
		skipA = 2, skipB = 3
	Output: 
		Reference of the node with value = 8
	Input Explanation: 
		The intersected node's value is 8 (note that this must not be 0 if 
		the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. 
		From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before 
		the intersected node in A; There are 3 nodes before the intersected 
		node in B.

	Example 2:
	A:		(1) -> (9) -> (1) 
							\
							  -> (2) -> (4)
							/
	B:	  				  (3)
	
	Input: 
		intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	Output: 
		Reference of the node with value = 2
	Input Explanation: 
		The intersected node's value is 2 (note that this must not be 0 if the two 
		lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the 
		head of B, it reads as [3,2,4]. There are 3 nodes before the intersected 
		node in A; There are 1 node before the intersected node in B.

	Example 3:
	A:		(2) -> (6) -> (4) 
							
	B:	  		   (1) -> (5)
	
	Input:
		intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
	Output: 
		null
	Input Explanation: 
		From the head of A, it reads as [2,6,4]. From the head of B, it reads 
		as [1,5]. Since the two lists do not intersect, intersectVal must be 0, 
		while skipA and skipB can be arbitrary values.
	Explanation: 
		The two lists do not intersect, so return null.
	
	Notes:
	* If the two linked lists have no intersection at all, return null.
	* The linked lists must retain their original structure after the function returns.
	* You may assume there are no cycles anywhere in the entire linked structure.
	* Each value on each linked list is in the range [1, 10^9].
	* Your code should preferably run in O(n) time and use only O(1) memory.
	
	Definition for singly-linked list.
		public class ListNode {
			int val;
			ListNode next;
			ListNode(int x) {
				val = x;
				next = null;
			}
		}
*/
public class IntersectionOfTwoLinkedLists_LC160 {
	public static void main(String[] args) {
		ListNode tail1, tail4, tail5, tail6;
		
		ListNode l1 = new ListNode(3);
		tail1 = l1;
		tail1.next = new ListNode(6);
		tail1 = tail1.next;
		tail1.next = new ListNode(9);
		tail1 = tail1.next;
		tail1.next = new ListNode(15);
		tail1 = tail1.next;
		tail1.next = new ListNode(30);
		tail1 = tail1.next;
		
		
		ListNode l4 = new ListNode(10);
		tail4 = l4;
		tail4.next = new ListNode(15);
		tail4 = tail4.next;
		tail4.next = new ListNode(30);
		tail4 = tail4.next;
		
		ListNode l5 = new ListNode(2);
		tail5 = l5;
		tail5.next = new ListNode(10);
		tail5 = tail5.next;
		tail5.next = new ListNode(4);
		tail5 = tail5.next;
		
		ListNode l6 = new ListNode(3);
		tail6 = l6;
		tail6.next = new ListNode(7);
		tail6 = tail6.next;
		tail6.next = new ListNode(11);
		tail6 = tail6.next;
		tail6.next = new ListNode(4);
		tail6 = tail6.next;
		tail6.next = new ListNode(6);
		tail6 = tail6.next;
		tail6.next = new ListNode(8);
		tail6 = tail6.next;
		
		ListNode intersectNode = getIntersectionNode(l1, l4);
		if (intersectNode != null) {
			System.out.println("The intersection node value is: " + intersectNode.val);
		}  else
			System.out.println("No intersection");
		ListNode intersectNode2 = getIntersectionNode(l4, l5);
		if (intersectNode2 != null) {
			System.out.println("The intersection node value is: " + intersectNode2.val);
		} else
			System.out.println("No intersection");
		ListNode intersectNode3 = getIntersectionNode(l5, l6);
		if (intersectNode3 != null) {
			System.out.println("The intersection node value is: " + intersectNode3.val);
		} else
			System.out.println("No intersection");
	}
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode l1 = headA;
		ListNode l2 = headB;
		int aCount = 0, bCount = 0, diff = 0;
		
		// Get count of the nodes in both list;
		while ( l1 != null) {
			aCount++;
			l1 = l1.next;
		}
		while ( l2 != null) {
			bCount++;
			l2 = l2.next;
		}
		diff = Math.abs(aCount - bCount);
		
		l1 = headA;
		l2 = headB;
		// Traverse the bigger list from the first node till the diff nodes
		// so that from here onwards, both the lists have equal no. of nodes.
		if (aCount > bCount) {
			for (int i = 0; i < diff; i++ )
				l1 = l1.next;
		}
		if (aCount < bCount) {
			for (int i = 0; i < diff; i++)
				l2 = l2.next;
		}
		
		while (l1 != null && l1.val != l2.val) {
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if (l1 == null)
			return null;
		else 
			return l1;
		
		
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