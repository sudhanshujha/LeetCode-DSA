// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        int i = 1;
        if(head.next == null)
            return head;
        while(i != left){
            if(temp.next==null)
                return head;
            temp = temp.next;
            i++;
        }
        // point l-> left ptr to left node
        ListNode l = temp;
        System.out.print(temp.val);
        while(i != right){
            if(temp.next==null)
                return head;
            temp = temp.next;
            i++;
        }
        System.out.print(temp.val);
        // swapping of left & rightvalues
        int x = l.val;
        l.val = temp.val;
        temp.val = x;
        return head;
    }
}