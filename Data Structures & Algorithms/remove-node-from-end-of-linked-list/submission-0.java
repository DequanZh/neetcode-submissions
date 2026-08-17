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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            l++;
        }
        if(l == n){
            return head.next;
        }
        int k = l - n - 1;
        cur = head;
        while(k > 0 && cur != null){
            cur = cur.next;
            k--;
        }
        cur.next = cur.next.next;
        return head;
    }
}
