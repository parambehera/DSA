class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<Integer>[] arr = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            arr[src].add(dest);
        }

        boolean[] vis = new boolean[V];
        boolean[] stack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycle(arr, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<Integer>[] arr, int node, boolean[] vis, boolean[] stack) {
        vis[node] = true;
        stack[node] = true;

        for (int neighbor : arr[node]) {
            if (stack[neighbor]) {
                return true;
            }
            if (!vis[neighbor]) {
                if (isCycle(arr, neighbor, vis, stack)) {
                    return true;
                }
            }
        }

        stack[node] = false;
        return false;
    }
}
