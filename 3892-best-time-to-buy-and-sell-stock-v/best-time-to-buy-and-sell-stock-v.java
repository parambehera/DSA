class Solution {

    static final long NEG_INF = -1000000000000000L; // safe sentinel
    static long dp[][][];

    public long maximumProfit(int[] prices, int k) {
        dp = new long[prices.length][k + 1][3];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int c = 0; c < 3; c++) {
                    dp[i][j][c] = NEG_INF;
                }
            }
        }
        return recur(prices, k, 0, 0);
    }

    public long recur(int prices[], int k, int idx, int cases) {

        if (idx >= prices.length) {
            return (cases == 0) ? 0 : NEG_INF;
        }

        if (dp[idx][k][cases] != NEG_INF) return dp[idx][k][cases];

        long take = NEG_INF;
        long notTake = recur(prices, k, idx + 1, cases);

        if (k > 0) {
            if (cases == 2) {
                take = prices[idx] + recur(prices, k - 1, idx + 1, 0);
            } else if (cases == 1) {
                take = -prices[idx] + recur(prices, k - 1, idx + 1, 0);
            } else {
                take = Math.max(
                        -prices[idx] + recur(prices, k, idx + 1, 2),
                        prices[idx] + recur(prices, k, idx + 1, 1)
                );
            }
        }

        return dp[idx][k][cases] = Math.max(take, notTake);
    }
}
