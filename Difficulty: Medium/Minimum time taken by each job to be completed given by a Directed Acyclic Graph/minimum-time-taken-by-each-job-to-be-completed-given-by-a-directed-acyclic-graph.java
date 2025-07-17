class Solution {
    public static int[] minimumTime(int n, int m, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(dest);
        }

        return topoSort(graph, n);
    }

    public static int[] topoSort(ArrayList<Integer>[] graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n]; // stores the time each node gets executed
        int[] inDeg = new int[n + 1];

        // Compute indegrees
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int dest = graph[i].get(j);
                inDeg[dest]++;
            }
        }

        // Add all nodes with indegree 0
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
                res[i - 1] = 1; // time starts at 1
            }
        }

        // Process nodes
        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                int dest = graph[curr].get(i);
                inDeg[dest]--;
                if (inDeg[dest] == 0) {
                    q.add(dest);
                    res[dest - 1] = res[curr - 1] + 1;
                }
            }
        }

        return res;
    }
}
