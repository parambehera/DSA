class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        // Step 1: Do DFS and push vertices to stack in finishing order
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Step 2: Reverse the graph
        ArrayList<ArrayList<Integer>> revAdj = reverseGraph(adj, V);

        // Step 3: Do DFS using finishing time order on reversed graph
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs2(node, revAdj, visited);
                sccCount++;
            }
        }

        return sccCount;
    }

    // First DFS to fill stack with finishing time
    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, adj, visited, stack);
            }
        }
        stack.push(node);
    }

    // Second DFS on the reversed graph
    private void dfs2(int node, ArrayList<ArrayList<Integer>> revAdj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : revAdj.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, revAdj, visited);
            }
        }
    }

    // Function to reverse the graph
    private ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                revAdj.get(v).add(u);  // Reverse the edge
            }
        }

        return revAdj;
    }
}
