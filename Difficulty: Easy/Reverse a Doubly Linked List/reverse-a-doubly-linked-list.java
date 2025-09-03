class Solution {
    public Node reverse(Node head) {
        if (head == null) return null;
        Node temp = null;
        Node current = head;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // move to the next node (which is prev in original list)
            current = current.prev;
        }

        // New head is the last non-null node
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }
}
