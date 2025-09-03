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
    ArrayList <Integer>preorderl = new ArrayList <>();
    public int getMinimumDifference(TreeNode root) {
         preorder(root);
         Collections.sort(preorderl);
         int minDiff = Integer.MAX_VALUE;
        for(int i =0;i<preorderl.size()-1;i++){
            int diff =Math.abs(preorderl.get(i)-preorderl.get(i+1));
            minDiff = Math.min(diff,minDiff);
        }
        return minDiff;
    }
    public  void preorder(TreeNode root){
        while(root==null) return;
        preorderl.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    
}