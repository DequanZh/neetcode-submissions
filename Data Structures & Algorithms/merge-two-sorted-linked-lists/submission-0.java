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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), temp = dummy;
        ListNode curList1 = list1, curList2 = list2;
        while(curList1 != null && curList2 != null){
            if(curList1.val < curList2.val){
                dummy.next = curList1;
                curList1 = curList1.next;
            }else{
                dummy.next = curList2;
                curList2 = curList2.next;
            }
            dummy = dummy.next;
        }
        while(curList1 != null){
            dummy.next = curList1;
            curList1 = curList1.next;
            dummy = dummy.next;
        }
        while(curList2 != null){
            dummy.next = curList2;
            curList2 = curList2.next;
            dummy = dummy.next;
        }
        return temp.next;
    }
}