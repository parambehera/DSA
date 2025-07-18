class Pair implements Comparable<Pair> {
    int V;
    int cost;

    public Pair(int V, int cost) {
        this.V = V;
        this.cost = cost;
    }

    public int compareTo(Pair p) {
        return this.cost - p.cost;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int cost = 0;

        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (vis[p.V]) continue; 

            vis[p.V] = true; // ✅ Mark only after confirming it's unvisited
            cost += p.cost;

            for (int[] neighbor : adj.get(p.V)) {
                int dest = neighbor[0];
                int wt = neighbor[1];

                if (!vis[dest]) {
                    q.add(new Pair(dest, wt));
                }
            }
        }

        return cost;
    }
}
