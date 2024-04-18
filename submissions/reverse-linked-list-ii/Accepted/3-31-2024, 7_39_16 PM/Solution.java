// https://leetcode.com/problems/reverse-linked-list-ii

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1); // Dummy node to handle case when left = 1
        dummy.next = head;
        ListNode prev = dummy; // Pointer to the node before the sublist to be reversed

        // Move prev to the node before the sublist to be reversed
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next; // Pointer to the first node of the sublist to be reversed

        // Reverse the sublist between left and right
        for (int i = left; i < right; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next; // Adjust the next pointer of curr
            nextNode.next = prev.next; // Insert nextNode before prev.next
            prev.next = nextNode; // Update prev.next to nextNode
        }

        return dummy.next; // Return the head of the modified list
    }
}
