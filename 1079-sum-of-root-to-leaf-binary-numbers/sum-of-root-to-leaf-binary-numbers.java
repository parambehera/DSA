class Solution {
    
    int sum = 0;   // no need static
    
    public int sumRootToLeaf(TreeNode root) {
        getAll(new StringBuilder(), root);
        return sum;
    }
    
    public void getAll(StringBuilder sb, TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        // add current node value
        sb.append(root.val);
        
        // check if leaf node
        if (root.left == null && root.right == null) {
            int num = Integer.parseInt(sb.toString(), 2);
            sum += num;
        } else {
            // go left
            getAll(sb, root.left);
            
            // go right
            getAll(sb, root.right);
        }
        
        // backtrack
        sb.deleteCharAt(sb.length() - 1);
    }
}