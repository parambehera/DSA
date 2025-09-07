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
    public ListNode mergeKLists(ListNode[] lists) {
    int n  = lists.length;
    ListNode temp = new ListNode(-1);
    if(n==0) return null;
    if(n==1)return lists[0];
    ListNode h = merge(lists[0],lists[1]);
    for(int i =2;i<lists.length;i++){
       h = merge(lists[i],h);
    }
    return h;
    }
    public ListNode merge(ListNode l1,ListNode l2 ){
      ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else if (l2 != null) {
            temp.next = l2;
        }
        
        return dummy.next;
     
    }
}