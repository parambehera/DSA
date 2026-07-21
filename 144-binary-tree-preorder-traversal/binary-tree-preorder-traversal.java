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
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> list = new ArrayList<>();
        
        while(root!=null){
            if(root.left==null){
                list.add(root.val);
                root = root.right;
            }
            else{
                TreeNode prev = root.left;
                while(prev.right!=null && prev.right!=root){
                     prev =prev.right;
                }
                if(prev.right==null){
                    prev.right = root;
                    list.add(root.val);
                    root = root.left;
                }else{
                   // list.add(root.val);
                    prev.right = null;
                    root = root.right;
                }
            }

        }
        return list;
    }
}