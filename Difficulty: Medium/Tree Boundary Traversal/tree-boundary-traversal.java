import java.util.*;

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null) return res;

        // root should be added (if not leaf)
        if (node.left != null || node.right != null) {
            res.add(node.data);
        }

        // 1. Left boundary
        left(res, node.left);

        // 2. Leaf nodes
        leaf(res, node);

        // 3. Right boundary
        right(res, node.right);

        return res;
    }

    // Traverse left boundary (excluding leaves)
    void left(ArrayList<Integer> res, Node root) {
        while (root != null) {
            if (root.left != null || root.right != null) {
                res.add(root.data);
            }
            if (root.left != null) root = root.left;
            else root = root.right;
        }
    }

    // Collect leaf nodes
    void leaf(ArrayList<Integer> res, Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.data);
            return;
        }
        leaf(res, root.left);
        leaf(res, root.right);
    }

    // Traverse right boundary (excluding leaves, reversed)
    void right(ArrayList<Integer> res, Node root) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (root != null) {
            if (root.left != null || root.right != null) {
                temp.add(root.data);
            }
            if (root.right != null) root = root.right;
            else root = root.left;
        }
        // Add in reverse
        for (int j = temp.size() - 1; j >= 0; j--) {
            res.add(temp.get(j));
        }
    }
}
