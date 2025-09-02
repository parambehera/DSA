import java.util.*;

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                if (prev != null) {
                    prev.next = node; // link previous node to current
                }
                prev = node;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            // last node in each level automatically points to null
        }

        return root;
    }
}
