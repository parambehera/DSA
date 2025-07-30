class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (wt[i - 1] <= j) {
                    take = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n][W];
    }
}
