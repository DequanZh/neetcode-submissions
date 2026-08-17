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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), result = dummy;
        ListNode cur1 = l1, cur2 = l2;
        int carry = 0, sum = 0;
        while(cur1 != null && cur2 != null){
            sum = cur1.val + cur2.val + carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1 != null){
            sum = cur1.val + carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            cur1 = cur1.next;
        }
        while(cur2 != null){
            sum = cur2.val + carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            cur2 = cur2.next;
        }
        if(carry > 0){
            dummy.next = new ListNode(carry);
        }
        return result.next;
    }
}
