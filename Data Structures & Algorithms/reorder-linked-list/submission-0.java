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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && slow != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode halfHead = reverse(slow);
        ListNode cur = head;
        while(halfHead != null && cur != null){
            ListNode next = cur.next;
            cur.next = halfHead;
            if(next == halfHead) break;
            halfHead = halfHead.next;
            cur.next.next = next;
            cur = next;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head, prv = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prv;
            prv = cur;
            cur = next;
        }
        return prv;
    }
}
