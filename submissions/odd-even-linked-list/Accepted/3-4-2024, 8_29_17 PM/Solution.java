// https://leetcode.com/problems/odd-even-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to rearrange if the list has 0 or 1 node
        }

        ListNode odd = head; // Pointer for odd nodes
        ListNode even = head.next; // Pointer for even nodes
        ListNode evenHead = even; // Store the head of even nodes

        // Traverse the list using odd & even pointers
        while (even != null && even.next != null) {
            // Link odd node to the next odd node
            odd.next = even.next;
            // Move odd pointer to the next odd node
            odd = odd.next;
            // Link even node to the next even node
            even.next = odd.next;
            // Move even pointer to the next even node
            even = even.next;
        }

        // Link the last odd node to the first even node
        odd.next = evenHead;

        return head;
    }
}