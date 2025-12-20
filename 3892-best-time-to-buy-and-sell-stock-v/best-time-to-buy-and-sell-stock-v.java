class Solution {

    static final long NEG_INF = -1000000000000000L; // -1e15

    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;

        long dp[][][] = new long[n + 1][k + 1][3];

        // initialize
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int c = 0; c < 3; c++) {
                    dp[i][j][c] = NEG_INF;
                }
            }
        }

        // base case: at end with no pending case
        for (int j = 0; j <= k; j++) {
            dp[n][j][0] = 0;
        }

        // fill reverse: idx n-1 → 0
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int rem = 0; rem <= k; rem++) {

                for (int cases = 0; cases < 3; cases++) {

                    long notTake = dp[idx + 1][rem][cases];
                    long take = NEG_INF;

                    if (rem > 0) {

                        if (cases == 2) {
                            // sell → go to free
                            take = prices[idx] + dp[idx + 1][rem - 1][0];
                        }
                        else if (cases == 1) {
                            // buy → go to free
                            take = -prices[idx] + dp[idx + 1][rem - 1][0];
                        }
                        else {
                            // free → choose buy or sell
                            long option1 = -prices[idx] + dp[idx + 1][rem][2];
                            long option2 = prices[idx] + dp[idx + 1][rem][1];
                            take = Math.max(option1, option2);
                        }
                    }

                    dp[idx][rem][cases] = Math.max(take, notTake);
                }
            }
        }

        return dp[0][k][0];
    }
}
