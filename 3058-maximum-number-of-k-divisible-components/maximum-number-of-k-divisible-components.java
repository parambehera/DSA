class Solution {
    int cnt = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(0, -1, g, values, k);
        return cnt;
    }

    private long dfs(int node, int parent, List<Integer>[] g, int[] values, int k) {
        long sum = values[node];

        for (int nei : g[node]) {
            if (nei == parent) continue;
            sum += dfs(nei, node, g, values, k);
        }

        if (sum % k == 0) {
            cnt++;
            return 0;
        }

        return sum;
    }
}
