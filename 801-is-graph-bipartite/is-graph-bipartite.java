class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // Fill color array with -1

        for (int j = 0; j < graph.length; j++) {
            if (color[j] == -1) {
                q.add(j);
                color[j] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int i = 0; i < graph[curr].length; i++) {
                        int neigh = graph[curr][i];

                        if (color[neigh] == -1) {
                            color[neigh] = 1 - color[curr];
                            q.add(neigh);
                        } else if (color[neigh] == color[curr]) {
                            return false; // Same color on both sides — not bipartite
                        }
                    }
                }
            }
        }

        return true; // All components are bipartite
    }
}
