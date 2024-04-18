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
        
        ListNode evenHead = head.next;  //memoisation as we will need to coonnect it in end  
        ListNode odd = head;    // declaring outside & not in loop as I will need to update odd next with even head after loop
  
        // We will traverse the list using odd & even as i & j and just rearrange next of odd & even nodes
        for (ListNode even = evenHead; even != null && even.next != null; odd = odd.next, even = even.next) {
            odd.next = even.next; // Link odd node to the next odd node
            even.next = odd.next.next; // Link even node to the next even node
        }

        // Link the last odd node to the first even node 
        // Note: even will always be ahead of odd for even * odd size both & we need to update last odd
        odd.next = evenHead;

        return head;
    }
}
