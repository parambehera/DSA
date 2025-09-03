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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue <TreeNode> q = new LinkedList <>();
        List <Double> list = new ArrayList <>();
        if(root==null) return list;
         
         q.add(root);
         while(!q.isEmpty()){
            int size= q.size();
            double sum =0.0;
            for(int i =0;i<size;i++){
                TreeNode curr = q.remove();
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            list.add((double)sum/size);
         }
         return list;
    }
}