class Solution {
    boolean isBST(Node root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean check(Node root, long min, long max) {
        if (root == null) return true;

        // If root is outside allowed range, not a BST
        if (root.data <= min || root.data >= max) return false;

        // Check left and right with updated ranges
        return check(root.left, min, root.data) &&
               check(root.right, root.data, max);
    }
}
