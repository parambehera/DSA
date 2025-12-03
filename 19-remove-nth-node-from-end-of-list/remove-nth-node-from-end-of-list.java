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
        int size = len(head,n);
        int comp = size-n;
        ListNode temp = head;
        if(temp.next==null){
            return null;
        }
        while(comp>1){
          temp = temp.next;
          comp--;
        }
        if(comp==0){
            return head.next;
        }
        if(temp.next==null){
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }
    public int len(ListNode head,int n){
        int size =0;
        while(head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
}