import java.util.*;

class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

class Pair implements Comparable<Pair> {
    int v;
    int path;

    public Pair(int v, int path) {
        this.v = v;
        this.path = path;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.path - p2.path;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            graph[u].add(new Edge(u, v, wt));
            // If the graph is undirected, add this:
            // graph[v].add(new Edge(v, u, wt));
        }

        return dijkstraUtil(graph, src, V);
    }

    public int[] dijkstraUtil(ArrayList<Edge>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int curr = p.v;

            // if (vis[curr]) continue;
            vis[curr] = true;

            for (Edge edge : graph[curr]) {
                int next = edge.dest;
                int weight = edge.wt;

                if (!vis[next] && dist[curr] + weight < dist[next]) {
                    dist[next] = dist[curr] + weight;
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }

        return dist;
    }
}
