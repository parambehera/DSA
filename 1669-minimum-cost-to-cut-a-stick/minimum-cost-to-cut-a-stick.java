import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for (int cut : cuts) {
            list.add(cut);
        }
        list.add(0);
        list.add(n);
        Collections.sort(list);

        int m = list.size();
        int[][] dp = new int[m][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(1, m - 2, list, dp);
    }

    public int helper(int i, int j, List<Integer> list, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int idx = i; idx <= j; idx++) {
            int cost = list.get(j + 1) - list.get(i - 1)
                     + helper(i, idx - 1, list, dp)
                     + helper(idx + 1, j, list, dp);
            minCost = Math.min(minCost, cost);
        }

        dp[i][j] = minCost;
        return minCost;
    }
}
