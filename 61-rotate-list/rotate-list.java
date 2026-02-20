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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        
     int len = size(head);
     ListNode lastNode = getLastNode(head);
     if(k>=len){
        k = k%len;
     }
     if(k==0)
        return head;
     int comp = len-k;
     ListNode temp =head;
     while(comp>1){
        temp = temp.next;
        comp--;
     }
    ListNode newHead  =temp.next;
      lastNode.next = head;
     temp.next = null;
     return newHead;

    }
    public int size(ListNode head){
        int size =0;
        while(head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
    public ListNode getLastNode(ListNode head){
        while(head.next!=null){
            head = head.next;
        }
        return head;
    }
}