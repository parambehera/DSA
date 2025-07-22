// User function Template for Java
import java.util.*;

class Solution {

    static class Pair {
        int to, weight;
        Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 2: Topological Sort using DFS
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack, adj);
            }
        }

        // Step 3: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Assuming source is node 0

        // Step 4: Relax edges in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(u)) {
                    int v = p.to, wt = p.weight;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 5: Replace unreachable nodes' distance with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    private void topoSort(int node, boolean[] visited, Stack<Integer> stack, List<List<Pair>> adj) {
        visited[node] = true;

        for (Pair neighbor : adj.get(node)) {
            if (!visited[neighbor.to]) {
                topoSort(neighbor.to, visited, stack, adj);
            }
        }

        stack.push(node);
    }
}
