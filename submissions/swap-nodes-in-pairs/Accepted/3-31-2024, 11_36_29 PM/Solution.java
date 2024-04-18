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
        ListNode dummy = new ListNode(-1); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy;

        // Iterate over the list in pairs
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the pair
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move prev pointer to the next pair
            prev = first;
        }

        return dummy.next; // Return the head of the modified list
    }
}
