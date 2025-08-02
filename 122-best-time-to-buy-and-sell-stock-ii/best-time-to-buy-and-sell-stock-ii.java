// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         // Initialize dp with -1
//         for (int i = 0; i < n; i++) {
//             dp[i][0] = -1;
//             dp[i][1] = -1;
//         }
//         return helper(0, 0, dp, prices);
//     }

//     public int helper(int idx, int buy, int[][] dp, int[] prices) {
//         if (idx == prices.length) return 0;

//         if (dp[idx][buy] != -1) return dp[idx][buy];

//         int profit;

//         if (buy == 0) {
//             // You can buy or skip
//             int buyNow = -prices[idx] + helper(idx + 1, 1, dp, prices);
//             int skip = helper(idx + 1, 0, dp, prices);
//             profit = Math.max(buyNow, skip);
//         } else {
//             // You can sell or skip
//             int sellNow = prices[idx] + helper(idx + 1, 0, dp, prices);
//             int skip = helper(idx + 1, 1, dp, prices);
//             profit = Math.max(sellNow, skip);
//         }

//         return dp[idx][buy] = profit;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // dp[i][buy]

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    // Option to buy or skip
                    dp[i][buy] = Math.max(
                        -prices[i] + dp[i + 1][1], // buy now
                        dp[i + 1][0]               // skip
                    );
                } else {
                    // Option to sell or skip
                    dp[i][buy] = Math.max(
                        prices[i] + dp[i + 1][0], // sell now
                        dp[i + 1][1]              // skip
                    );
                }
            }
        }

        return dp[0][0]; // Start from day 0 with permission to buy
    }
}
