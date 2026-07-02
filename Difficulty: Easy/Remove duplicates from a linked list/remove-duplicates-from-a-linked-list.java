/* Structure of linked list Node
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node removeDuplicates(Node head) {

        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        Node tHead = head;
        Node temp = head.next;
        set.add(head.data);
        while (temp != null) {
            if (!set.contains(temp.data)) {
                set.add(temp.data);
                tHead.next = temp;
                tHead = temp;
            }
            temp = temp.next;
        }
        // Remove any remaining duplicate links
        tHead.next = null;
        return head;
    }
}