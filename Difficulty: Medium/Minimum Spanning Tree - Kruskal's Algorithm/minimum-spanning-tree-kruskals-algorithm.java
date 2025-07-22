import java.util.*;

// Disjoint Set Union (DSU) class
class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        init(n);
    }

    // Initialize each node as its own parent
    public void init(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the representative (with path compression)
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    // Union by rank
    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB) return;

        if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        } else {
            parent[parB] = parA;
            rank[parA]++;
        }
    }
}

// Main class with Kruskal’s algorithm
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // Sort all edges based on weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(V);
        int mstWeight = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            // If u and v are in different components, include this edge
            if (dsu.find(u) != dsu.find(v)) {
                mstWeight += wt;
                dsu.union(u, v);
            }
        }

        return mstWeight;
    }
}
