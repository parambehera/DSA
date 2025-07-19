class Solution {
    boolean graphColoring(int V, int[][] edges, int m) {
        // code here
           // Build adjacency list
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]); // Undirected graph
        }

        int[] color = new int[V]; // 0 means uncolored

        return solve(0, graph, color, m, V);
    }

    private boolean solve(int node, ArrayList<Integer>[] graph, int[] color, int m, int V) {
        if (node == V) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, c)) {
                color[node] = c;
                if (solve(node + 1, graph, color, m, V)) return true;
                color[node] = 0; // Backtrack
            }
        }

        return false;
    }

    private boolean isSafe(int node, ArrayList<Integer>[] graph, int[] color, int c) {
        for (int neighbor : graph[node]) {
            if (color[neighbor] == c) return false;
        }
        return true;
    }

    }
