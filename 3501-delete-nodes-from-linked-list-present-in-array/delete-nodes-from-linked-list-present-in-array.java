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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet <Integer> set = new HashSet <>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ListNode temp = head;
        ListNode dummy =new ListNode(-1);
        ListNode prev = dummy;
        temp = head;
        while(temp!=null){
            if(!set.contains(temp.val)){
                 prev.next = temp;
                 prev = prev.next;
            }
            temp = temp.next;
        }
        prev.next= null;
        return dummy.next;
    }
}