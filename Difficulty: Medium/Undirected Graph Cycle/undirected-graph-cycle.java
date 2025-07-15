class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<Integer>[] arr = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            arr[i] = new ArrayList<>();
        }

        // Since it's an undirected graph, add both ways
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            arr[src].add(dest);
            arr[dest].add(src);
        }

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(arr, i, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(ArrayList<Integer>[] arr, int start, boolean[] vis, int par) {
        vis[start] = true;

        for (int neigh : arr[start]) {
            if (!vis[neigh]) {
                if (dfs(arr, neigh, vis, start)) {
                    return true;
                }
            } else if (neigh != par) {
                return true;
            }
        }

        return false;
    }
}
