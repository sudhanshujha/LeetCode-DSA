// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

class Solution {
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next.next == null) {
            return head.val+head.next.val;
        }
        int max = 0;
        ListNode mid = findMiddle(head);
        ListNode reversedMid = reverseList(mid.next); // Reverse the second half
        
        // Calculate pair sum while traversing both halves
        while (reversedMid != null && head != null) {
            max = Math.max(max, head.val + reversedMid.val);
            head = head.next;
            reversedMid = reversedMid.next;
        }
        
        return max;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To keep track of the node before slow

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // Separate the list at the middle node
        }

        return slow;
    }
}
