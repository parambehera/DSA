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
    int postIndex;
    HashMap <Integer,Integer> map = new HashMap <>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(postorder,0,inorder.length-1);
    }
   public TreeNode buildTree(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int inorderIdx = map.get(rootValue);

        root.right = buildTree(postorder, inorderIdx + 1,end);
        root.left = buildTree(postorder, start,inorderIdx -1);

        return root;
    }
}