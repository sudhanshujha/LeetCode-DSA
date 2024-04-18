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
        int n = getListSize(temp);
        
        while(temp!=null){  // n>=0
            num += temp.val*(int)Math.pow(2,n-1);   // typecasting
            temp = temp.next;
            n--;
        }
        return num;   
    }
    public int getListSize(ListNode temp){
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        return n;
    }
}