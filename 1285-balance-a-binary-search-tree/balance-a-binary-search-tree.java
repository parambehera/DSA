class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        value(root, list);
        return makeBT(list, 0, list.size() - 1);
    }

    public void value(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        value(root.left, list);
        list.add(root.val);
        value(root.right, list);
    }

    public TreeNode makeBT(ArrayList<Integer> list, int start, int end) {
        
        if (start > end) return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = makeBT(list, start, mid - 1);
        root.right = makeBT(list, mid + 1, end);

        return root;
    }
}
