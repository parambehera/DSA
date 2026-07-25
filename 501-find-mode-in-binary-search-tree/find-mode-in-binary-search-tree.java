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

    TreeNode prev = null;
    int currCount = 0;
    int maxCount = 0;
    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);

        // Update frequency
        if (prev != null && prev.val == root.val) {
            currCount++;
        } else {
            currCount = 1;
        }

        // Update answer
        if (currCount > maxCount) {
            maxCount = currCount;
            ans.clear();
            ans.add(root.val);
        } else if (currCount == maxCount) {
            ans.add(root.val);
        }

        prev = root;

        inorder(root.right);
    }
}