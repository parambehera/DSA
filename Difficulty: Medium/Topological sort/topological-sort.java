import java.util.*;

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Step 1: Build graph
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Step 2: Add edges
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].add(dest);
        }

        // Step 3: Call Kahn's algorithm
        return kahnTopoSort(graph, V);
    }

    public static ArrayList<Integer> kahnTopoSort(ArrayList<Integer>[] graph, int V) {
        int[] indegree = new int[V];
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Compute in-degrees
        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                indegree[v]++;
            }
        }

        // Step 2: Enqueue all nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: Process the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Optional: If result size != V, the graph has a cycle
        if (result.size() != V) {
            System.out.println("Cycle detected. Topological sort not possible.");
            return new ArrayList<>();
        }

        return result;
    }
}
