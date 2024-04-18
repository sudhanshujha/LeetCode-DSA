// https://leetcode.com/problems/swap-nodes-in-pairs

class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //prev & curr nodes to reverse links
        ListNode prev = dummy;

        // Iterate till end of linked list
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap pairs
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to the next pair
            prev = first;
        }

        return dummy.next;
    }
}
