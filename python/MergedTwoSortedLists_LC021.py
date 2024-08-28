"""
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
    (1) --> (2) --> (4)
    (1) --> (3) --> (4)

    ==>
    (1)-->(1)-->(2)-->(3)-->(4)-->(4)
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.


"""
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MergedTwoSortedLists_LC021:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = mergedlist = ListNode()
        

        while list1 and list2:
            print(list1.val, " ", list2.val)
            if list1.val < list2.val :
                mergedlist.next = list1
                list1 = list1.next
            else:
                mergedlist.next = list2
                list2 = list2.next
            mergedlist = mergedlist.next

        mergedlist.next =  list1 or list2
        return dummy.next


list1 = ListNode(1)
list1.next = ListNode(2)
list1.next.next = ListNode(6)
list1.next.next.next = ListNode(8)
        
list2 = ListNode(3)
list2.next = ListNode(4)
list2.next.next = ListNode(5)

list3 = []
list4 = []

list5 = []
list6 = ListNode(0)

myTest = MergedTwoSortedLists_LC021()
#mergedList = myTest.mergeTwoLists(list1, list2)
#mergedList = myTest.mergeTwoLists(list3, list4)
mergedList = myTest.mergeTwoLists(list5, list6)



while mergedList:
    print(mergedList.val , end=' ')
    mergedList = mergedList.next

