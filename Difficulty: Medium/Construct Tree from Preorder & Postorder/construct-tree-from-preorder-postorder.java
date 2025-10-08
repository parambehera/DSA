/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node constructTree(int[] pre, int[] post) {
        int n = pre.length;
        return solve(0, n - 1, 0, n - 1, pre, post);
    }

    private Node solve(int preStart, int preEnd, int postStart, int postEnd, int[] pre, int[] post) {
        // base case
        if (preStart > preEnd || postStart > postEnd) return null;

        // create root node
        Node root = new Node(pre[preStart]);

        // if only one node, return it
        if (preStart == preEnd) return root;

        // next element in preorder is the left child (if exists)
        int nextNode = pre[preStart + 1];

        // find that node in postorder to determine left subtree size
        int j = postStart;
        while (j <= postEnd && post[j] != nextNode) {
            j++;
        }

        int numLeft = j - postStart + 1; // number of nodes in left subtree

        // recursive build
        root.left = solve(preStart + 1, preStart + numLeft, postStart, j, pre, post);
        root.right = solve(preStart + numLeft + 1, preEnd, j + 1, postEnd - 1, pre, post);

        return root;
    }
}
