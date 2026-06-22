class Solution {

    class Node {
        int sum;
        int i;
        int j;

        Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {

        Arrays.sort(a);
        Arrays.sort(b);

        int n = a.length;

        PriorityQueue<Node> pq =
                new PriorityQueue<>((x, y) -> y.sum - x.sum);

        HashSet<String> visited = new HashSet<>();

        pq.offer(new Node(a[n - 1] + b[n - 1], n - 1, n - 1));
        visited.add((n - 1) + "#" + (n - 1));

        ArrayList<Integer> ans = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {

            Node cur = pq.poll();
            ans.add(cur.sum);

            int i = cur.i;
            int j = cur.j;

            if (i - 1 >= 0) {
                String key = (i - 1) + "#" + j;

                if (!visited.contains(key)) {
                    pq.offer(new Node(a[i - 1] + b[j], i - 1, j));
                    visited.add(key);
                }
            }

            if (j - 1 >= 0) {
                String key = i + "#" + (j - 1);

                if (!visited.contains(key)) {
                    pq.offer(new Node(a[i] + b[j - 1], i, j - 1));
                    visited.add(key);
                }
            }
        }

        return ans;
    }
}