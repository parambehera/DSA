/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int min = Integer.MAX_VALUE, prev = -1;

    private void find(TreeNode root) {
        if (root == null)
            return;
        find(root.left);
        if (prev >= 0 && min > root.val - prev)
            min = root.val - prev;
        prev = root.val;
        find(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }
}