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
    public List<Integer> inorderTraversal(TreeNode root) {
        List <Integer> list = new ArrayList <>();
        hit(root,list);
        return list;
    }
    public void hit(TreeNode root,List <Integer> list){
        if(root==null){
            return;
        }
        hit(root.left,list);
        int val = root.val;
        list.add(val);
        hit(root.right,list);
    }
}