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
    StringBuilder sb = new StringBuilder();
    ArrayList<String> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        helper(root);
        int sum = 0;
        for (String num : list) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        // choose
        sb.append(root.val);

        // if leaf → store the path number
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }

        // explore children
        helper(root.left);
        helper(root.right);

        // un-choose (backtrack)
        sb.deleteCharAt(sb.length() - 1);
    }
}
