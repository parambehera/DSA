class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2]; // +2 to avoid index out of bounds for dp[i+2]

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 1) {
                    dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    dp[i][buy] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
                }
            }
        }

        return dp[0][1]; // start with buy = 1 (you can buy on day 0)
    }
}
