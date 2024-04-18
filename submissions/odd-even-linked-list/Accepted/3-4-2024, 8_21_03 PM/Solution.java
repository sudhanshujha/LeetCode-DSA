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

        ListNode evenHead = head.next; // memoisation to use in end
        ListNode odd = head; // declaring outside/memoisation & not in loop to use in end of loop

        // We will traverse the list using odd & even as i & j and just rearrange 
        for (ListNode even = head.next; even != null && even.next != null; odd = odd.next, even = even.next) {
            odd.next = odd.next.next; // Link odd node to the next odd node
            even.next = even.next.next; // Link even node to the next even node
        }

        // Note: even will always be ahead of odd for all even or odd size both
        // Link the last odd node to the first even node
        odd.next = evenHead;

        return head;
    }
}
