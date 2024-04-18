// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head) {
        // Dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // prev node to track the position before the pair
        ListNode prev = dummy;

        // Iterate over the list in pairs
        while (head != null && head.next != null) {
            // Nodes to swap
            ListNode first = head;
            ListNode second = head.next;

            // Swap the pair
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers to the next pair
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
