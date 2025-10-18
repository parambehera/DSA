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
    int val=0;
    public TreeNode bstToGst(TreeNode root) {
        sum(root);
        return root;
    }
    public void sum(TreeNode root){
      if(root==null)return;

      sum(root.right);
      val =val+root.val; 
      root.val = val;
      sum(root.left);
    }
}