// https://leetcode.com/problems/merge-two-sorted-lists

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        // Append remaining nodes of list1 or list2
        if (list1 != null) dummy.next = list1;
        else dummy.next = list2;
        // Since we've already iterated through the lists using the while loop, we know that the remaining nodes are already in the correct order, so we just need to properly link them to the merged list.

        return head.next;
    }
}
