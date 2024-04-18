// https://leetcode.com/problems/reverse-linked-list

// Solve using recursion
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        return solve (head, prev, curr);
    }
    public static ListNode solve (ListNode head, ListNode prev, ListNode curr){
        
        // base
        if(curr == null){
            return prev;
        }

        // swap link bw prev & curr
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        // call for next link
        return solve (head, prev, curr);
    }   
}