class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (wt[i - 1] <= j) {
                    take = dp[i][j - wt[i - 1]] + val[i - 1]; // reuse same item
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }

        return dp[n][capacity];
    }
}
