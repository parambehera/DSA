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
    public int minDepth(TreeNode root) {
        int ans = minDepthHelper(root);
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
    public int minDepthHelper(TreeNode root){
         if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        
        int left = minDepthHelper(root.left);
        int right = minDepthHelper (root.right);

        return Math.min(left,right)+1;
    }
}