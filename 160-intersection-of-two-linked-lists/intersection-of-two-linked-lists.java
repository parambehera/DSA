/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = size(headA);
        int len2 = size(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        if(len1<len2){
            int diff = len2-len1;
            while(diff!=0){
                tempB = tempB.next;
                diff--;
            }
        }
         if(len1>len2){
            int diff = len1-len2;
            while(diff!=0){
                tempA = tempA.next;
                diff--;
            }
        }
        while(tempA!=null && tempB!=null){
            if(tempA==tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;

    }
    public int size(ListNode list){
        int size =0;
        while(list!=null){
            list = list.next;
            size++;
        }
        return size;
    }
}