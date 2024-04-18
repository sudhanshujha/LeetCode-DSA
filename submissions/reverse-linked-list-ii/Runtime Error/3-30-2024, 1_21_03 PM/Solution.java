// https://leetcode.com/problems/reverse-linked-list-ii

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        if(head.next == null)
            return head;
        while(temp.val != left)
            temp = temp.next;
        // point l-> left ptr to left node
        ListNode l = temp;
        while(temp.val != right)
            temp = temp.next;
        // swapping of left & rightvalues
        int x = l.val;
        l.val = temp.val;
        temp.val = x;
        return head;
    }
}