// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No middle node to delete
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null; // To keep track of the node before slow

        // Move slow by one step and fast by two steps until fast reaches the end
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now, slow is pointing to the middle node
        // Delete the middle node by modifying the next pointer of the node before it
        temp.next = slow.next;

        return head; // Return the head of the modified list
    }
}
