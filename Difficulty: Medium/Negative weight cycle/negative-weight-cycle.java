class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, 0); // Set all to 0 to cover all components

        // Step 1: Relax all edges n - 1 times
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Step 2: Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (dist[u] + wt < dist[v]) {
                return 1; // Negative cycle exists
            }
        }

        return 0; // No cycle found
    }
}
