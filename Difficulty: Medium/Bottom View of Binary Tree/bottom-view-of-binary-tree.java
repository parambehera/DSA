class Pair {
    Node node;
    int hd;
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.add(new Pair(root, 0));

        int min = 0, max = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // Only add the first node we encounter for this horizontal distance
                map.put(hd, node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
                min = Math.min(min, hd - 1);
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
                max = Math.max(max, hd + 1);
            }
        }

        // Collect nodes in order of their horizontal distance
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}
