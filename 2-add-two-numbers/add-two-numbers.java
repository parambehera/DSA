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
        ListNode dummy = new ListNode(0);  // start node
        ListNode curr = dummy;             // pointer to build result

        int carry = 0;

        // run while any digit exists or carry exists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // create new node with sum % 10 (digit)
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // update carry
            carry = sum / 10;
        }

        return dummy.next;
    }
}
