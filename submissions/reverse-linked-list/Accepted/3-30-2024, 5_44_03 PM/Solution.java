// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize previous node
        ListNode curr = head; // Start from the head of the list
        ListNode temp;
        // Traverse the list, reversing the pointers
        while (curr != null) {
            temp = curr.next; // Store the next node
            curr.next = prev; // Reverse the pointer
            prev = curr; // Move previous to current
            curr = temp; // Move current to next
        }

        head = prev; // Update the head of the list
        return head;
    }
}
