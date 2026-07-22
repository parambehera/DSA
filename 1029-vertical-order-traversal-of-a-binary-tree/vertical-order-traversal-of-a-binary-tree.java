class Solution {

    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple cur = q.poll();

            map.putIfAbsent(cur.col, new TreeMap<>());

            map.get(cur.col).putIfAbsent(cur.row, new PriorityQueue<>());

            map.get(cur.col).get(cur.row).offer(cur.node.val);

            if (cur.node.left != null) {
                q.offer(new Tuple(cur.node.left,
                                  cur.row + 1,
                                  cur.col - 1));
            }

            if (cur.node.right != null) {
                q.offer(new Tuple(cur.node.right,
                                  cur.row + 1,
                                  cur.col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}