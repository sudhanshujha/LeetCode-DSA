// https://leetcode.com/problems/delete-node-in-a-linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
     /*
        copy data of next in the node to be deleted
        update next of the ptr with next to next address
     */   
        node.data=node.next.data;
        node.next=node.next.next;
        
    }
}