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

    class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long min = q.peek().idx;      // First index of current level

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                // Normalize the index
                long currIdx = p.idx - min;

                if (i == 0)
                    first = currIdx;

                if (i == size - 1)
                    last = currIdx;

                if (p.node.left != null) {
                    q.offer(new Pair(p.node.left, 2 * currIdx + 1));
                }

                if (p.node.right != null) {
                    q.offer(new Pair(p.node.right, 2 * currIdx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }

        return maxWidth;
    }
}