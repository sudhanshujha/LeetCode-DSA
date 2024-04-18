// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to rearrange if the list has 0 or 1 node
        }
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;

        // Traverse the list and rearrange nodes
        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd node to the next odd node
            odd = odd.next; // Move odd pointer to the next odd node
            even.next = odd.next; // Link even node to the next even node
            even = even.next; // Move even pointer to the next even node
        }

        // Link the last odd node to the first even node
        odd.next = evenHead;

        return oddHead;
    }
}
