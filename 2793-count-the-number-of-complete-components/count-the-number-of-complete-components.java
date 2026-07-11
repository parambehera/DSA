import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Create adjacency list to represent the graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph (since it's undirected, add both directions)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // Array to track visited nodes
        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Loop through all nodes to check for unvisited components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                int edgeCount = bfs(graph, i, visited, component);

                // Check if the component is complete
                int size = component.size();
                int expectedEdges = (size * (size - 1)) / 2;

                // If the actual edges match expected edges, it is a complete component
                if (edgeCount / 2 == expectedEdges) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    // BFS to count edges and find all nodes in the component
    private int bfs(List<Integer>[] graph, int start, boolean[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        component.add(start);

        int edgeCount = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                edgeCount++; // Count each edge
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    component.add(neighbor);
                }
            }
        }

        return edgeCount;
    }
}
