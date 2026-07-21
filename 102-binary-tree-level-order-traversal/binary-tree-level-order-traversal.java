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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List <Integer>> list = new ArrayList <>();
        Queue <List <TreeNode>> q = new LinkedList <>();
        List <TreeNode> l = new ArrayList <>();
        l.add(root);
        q.add(l);
        while(!q.isEmpty() && root!=null){
            List <TreeNode> qlist = q.poll();
            int size = qlist.size();
            List <Integer> res = new ArrayList <>();
            List <TreeNode> li = new ArrayList <>();
            for(int i=0;i<size;i++){
                TreeNode node = qlist.get(i);
                res.add(node.val);
                if(node.left!=null){
                    li.add(node.left);
                }
                if(node.right!=null){
                    li.add(node.right);
                }
            }
            if(!li.isEmpty())
            q.offer(li);
            list.add(res);
        }
        return list;

    }
}