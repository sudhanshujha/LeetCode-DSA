// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int num = 0;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        temp = head;
        while(n>=0 && temp!=null){
            num += temp.val*(Math.pow(2,n-1));
            temp = temp.next;
            n--;
        }
        return num;
        
    }
}